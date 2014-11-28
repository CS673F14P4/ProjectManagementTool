/**
 * 
 */
 angular.module('promanage').controller("AddMemberCtrl", function($scope, $routeParams, $http) {

	 
	 // request to get users by username
	/* $scope.search = function(){
		 
		 $http({
			 method : 'Get',
			 url : 'http://localhost:8080/ProManageREST/jaxrs/project/'+ $scope.searchQuery
		 }).success(function(data) {
			 $scope.users = data;
			 $scope.message = "Users";

		 }).error(function(data, status, headers, config) {
			 $scope.message = "Sorry, we had a problem. Try again later."
		 });
		 
	 }*/
	 
	 $scope.users = [{'firstname':'Name', 'lastname':'Last Name', 'username': 'username'},
	                 {'firstname':'Name1', 'lastname':'Last Name1', 'username': 'username1'}
	                 ]
	 
	 $scope.message = "Users";
	 
	 //add a member
	 $scope.add = function(member) {
		 var answer = confirm("Are you sure you want to add the member " + member.username + "?");
			
			if (answer == true){
				// request to add member
			}
			
		}

})