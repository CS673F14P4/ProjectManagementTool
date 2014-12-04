/**
 * author: Mariana Arantes
 */
 angular.module('promanage').controller("AddMemberCtrl", function($scope, $routeParams, $http, $window, $rootScope) {

	 $scope.projectId = $routeParams.projectId;
	
	 
	// only show button when there is a user
	$scope.showFlag = false;

	//request to get list of members
	function getMembers(){
	 	$http({
				method : 'Get',
				url : 'http://localhost:8080/ProManageREST/jaxrs/project/'+ $scope.projectId + '/member'
			}).success(function(data) {
				if (data == undefined || data == ""){
					$scope.members = {};
				}else{
					$scope.members = data;
				}
			}).error(function(data, status, headers, config) {
				console.log('error');
			});
 	}
		 
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
				 $scope.buttonFlag = false;

			 }else{
				 $scope.user = data;
				 $scope.message = "User";
				 $scope.showFlag = true;
				 $scope.buttonFlag = true;

				 //check if user is a member already
				 getMembers();

				 for(var i=0; i< $scope.members.length; i++){
					 var obj = $scope.members[i];
				     if (obj.userId == $scope.user.userId){
				    	 $scope.buttonFlag = false; // don't show button to member
				    	 break;
				     }
				 }
				        
			}
			 
		 }).error(function(data, status, headers, config) {
			 $scope.message = "Sorry, we have a problem. Try again later."
		 });
		 
	 }
	 
	 //add a member
	 $scope.add = function(member) {
		 var answer = confirm("Are you sure you want to add the member " + member.username + "?");
			
			if (answer == true){
				// request to add member
				$scope.form = {"projectId": $scope.projectId, "userId": member.userId, "roleName": "member"};

				$http({
					 method : 'POST',
					 url : 'http://localhost:8080/ProManageREST/jaxrs/project/' + $scope.projectId + '/member',
					 data: JSON.stringify($scope.form),
					headers: {
						'Content-Type':'application/json'
					}
				 }).success(function(data) {
					 $scope.buttonFlag = false;
					 $window.alert("Member added with success.");
					 
					 
				 }).error(function(data, status, headers, config) {
					 $window.alert("Sorry, we have a problem. Try again later.");
					 $scope.user = {};
					 $scope.showFlag = false;
					 $scope.buttonFlag = false;

				 });
			}
			
		}

})