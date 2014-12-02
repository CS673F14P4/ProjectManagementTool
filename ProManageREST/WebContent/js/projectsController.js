/**
 * author: Mariana Arantes
 */

/* Get list of projects */

angular.module('promanage').controller("ProjectsController",
		function($scope, $window, $rootScope, $http) {

			$rootScope.pageTitle = "Project List";
			
			// only show button when there are projects
			$scope.showFlag = false;
			
			
			//get list of projects
			$http({
				method : 'GET',
				url : 'http://localhost:8080/ProManageREST/jaxrs/project'
			}).success(function(data) {
				// user has no projects
				if (data == undefined || data == ""){
					$scope.projects = "";
					$scope.message = "";
					$scope.showFlag = false;

				}else{
					$scope.projects = data;
					$scope.message = "Projects";
					$scope.showFlag = true;
				}
				
			}).error(function(data, status, headers, config) {
				// choose something to show in every error situation
				//$window.alert("Please try again later.")
			});

})
