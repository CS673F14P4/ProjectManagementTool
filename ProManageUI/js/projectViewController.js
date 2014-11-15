/**
 * 
 */
angular.module('promanage').controller("ProjectViewCtrl", function($scope, $routeParams, $http) {
	
	$(".modalNewStory").load("modalNewStory.html");
	$(".modalNewTask").load("modalNewTask.html");
	
	$scope.projectId = $routeParams.projectId;

	$scope.acord = function(storyId) {
		// Get the tasks by StoryId

		// just do something if the element is collapsed and the list of
		// task is null, otherwise return
		if (!$("#title" + storyId).hasClass("collapsed")
				|| $scope.project.status[0].userStories[0].tasks.length>0) {
			return;
		}
		// show spinner
		$("#spinner" + storyId).show();
		// simulating consuming time requesting service
		setTimeout(function() {
		
			
			//change one for test
			$scope.project.status[0].userStories[0].tasks = [ {
				"name" : "taskx",
				"description" : "description task1",
			}, {
				"name" : "tasky",
				"description" : "description task1",
			} ];
			//needed to show changes in UI
			$scope.$apply();
			//hide the spinner after get the tasks
			$("#spinner" + storyId).hide();

		}, 1000);
	}

	$scope.project = {
		"description" : "",
		"name" : "",
		"idproject" : $routeParams.projectId,
		"startDate" : "",
		"endDate" : "",
		"status" : [ {
			"name" : "Backlog",
			"userStories" : [ {
				id : 1,
				"name" : "Story 1",
				"description" : "Desc 1",
				"tasks" : {}
			}, {
				id : 2,
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
			"userStories" : {}
		}, {
			"name" : "Done",
			"userStories" : [ {
				id : "4",
				"name" : "Story Z",
				"description" : "Desc 1",
				"tasks" : [ {
					"name" : "task1",
					"description" : "description task1",
				} ]
			} ]
		} ]

	};

	//get project 
	 $http({
				method : 'Get',
				url : 'http://localhost:8080/ProManageREST/jaxrs/project/'+$scope.projectId
			}).success(function(data) {
				//test
				console.log(data);
				$scope.project.name = data.project.name;
				$scope.project.description = data.project.description;
				$scope.project.startDate = data.project.startDate;
				$scope.project.endDate = data.project.endDate;

			}).error(function(data, status, headers, config) {
				console.log('error');
			});

	//get stories
	 $http({
				method : 'Get',
				url : 'http://localhost:8080/ProManageREST/jaxrs/project/'+$scope.projectId+'/stories'
			}).success(function(data) {
				//test
				console.log(data);
				$scope.project.status[1].userStories = data.wrapper.stories;
			}).error(function(data, status, headers, config) {
				console.log('error');
			});

})
