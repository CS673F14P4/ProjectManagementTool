/**
 * author: Mariana Arantes 
 */


angular.module('promanage').controller("FormController",
		function($scope, $window) {
//function formController ($scope, $window) {
	
	$scope.user = {};
	
	/* reset form */
	$scope.reset = function () {
		$scope.user = {};
	}
	
	/* validate form and post data */
    $scope.submit = function () {
    	
    	$scope.nameMsg = "";
    	$scope.descriptionMsg = "";
    	$scope.startDateMsg = "";
    	$scope.endDateMsg = "";
    	
    	var invalid = false;
    	
    	// check if the form is not blank  	
    	if ($scope.user.name === undefined || $scope.user.name === "") {
    		$scope.nameMsg = "Please, insert a name.";
    		invalid = true;
    	}
    	if ($scope.user.description === undefined || $scope.user.description === "") {
    		$scope.descriptionMsg = "Please, insert a description.";
    		invalid = true;
    	}
    	if ($scope.user.startdate === undefined || $scope.user.startdate === "") {
    		$scope.startDateMsg = "Please, insert a start date.";
    		invalid = true;
    	}
    	if ($scope.user.enddate === undefined || $scope.user.enddate === "") {
    		$scope.endDateMsg = "Please, insert an end date.";
    		invalid = true;
    	}
    	
    	// check if the date is valid
    	if (validation($scope.user.startdate) == false) {
    		$scope.startDateMsg = "Invalid date.";
    		invalid = true;
    	}
    	
    	if (validation($scope.user.enddate) == false) {
    		$scope.endDateMsg = "Invalid date.";
    		invalid = true;
    	}
    	
    	// valid data 
    	if (!invalid) {
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
    	
    };
    
    $scope.$watch('user.startdate', function() {
    	$scope.user.startdate = dateFormat($scope.user.startdate);
    	
    });
    
    $scope.$watch('user.enddate', function() {
    	$scope.user.enddate = dateFormat($scope.user.enddate);
    	
    });
    
})