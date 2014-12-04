/**
 * author: Mariana Arantes
 */
 angular.module('promanage').controller("AddMemberCtrl", function($scope, $routeParams, $http, $window, $rootScope) {

	 $scope.projectId = $routeParams.projectId;
	 $scope.members = {};
	 
	// only show button when there is a user
	$scope.showFlag = false;
		 
	// request to get users by username
	$scope.search = function(){
		
		//get members
		$http({
			method : 'Get',
			url : 'http://localhost:8080/ProManageREST/jaxrs/project/'+ $scope.projectId + '/member'
		}).success(function(data) {			
			// get user
			$http({
				method: "GET",
				url : 'http://localhost:8080/ProManageREST/jaxrs/users/'+ $scope.searchQuery
			}).success(function(userdata){

				// members list
				if (data == undefined || data == ""){
					$scope.members = {};
				}else{
					$scope.members = data;
				}
				
				if (userdata == undefined || userdata == ""){
					 $scope.user = "";
					 $scope.message = "";
					 $scope.showFlag = false;
					 $scope.buttonFlag = false;
					 
				}else{
					$scope.user = userdata;
					$scope.message = "User";
					
					 //check if user is a member already
					 var member = false;

					 for(var i=0; i< $scope.members.length; i++){
						 var obj = $scope.members[i];
					     if (obj.userId == $scope.user.userId){
					    	 $scope.message = obj.username;
					    	 member = true;
					    	 break;
					     }
					 }
					 
					 if (member){
						 $scope.buttonFlag = false;
					 }else{
						 $scope.buttonFlag = true;
					 }
					 
					 $scope.showFlag = true;
				}
				
			}).error(function(userdata){
				$window.alert("Sorry, we have a problem. Please try again later.");
			});
			
		}).error(function(data, status, headers, config) {
			$window.alert("Sorry, we have a problem. Please try again later.");
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
					 $window.alert("Sorry, we have a problem. Please try again later.");
					 $scope.user = {};
					 $scope.showFlag = false;
					 $scope.buttonFlag = false;

				 });
			}
			
		}

})