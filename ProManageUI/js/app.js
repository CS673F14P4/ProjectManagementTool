(function() {

	var app = angular.module('promanage', []);

	
	app.controller('ApplicationController', function($scope, USER_ROLES,$rootScope,
			AuthService) {

		$scope.currentUser = $rootScope.currentUser ;
		$scope.userRoles = USER_ROLES;
		$scope.isAuthorized = AuthService.isAuthorized;

		$scope.setCurrentUser = function(user) {
			$scope.currentUser = user;
		};
	})

	app.controller('LoginController', function($scope, $rootScope, $location,
			AUTH_EVENTS, AuthService) {
		$scope.credentials = {
			username : '',
			password : ''
		};
		$scope.login = function(credentials) {
			AuthService.login(credentials).then(function(user) {
				$rootScope.$broadcast(AUTH_EVENTS.loginSuccess);
			    $rootScope.currentUser = user; 
				$scope.setCurrentUser(user);
			}, function() {
				$rootScope.$broadcast(AUTH_EVENTS.loginFailed);
			});
		};
	})

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

	app.factory('AuthService', function($http, Session) {
		var authService = {};

		authService.login = function(credentials) {
			return $http.post(
					'http://localhost:8080/ProManageREST/jaxrs/project',
					credentials).then(
					function(res) {
						Session.create(res.data.id, res.data.user.id,
								res.data.user.role);
						return res.data.user;
					});
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
