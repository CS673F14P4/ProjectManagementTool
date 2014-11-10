(function() {

	var app = angular.module('promanage', [ 'ngRoute' ]);

	app.config(function($routeProvider) {
		$routeProvider.when('/project', {
			templateUrl : 'home.html',
			controller : 'TCtrl'
		}).when('/project/:projectId', {
			templateUrl : 'projectView.html',
			controller : 'ProjectViewCtrl'
		}).when('/signin', {
			templateUrl : 'signin.html',
			controller : 'ApplicationController'
		}).when('/newproject', {
			templateUrl : 'newproject.html',
			controller : 'ApplicationController'
		}).otherwise({
			templateUrl : 'projectList.html',
			controller : 'ProjectsController'
		})
	})

	app.controller('ApplicationController', function($scope, USER_ROLES,
			AuthService) {
		$scope.currentUser = null;
		$scope.userRoles = USER_ROLES;
		$scope.isAuthorized = AuthService.isAuthorized;

		$scope.setCurrentUser = function(user) {
			$scope.currentUser = user;
		};
	})

	app.controller("ProjectViewCtrl", function($scope,$routeParams) {
		$(".modalNewStory").load("modalNewStory.html");
		$(".modalNewTask").load("modalNewTask.html");
		$scope.test = "Oi gente";
		$scope.project = {
			"description" : "Bla bla bla about projetc A",
			"name" : "Project "+$routeParams.projectId,
			"idproject" : "1",
			"status" : [ {
				"name" : "Backlog",
				"userStories" : [ {
					"name" : "Story 1",
					"description" : "Desc 1",
					"tasks" : [ {
						"name" : "task1",
						"description" : "description task1",
					}, {
						"name" : "task1",
						"description" : "description task1",
					} ]
				}, {
					"name" : "Story 2",
					"description" : "bla2",
					"tasks" : [ {
						"name" : "task1",
						"description" : "description task1",
					}, {
						"name" : "task1",
						"description" : "description task1",
					} ]
				} ]

			}, {
				"name" : "Current",
				"userStories" : [ {
					"name" : "Story 1",
					"description" : "Desc 1",
					"tasks" : [ {
						"name" : "task1",
						"description" : "description task1",
					}, {
						"name" : "task1",
						"description" : "description task1",
					} ]
				} ]
			}, {
				"name" : "Done",
				"userStories" : [ {
					"name" : "Story 1",
					"description" : "Desc 1",
					"tasks" : [ {
						"name" : "task1",
						"description" : "description task1",
					} ]
				} ]
			} ]

		};

	})

	app.controller("ProjectsController", function($scope, $window) {

		$scope.projects = [ {
			"description" : "Bla bla bla about projetc A",
			"name" : "Project A",
			"idproject" : "1"
		}, {
			"description" : "Bla bla bla about projetc B",
			"name" : "Project B",
			"idproject" : "2"
		}, {
			"description" : "Bla bla bla about projetc C",
			"name" : "Project C",
			"idproject" : "3"
		}, {
			"description" : "Bla bla bla about projetc D",
			"name" : "Project D",
			"idproject" : "4"
		} ];

		$scope.message = "Projects";

		// Get project id and update shared data
		$scope.getProject = function(obj) {
			var id = obj.currentTarget.attributes.data.nodeValue;
			// redirect to project page
			$window.location.href = '../html/projectview.html';
		}
	})

	app.controller('UsersCtrl', function($scope) {
		$scope.selected_item = 1;
		$scope.users = [ {
			"id" : "1",
			"name" : "user1",
		}, {
			"id" : "2",
			"name" : "user2",
		}, {
			"id" : "3",
			"name" : "user3",
		}, {
			"id" : "4",
			"name" : "user4",
		}, {
			"id" : "5",
			"name" : "user5",
		}, {
			"id" : "6",
			"name" : "nobody",
		} ]
	})

	app.controller('LoginController', function($scope, $rootScope, $location,
			AUTH_EVENTS, AuthService, $window) {
		$scope.credentials = {
			username : '',
			password : ''
		};
		$scope.login = function(credentials) {
			console.log('login');
			AuthService.login(credentials).then(function(user) {
				$rootScope.$broadcast(AUTH_EVENTS.loginSuccess);
				$scope.setCurrentUser(user);
				$rootScope.blau = user;
				console.log(user);
				$window.location.href = 'home.html';

				// $location.path("/project");
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
			return $http.post('http://localhost:8080/ProManageREST/jaxrs/user',
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
