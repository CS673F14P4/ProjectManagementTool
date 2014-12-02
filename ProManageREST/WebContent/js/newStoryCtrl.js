/**
 * 
 */
angular.module('promanage').controller("NewStoryCtrl",
		function($scope, $routeParams, $http, $location) {
	
			// initialize form
			var currentTime = new Date();
			$scope.story = {'name': 'Story', 'description': 'As an user I want...', 'dueDate': currentTime};
			
			/* reset form */
			$scope.reset = function () {
				$scope.story = {};
			}
			
			$scope.storyId = $routeParams.storyId;
			$scope.projectId = $routeParams.projectId;
			
			// edit form - get story
			if ($scope.storyId > 0) {
	
				$http(
						{
							method : 'GET',
							url : 'http://localhost:8080/ProManageREST/jaxrs/project/'+$routeParams.projectId+'/story/'+$scope.storyId,
							data : JSON.stringify($scope.story),
							headers : {
								'Content-Type' : 'application/json'
							}
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
			
			// use this when owner is added
			$scope.users = [ {
				name : 'Joahn'
			}, {
				name : 'Pedro'
			} ];
			$scope.selected_notify = $scope.users[0];
			$scope.selected_asigned = $scope.users[0];
			
			
			// send form
			$scope.submit = function() {
	
				console.log($scope.story);
				$scope.story.dueDate = (new Date($scope.story.dueDate));
				$scope.story.projectid = $routeParams.projectId;
	
				if ($scope.storyId > 0) {
					// edit story
					$http(
	
							{
								method : 'PUT',
								url : 'http://localhost:8080/ProManageREST/jaxrs/project/'+$routeParams.projectId+'/story/',
								data : JSON.stringify($scope.story),
								headers : {
									'Content-Type' : 'application/json'
								}
							})
	
					.success(
							function(data) {
								$location.path("/project/"
										+ $routeParams.projectId);
							})
	
					.error(function(data, status, headers, config) {
						console.log('error');
					});
	
				} else {
					// new story
	
					$http(
							{
								method : 'POST',
								url : 'http://localhost:8080/ProManageREST/jaxrs/project/'+$routeParams.projectId+'/story/',
								data : JSON.stringify($scope.story),
								headers : {
									'Content-Type' : 'application/json'
								}
							})
	
					.success(
							function(data) {
								$location.path("/project/"
										+ $routeParams.projectId);
							})
	
					.error(function(data, status, headers, config) {
						console.log('error');
					});
				}
	
			}
	
		})
