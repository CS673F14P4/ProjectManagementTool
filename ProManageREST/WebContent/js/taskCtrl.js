/**
 * 
 */

angular
		.module('promanage')
		.controller(
				"NewTaskCtrl",
				function($scope, $http, $modalInstance, item, $location, $window) {

					$scope.task = {};

					$scope.owner;
					$scope.members;

					// get members
					$http(
							{
								method : 'Get',
								url : 'http://localhost:8080/ProManageREST/jaxrs/project/'
										+ item.projectId + '/member'
							})

					.success(function(data) {
						$scope.members = data;
						// set the owner as the first
						$scope.owner = $scope.members[0];
						// needs to be called after get members to choose the
						// owner
						getTask();

					})

					.error(function(data, status, headers, config) {
						$location.path("/errormsg");
					});

					// get all the information of task if id >0
					function getTask() {
						if (item.taskId > 0) {
							$http(
									{
										method : 'GET',
										url : 'http://localhost:8080/ProManageREST/jaxrs/project/'
												+ item.projectId
												+ '/story/'
												+ item.storyId
												+ '/task/'
												+ item.taskId
									})

									.success(
											function(data) {
												console.log(data);
												$scope.task = data;
												$scope.task.dueDate = (new Date(
														$scope.task.dueDate));
												$scope.task.createDate = (new Date(
														$scope.task.createDate));
												$scope.task.lastModifiedDate = (new Date(
														$scope.task.lastModifiedDate));

												// select the correct owner
												console.log('members'
														+ $scope.members);
												if ($scope.members) {
													for (var i = 0; i < $scope.members.length; i++) {
														if ($scope.members[i].userId === $scope.task.owner) {
															$scope.owner = $scope.members[i];
														}
													}
												}
											})

									.error(
											function(data, status, headers,
													config) {
												$location.path("/errormsg");
								});
						}else{
							// initialize form
							var currentTime = new Date();
							$scope.task = {'name':'Task', 'description':'Description of task.', 'dueDate': currentTime};
						}
					}

					$scope.cancel = function() {
						$modalInstance.dismiss('cancel');
					}
					
					/* reset form */
					$scope.reset = function() {
						$scope.task = {};
					}
					
					$scope.submit = function() {

						$scope.task.dueDate = (new Date($scope.task.dueDate));
						$scope.task.owner = $scope.owner.userId;

						console.log('data task');
						console.log($scope.task);
						if (item.taskId > 0) {
							// edit task
							$http(

									{
										method : 'PUT',
										url : 'http://localhost:8080/ProManageREST/jaxrs/project/'
												+ item.projectId
												+ '/story/'
												+ item.storyId + '/task/',
										data : JSON.stringify($scope.task),
										headers : {
											'Content-Type' : 'application/json'
										}
									})

							.success(function(data) {
								// close modal if it worked
								$modalInstance.close();
							})

							.error(function(data, status, headers, config) {
								$window.alert("Sorry, we have a problem. Please try again later.");
							});
						} else {
							// create task
							$scope.task.storyId = item.storyId;
							$http(

									{
										method : 'POST',
										url : 'http://localhost:8080/ProManageREST/jaxrs/project/'
												+ item.projectId
												+ '/story/'
												+ item.storyId + '/task/',
										data : JSON.stringify($scope.task),
										headers : {
											'Content-Type' : 'application/json'
										}
									})

							.success(function(data) {
								// close modal if it worked
								$modalInstance.close();
							})

							.error(function(data, status, headers, config) {
								$window.alert("Sorry, we have a problem. Please try again later.");
							});

						}
					}

				});