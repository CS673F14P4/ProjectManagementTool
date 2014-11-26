/**
 * 
 */
 angular.module('promanage').controller("MembersController", function($scope, $routeParams, $http) {

 	$scope.project = {'name':"",};
 	$scope.projectId = $routeParams.projectId;
 	$scope.members = [];


 	$http({
				method : 'Get',
				url : 'http://localhost:8080/ProManageREST/jaxrs/project/'+$scope.projectId
			}).success(function(data) {
				//test
				console.log(data);
				$scope.project.name = data.name;

			}).error(function(data, status, headers, config) {
				console.log('error');
			});


 	$http({
				method : 'Get',
				url : 'http://localhost:8080/ProManageREST/jaxrs/project/'+$scope.projectId+'/members'
			}).success(function(data) {
				//test
				console.log(data);
				$scope.members = data;
				console.log("members");
				console.log($scope.members);

			}).error(function(data, status, headers, config) {
				console.log('error');
			});

})