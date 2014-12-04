/**
 * 
 */
angular
		.module('promanage')
		.controller(
				"ProjectViewCtrl",
				function($scope, $routeParams, $http, $rootScope, $modal, $location, $window) {

					$rootScope.pageTitle = "Project Detail";
					console.log($rootScope.pageTitle);

					$scope.projectId = $routeParams.projectId;
					
					// needs to be previous setup to have status and userStories
					// list
					$scope.project = {
						"description" : "",
						"name" : "",
						"idproject" : $routeParams.projectId,
						"startDate" : "",
						"endDate" : "",
						"status" : [ {
							"name" : "Backlog",
							"userStories" : []

						}, {
							"name" : "Current",
							"userStories" : []
						}, {
							"name" : "Done",
							"userStories" : []
						} ]

					};

					// get project from service
					$http(
							{
								method : 'Get',
								url : 'http://localhost:8080/ProManageREST/jaxrs/project/'
										+ $scope.projectId
							}).success(function(data) {

						// update the project attributes
						$scope.project.name = data.name;
						$scope.project.description = data.description;
						$scope.project.startDate = data.startDate;
						$scope.project.endDate = data.endDate;
						if (data.status == "closed"){
							$scope.statusFlag = false;
						}else{
							$scope.statusFlag = true;
						}

					}).error(function(data, status, headers, config) {
						$location.path("/errormsg");
					});

					getStories();

					function getStories() {
						// make sure all the status are empty before getting
						// stories from service
						$scope.project.status[0].userStories = [];
						$scope.project.status[1].userStories = [];
						$scope.project.status[2].userStories = [];
						// get stories from services
						$http(
								{
									method : 'Get',
									url : 'http://localhost:8080/ProManageREST/jaxrs/project/'
											+ $scope.projectId + '/story'
								})
								.success(
										function(data) {
											console.log(data);
											for (var i = 0; i < data.length; i++) {
												story = data[i];
												// put the story in the correct
												// status list
												stories = $scope.project.status[story.status].userStories;
												stories.push(story);
											}
										})
								.error(function(data, status, headers, config) {
									$location.path("/errormsg");
								});
					}
					// Get the tasks by StoryId
					$scope.acord = function(storyId, statusIndex, storyIndex) {

						tasks = $scope.project.status[statusIndex].userStories[storyIndex].tasks;

						// just do something if the element is collapsed and the
						// , otherwise return
						if (!$("#title" + storyId).hasClass("collapsed")) {
							return;
						}
						
						getTasks(storyId,statusIndex,storyIndex);
						

					}
					
					function getTasks(storyId,statusIndex,storyIndex){
						// show spinner
						$("#spinner" + storyId).show();

						$http(
								{
									method : 'Get',
									url : 'http://localhost:8080/ProManageREST/jaxrs/project/'
											+ $scope.projectId
											+ '/story/'
											+ storyId + '/task'
								})
								.success(
										function(data) {
											// put the task list in the correct
											// story
											$scope.project.status[statusIndex].userStories[storyIndex].tasks = data;
											$("#spinner" + storyId).hide();
										})
								.error(function(data, status, headers, config) {
									$("#spinner" + storyId).hide();
									$location.path("/errormsg");
								});
					}

					$scope.updateStatus = function(statusIndex, storyIndex) {
						story = $scope.project.status[statusIndex].userStories[storyIndex];

						// status + 1, so if it's in backlog (0) it will be in
						// current (1)
						story.status = story.status + 1;

						$http(
								{
									method : 'PUT',
									url : 'http://localhost:8080/ProManageREST/jaxrs/project/'
											+ story.projectid + '/story',
									data : JSON.stringify(story),
									headers : {
										'Content-Type' : 'application/json'
									}

								})

								.success(
										function(data) {
											// update list of stories to reflect
											// change in data
											$scope.project.status[statusIndex].userStories
													.splice(storyIndex, 1);
											$scope.project.status[statusIndex + 1].userStories
													.push(story);

										})

								.error(function(data, status, headers, config) {
									$location.path("/errormsg");

								});
					}

					// open modal Story
					$scope.openModalNewSotry = function(storyId) {

						var modalInstance = $modal.open({
							templateUrl : 'modalNewStory.html',
							controller : 'NewStoryCtrl',
							size : 'lg',
							// pass object to NewStoryCtrl
							resolve : {
								item : function() {
									item = {
										projectId : $scope.projectId,
										storyId : storyId
									};
									return item;
								}
							}
						});

						modalInstance.result.then(function() {
							console.log('submit from story modal');
							getStories();
						}, function() {
							console.log('Modal story dismissed');
						});
					}

					// open modal Task
					$scope.openModalNewTask = function(statusIndex,storyIndex,storyId, taskId) {

						var modalInstance = $modal.open({
							templateUrl : 'modalNewTask.html',
							controller : 'NewTaskCtrl',
							size : 'lg',
							// pass object to NewTaskCtrl
							resolve : {
								item : function() {
									item = {
										projectId : $scope.projectId,
										storyId : storyId,
										taskId : taskId
									};
									return item;
								}
							}
						});

						modalInstance.result.then(function() {
							console.log('submit from task modal');
							getTasks(storyId,statusIndex,storyIndex);
						}, function() {
							console.log('Modal task dismissed');
						});
					}
	})
