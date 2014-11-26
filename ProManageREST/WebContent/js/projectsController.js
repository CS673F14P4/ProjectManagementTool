/**
 * author: Mariana Arantes
 */

/* Get list of projects */

angular.module('promanage').controller("ProjectsController",
		function($scope, $window, $rootScope, $http) {

			$rootScope.pageTitle = "Project List";

			var login = 'cyclops'; //change later
			
			//get list of projects
			$http({
				method : 'GET',
				url : 'http://localhost:8080/ProManageREST/jaxrs/project/user/cyclops'
			}).success(function(data) {
				$scope.projects = data;
				$scope.message = "Projects";
				
			}).error(function(data, status, headers, config) {
				//$window.alert("Please try again later.")
			});

		})
