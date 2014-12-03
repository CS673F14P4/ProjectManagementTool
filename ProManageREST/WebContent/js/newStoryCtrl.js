/**
 * 
 */
angular
		.module('promanage')
		.controller(
				"NewStoryCtrl",
				function($scope, $http, $modalInstance, item) {

					console.log(item);

					// initialize form
					var currentTime = new Date();
					$scope.story = {
						'name' : 'Story',
						'description' : 'As an user I want...',
						'dueDate' : currentTime
					};

					/* reset form */
					$scope.reset = function() {
						$scope.story = {};
					}

					$scope.storyId = item.storyId;
					$scope.projectId = item.projectId;

					// edit form - get story
					if ($scope.storyId > 0) {

						$http(
								{
									method : 'GET',
									url : 'http://localhost:8080/ProManageREST/jaxrs/project/'
											+ item.projectId
											+ '/story/'
											+ $scope.storyId
								})

						.success(
								function(data) {
									console.log(data);
									$scope.story = data;
									$scope.story.dueDate = (new Date(
											$scope.story.dueDate));
								})

						.error(function(data, status, headers, config) {
							console.log('error');
						});

					}

					// use this when owner is added in the database
					$scope.users = [ {
						name : 'Joahn'
					}, {
						name : 'Pedro'
					} ];
					$scope.selected_notify = $scope.users[0];
					$scope.selected_asigned = $scope.users[0];

					$scope.cancel = function() {
						$modalInstance.dismiss('cancel');
					};

					// send form
					$scope.submit = function() {

						console.log($scope.story);
						$scope.story.dueDate = (new Date($scope.story.dueDate));
						$scope.story.projectid = item.projectId;

						if ($scope.storyId > 0) {
							// edit story
							$http(

									{
										method : 'PUT',
										url : 'http://localhost:8080/ProManageREST/jaxrs/project/'
												+ item.projectId + '/story/',
										data : JSON.stringify($scope.story),
										headers : {
											'Content-Type' : 'application/json'
										}
									})

							.success(function(data) {
								// close modal if it worked
								$modalInstance.close();
							})

							.error(function(data, status, headers, config) {
								console.log('error');
							});

						} else {
							// new story

							$http(
									{
										method : 'POST',
										url : 'http://localhost:8080/ProManageREST/jaxrs/project/'
												+ item.projectId + '/story/',
										data : JSON.stringify($scope.story),
										headers : {
											'Content-Type' : 'application/json'
										}
									})

							.success(function(data) {
								// close modal if it worked
								$modalInstance.close();

							})

							.error(function(data, status, headers, config) {
								console.log('error');
							});
						}

					}

				})
