/**
 * 
 */
angular
		.module('promanage')
		.controller(
				"ProjectViewCtrl",
				function($scope, $routeParams, $http, $rootScope) {

					$rootScope.pageTitle = "Project Detail";
					console.log($rootScope.pageTitle);

					$(".modalNewStory").load("modalNewStory.html");
					$(".modalNewTask").load("modalNewTask.html");

					$scope.projectId = $routeParams.projectId;

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

					// get project
					$http(
							{
								method : 'Get',
								url : 'http://localhost:8080/ProManageREST/jaxrs/project/'
										+ $scope.projectId
							}).success(function(data) {
						// test
						console.log(data);
						$scope.project.name = data.name;
						$scope.project.description = data.description;
						$scope.project.startDate = data.startDate;
						$scope.project.endDate = data.endDate;

					}).error(function(data, status, headers, config) {
						console.log('error');
					});

					// get stories
					$http(
							{
								method : 'Get',
								url : 'http://localhost:8080/ProManageREST/jaxrs/project/'
										+ $scope.projectId + '/stories'
							})
							.success(
									function(data) {
										// test
										console.log(data);
										for (var i = 0; i < data.length; i++) {
											story = data[i];
											console.log('Status:');
											console.log(story.status);
											stories = $scope.project.status[story.status].userStories;
											stories.push(story);
										}
									}).error(
									function(data, status, headers, config) {
										console.log('error');
									});

					$scope.acord = function(storyId, statusIndex, storyIndex) {
						// Get the tasks by StoryId

						// just do something if the element is collapsed and the
						// list of
						// task is null, otherwise return
						if (!$("#title" + storyId).hasClass("collapsed")
								|| $scope.project.status[0].userStories[0].tasks.length > 0) {
							return;
						}
						// show spinner
						$("#spinner" + storyId).show();

						$http(
								{
									method : 'Get',
									url : 'http://localhost:8080/ProManageREST/jaxrs/task/'
											+ storyId
								})
								.success(
										function(data) {
											$scope.project.status[statusIndex].userStories[storyIndex].tasks = data;
											// needed to show changes in UI
											// $scope.$apply();
											// hide the spinner after get the
											// tasks
											$("#spinner" + storyId).hide();
										})
								.error(function(data, status, headers, config) {
									console.log('error');
								});

					}

				})
