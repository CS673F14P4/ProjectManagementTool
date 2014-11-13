/**
 * 
 */
angular.module('promanage').controller("ProjectViewCtrl", function($scope, $routeParams) {
	
	$(".modalNewStory").load("modalNewStory.html");
	$(".modalNewTask").load("modalNewTask.html");
	

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
		"description" : "Bla bla bla about projetc A",
		"name" : "Project " + $routeParams.projectId,
		"idproject" : "1",
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
			"userStories" : [ {
				id : 3,
				"name" : "Story X",
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

})
