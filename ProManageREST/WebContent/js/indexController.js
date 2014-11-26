var app = angular.module('app', []);

app.controller('indexCtrl', function($scope, $http, $window) {
	$scope.callLogin = function() {
		$http.get("http://localhost:8080/ProManageREST/jaxrs/").success(
				function(data, status, headers, config) {

					console.log('sucess');
					$window.location.href = 'html/home.html';

				}).error(function(data, status, headers, config) {

			console.log('error');
		});
	}
})

app.controller('signupCtrl', function($scope, $http, $window) {

	// initializing user 
	$scope.user = {'firstname': 'firstname', 'lastname': 'lastname', 'email': 'example@email.com', 'username': 'username', 'password': '........'};
  
	// pattern to only accept single words
	$scope.usernamePattern = /^\s*\w*\s*$/;
    
	/* post data */
    $scope.submit = function () {
    	var formData = $scope.user;
    	// post method here
    }
})
