/**
 * author: Mariana Arantes 
 */


angular.module('promanage').controller("FormController",
		function($scope, $window, $rootScope, $http) {

	$rootScope.pageTitle = "New Project";

	var currentTime = new Date();
	$scope.user = {'name': 'Project A', 'description': 'Description of Project A', 'startdate': currentTime, 'enddate': currentTime};
	
	$scope.selectText = function(){
	    document.getElementById("txtarea").select();
	}
	
	/* reset form */
	$scope.reset = function () {
		$scope.user = {};
	}

	/* post data */
	$scope.submit = function () {
    	
		var formData = $scope.user;
    		
		// put request to send form
		$http({
			method : 'PUT',
			url : 'http://localhost:8080/ProManageREST/jaxrs/project',
			data: formData
		}).success(function(data) {
			$window.alert("Project created");
	        $window.location.href = '';
				
		}).error(function(data, status, headers, config) {
			$window.alert("Please try again later.")
		});

    }
    	
    	return 0;
    	    
})