/**
 * 
 */
angular.module('promanage').controller("NewStoryCtrl",
		function($scope, $routeParams, $http, $location) {
	
	$scope.story;
	
	$scope.users = [{name:'Joahn'},{name:'Pedro'}];
	$scope.selected_notify = $scope.users[0];
	$scope.selected_asigned = $scope.users[0];
	
	$scope.submit = function(){
		
		console.log($scope.story);
		$scope.story.dueDate = (new Date($scope.story.dueDate));
		$scope.story.projectid =  $routeParams.projectId;
		
		$http(
				{
					method : 'POST',
					url : 'http://localhost:8080/ProManageREST/jaxrs/story/',
					data : JSON.stringify($scope.story),
					headers : {
						'Content-Type' : 'application/json'
					}
				})

				.success(
						function(data) {
							$location.path("/project/"+$routeParams.projectId);
						})

				.error(function(data, status, headers, config) {
					console.log('error');
				});		
	}
 
})
