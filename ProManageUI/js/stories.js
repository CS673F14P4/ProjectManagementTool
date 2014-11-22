var app = angular.module('postStory',[]);
app.controller("addStoryCtrl", function($scope, $http){
	$scope.storyName = null;

	$scope.pushStory = function() {
		$http.get(headers("api/story", data)).success(function(data, success, headers){
			alert("Story Added");
			$http.get(headers("location")).success(function(data){
				$scope.stories.push(data);

			});
		});
	};

});