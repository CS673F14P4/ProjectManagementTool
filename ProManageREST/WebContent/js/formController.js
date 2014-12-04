/**
 * author: Mariana Arantes 
 */


angular.module('promanage').controller("FormController",
		function($scope, $window, $rootScope, $http, $routeParams, $location) {

	$rootScope.pageTitle = "New Project";
	$scope.projectId = $routeParams.projectId;
	
	/* reset form */
	$scope.reset = function () {
		$scope.user = {};
	}
	
	// edit project - get project details
	if ($scope.projectId > 0){
		
		$http(
				{
					method : 'GET',
					url : 'http://localhost:8080/ProManageREST/jaxrs/project/'+ $scope.projectId
				})

		.success(function(data) {
				console.log(data);
				$scope.user = data;
				$scope.user.startDate = (new Date($scope.user.startDate));
				$scope.user.endDate = (new Date($scope.user.endDate));
		})

		.error(function(data, status, headers, config) {
			$location.path("/errormsg");

		});
		
	// new project
	}else{
		// initialize form
		var currentTime = new Date();
		$scope.user = {'name': 'Project A', 'description': 'Description of Project A', 'startDate': currentTime, 'endDate': currentTime, 'status': 'open'};
	}

	/* send data */
	$scope.submit = function () {
    	    	
		if ($scope.projectId > 0) {
			// PUT method
			$http({
				method : 'PUT',
				url : 'http://localhost:8080/ProManageREST/jaxrs/project',
				data: JSON.stringify($scope.user),
				headers: {
					'Content-Type':'application/json'
				}
			}).success(function(data) {
				$window.alert("Project edited.");
		        $window.location.href = '';
					
			}).error(function(data, status, headers, config) {
				$window.alert("Sorry, we have a problem. Please try again later.");
			});

		}else{
			// post request to send form
			$http({
				method : 'POST',
				url : 'http://localhost:8080/ProManageREST/jaxrs/project',
				data: JSON.stringify($scope.user),
				headers: {
					'Content-Type':'application/json'
				}
			}).success(function(data) {
				$window.alert("Project created");
		        $window.location.href = '';
					
			}).error(function(data, status, headers, config) {
				$window.alert("Sorry, we have a problem. Please try again later.");
			});
		}

    }
    	
    	return 0;
    	    
})