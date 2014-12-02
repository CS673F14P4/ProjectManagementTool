/**
 * author: Mariana Arantes
 */
 angular.module('promanage').controller("AddMemberCtrl", function($scope, $routeParams, $http) {

		
	// only show button when there is a user
	$scope.showFlag = false;
	 
	 
	 // request to get users by username
	 $scope.search = function(){
		 
		 $http({
			 method : 'Get',
			 url : 'http://localhost:8080/ProManageREST/jaxrs/users/'+ $scope.searchQuery
		 }).success(function(data) {
			 if (data == undefined || data == "") {
				 $scope.user = "";
				 $scope.message = "";
				 $scope.showFlag = false;

			 }else{
				 $scope.user = data;
				 $scope.message = "User";
				 $scope.showFlag = true;

			 }
			 
		 }).error(function(data, status, headers, config) {
			 // put here message of error
			 //$scope.message = "Sorry, we had a problem. Try again later."
		 });
		 
	 }
	 
	 //add a member
	 $scope.add = function(member) {
		 var answer = confirm("Are you sure you want to add the member " + member.username + "?");
			
			if (answer == true){
				// request to add member
			}
			
		}

})