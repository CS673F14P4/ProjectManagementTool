/**
 * author: Mariana Arantes 
 */


angular.module('promanage').controller("FormController",
		function($scope, $window, $rootScope, $http) {

	$rootScope.pageTitle = "New Project";

	var currentTime = new Date();
	$scope.user = {'name': 'Project A', 'description': 'Description of Project A', 'startDate': currentTime, 'endDate': currentTime, 'status': 'open'};
	
	/* reset form */
	$scope.reset = function () {
		$scope.user = {};
	}

	/* post data */
	$scope.submit = function () {
    	    		
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
			$window.alert("Please try again later.")
		});

    }
    	
    	return 0;
    	    
})