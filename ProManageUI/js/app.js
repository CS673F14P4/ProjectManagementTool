(function() {

	var app = angular.module('promanage', [ 'ngRoute','ngCookies' ]);

	
	app.config(function($routeProvider) {
		$routeProvider
		// .when('/project', {
		// templateUrl : 'home.html',
		// controller : 'ApplicationController'
		// })
		.when('/project/:projectId', {
			templateUrl : 'projectview.html',
			controller : 'ProjectViewCtrl'
		}).when('/signin', {
			templateUrl : 'signin.html',
			controller : 'ApplicationController'
		}).when('/newproject', {
			templateUrl : 'newproject.html',
			controller : 'FormController'
		}).when('/members/:projectId', {
			templateUrl : 'members.html',
			// change this
			controller : 'MembersController'
		}).otherwise({
			templateUrl : 'projectList.html',
			controller : 'ProjectsController'
		})
	})
	
	

	app.controller('ApplicationController', function($scope, USER_ROLES,
			AuthService) {
		$scope.currentUser = null;
		$scope.userRoles = USER_ROLES;
		$scope.isAuthenticated = AuthService.isAuthenticated;

		$scope.setCurrentUser = function(user) {
			$scope.currentUser = user;
		};
	})
	// ** nothing really done about login ** //
	app.controller('LoginController', function($scope, $rootScope, $location,
			AUTH_EVENTS, AuthService, $window) {
		$scope.errorlogin = false;
		$scope.credentials = {
			username : '',
			password : ''
		};
		$scope.login = function(credentials) {
			console.log('login');

			AuthService.login(credentials).then(function(user) {
				$rootScope.$broadcast(AUTH_EVENTS.loginSuccess);
				$scope.setCurrentUser(user);
				console.log(user);
				 $window.location.href = 'home.html';

				// $location.path("/project");
			}, function() {
				$rootScope.$broadcast(AUTH_EVENTS.loginFailed);
				$scope.errorlogin = true;
			});
		};
	});

	app.controller('LogoutCtrl', function($scope, AuthService, $window) {
		$scope.logout = function() {
			AuthService.logout().then(function() {
				console.log("logout sucess");
				$window.location.href = 'signin.html';

			}, function() {
				console.log("error");
			});
		}
	});

	app.constant('AUTH_EVENTS', {
		loginSuccess : 'auth-login-success',
		loginFailed : 'auth-login-failed',
		logoutSuccess : 'auth-logout-success',
		sessionTimeout : 'auth-session-timeout',
		notAuthenticated : 'auth-not-authenticated',
		notAuthorized : 'auth-not-authorized'
	})

	app.constant('USER_ROLES', {
		all : '*',
		admin : 'admin'
	})

	app.factory('AuthService', function($http, Session,$cookieStore,Base64) {
		var authService = {};

	

		authService.login = function(credentials) {

//			var encodedUserNameAndPassword = Base64.encode(credentials.userName + ':'
//					+ credentials.password);
//
//			$http.defaults.headers.common['Authorization'] = 'Basic '
//					+ encodedUserNameAndPassword;
//			
//           // $cookieStore.put('authdata', encodedUserNameAndPassword);
//			
//			$cookieStore.put('basicCredentials', encodedUserNameAndPassword);
			


			return $http({
				method : 'POST',
				url : 'http://localhost:8080/ProManageREST/jaxrs/user/login',
				data : $.param(credentials),
				headers : {
					'Content-Type' : 'application/x-www-form-urlencoded'
				}
			}).success(function(data) {
				return data.user
			}).error(function(data, status, headers, config) {
				console.log('error');
				return null;
			});
			;

		};

		authService.logout = function(credentials) {

			return $http({
				method : 'GET',
				url : 'http://localhost:8080/ProManageREST/jaxrs/user/logout'
			}).success(function(data) {
				return true;
			}).error(function(data, status, headers, config) {
				console.log('error');
				return false;
			});
			;

		};

		authService.isAuthenticated = function() {
			return !!Session.userId;
		};

		authService.isAuthorized = function(authorizedRoles) {
			if (!angular.isArray(authorizedRoles)) {
				authorizedRoles = [ authorizedRoles ];
			}
			return (authService.isAuthenticated() && authorizedRoles
					.indexOf(Session.userRole) !== -1);
		};

		return authService;
	})

	app.factory('Base64', function() {
    var keyStr = 'ABCDEFGHIJKLMNOP' +
        'QRSTUVWXYZabcdef' +
        'ghijklmnopqrstuv' +
        'wxyz0123456789+/' +
        '=';
    return {
        encode: function (input) {
            var output = "";
            var chr1, chr2, chr3 = "";
            var enc1, enc2, enc3, enc4 = "";
            var i = 0;
 
            do {
                chr1 = input.charCodeAt(i++);
                chr2 = input.charCodeAt(i++);
                chr3 = input.charCodeAt(i++);
 
                enc1 = chr1 >> 2;
                enc2 = ((chr1 & 3) << 4) | (chr2 >> 4);
                enc3 = ((chr2 & 15) << 2) | (chr3 >> 6);
                enc4 = chr3 & 63;
 
                if (isNaN(chr2)) {
                    enc3 = enc4 = 64;
                } else if (isNaN(chr3)) {
                    enc4 = 64;
                }
 
                output = output +
                    keyStr.charAt(enc1) +
                    keyStr.charAt(enc2) +
                    keyStr.charAt(enc3) +
                    keyStr.charAt(enc4);
                chr1 = chr2 = chr3 = "";
                enc1 = enc2 = enc3 = enc4 = "";
            } while (i < input.length);
 
            return output;
        },
 
        decode: function (input) {
            var output = "";
            var chr1, chr2, chr3 = "";
            var enc1, enc2, enc3, enc4 = "";
            var i = 0;
 
            // remove all characters that are not A-Z, a-z, 0-9, +, /, or =
            var base64test = /[^A-Za-z0-9\+\/\=]/g;
            if (base64test.exec(input)) {
                alert("There were invalid base64 characters in the input text.\n" +
                    "Valid base64 characters are A-Z, a-z, 0-9, '+', '/',and '='\n" +
                    "Expect errors in decoding.");
            }
            input = input.replace(/[^A-Za-z0-9\+\/\=]/g, "");
 
            do {
                enc1 = keyStr.indexOf(input.charAt(i++));
                enc2 = keyStr.indexOf(input.charAt(i++));
                enc3 = keyStr.indexOf(input.charAt(i++));
                enc4 = keyStr.indexOf(input.charAt(i++));
 
                chr1 = (enc1 << 2) | (enc2 >> 4);
                chr2 = ((enc2 & 15) << 4) | (enc3 >> 2);
                chr3 = ((enc3 & 3) << 6) | enc4;
 
                output = output + String.fromCharCode(chr1);
 
                if (enc3 != 64) {
                    output = output + String.fromCharCode(chr2);
                }
                if (enc4 != 64) {
                    output = output + String.fromCharCode(chr3);
                }
 
                chr1 = chr2 = chr3 = "";
                enc1 = enc2 = enc3 = enc4 = "";
 
            } while (i < input.length);
 
            return output;
        }
    };
});
	
	app.service('Session', function() {
		this.create = function(sessionId, userId, userRole) {
			this.id = sessionId;
			this.userId = userId;
			this.userRole = userRole;
		};
		this.destroy = function() {
			this.id = null;
			this.userId = null;
			this.userRole = null;
		};
		return this;
	})

})();
