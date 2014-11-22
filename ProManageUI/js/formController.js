/**
 * author: Mariana Arantes 
 */


angular.module('promanage').controller("FormController",
		function($scope, $window, $rootScope) {

	$rootScope.pageTitle = "New Project";

	
	$scope.user = {};
	
	/* reset form */
	$scope.reset = function () {
		$scope.user = {};
	}
	
	/* post data */
    $scope.submit = function () {
    	
  
    		var formData = $scope.user;
    		
    		// post request to send form
    		/*$http.post("http://localhost:8080/ProManageREST/jaxrs/project", formData).
    			success(function(data, status, headers, config) {
    				window.alert("Project created.");
    		        $window.location.href = '../html/projectview.html';
    		  }).
    		  	error(function(data, status, headers, config) {
    		  		window.alert("An error occurred, please try again later.");
    		  		$scope.reset();
    		  });*/
    		
    		// just to present iteration 2, temporary
    		window.alert("Project created.");
	        $window.location.href = '';
    }
    	
    	return 0;
    	    
})