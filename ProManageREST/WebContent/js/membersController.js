/**
 * 
 */
 angular.module('promanage').controller("MembersController", function($scope, $routeParams, $http, $window, $location) {

 	$scope.project = {'name':""};
 	$scope.projectId = $routeParams.projectId;
 	$scope.members = [];
 	
	// only show button when there are members
	$scope.showFlag = false;


 	$http({
				method : 'Get',
				url : 'http://localhost:8080/ProManageREST/jaxrs/project/'+ $scope.projectId
			}).success(function(data) {
				//test
				console.log(data);
				$scope.project.name = data.name;
				if (data.status == "closed"){
					$scope.statusFlag = false;
				}else{
					$scope.statusFlag = true;
				}
				
			}).error(function(data, status, headers, config) {
				$location.path("/errormsg");
			});

 	function getMembers(){
	 	$http({
				method : 'Get',
				url : 'http://localhost:8080/ProManageREST/jaxrs/project/'+ $scope.projectId + '/member'
			}).success(function(data) {
				if (data == undefined || data == ""){
					$scope.members = "";
					$scope.showFlag = false;

				}else{
					$scope.members = data;
					$scope.showFlag = true;
				}

			}).error(function(data, status, headers, config) {
				$location.path("/errormsg");
			});
 	}
 	
 	getMembers();
 	
	//delete a member
	$scope.del = function(member) {
		var answer = confirm("Are you sure you want to delete the member " + member.username + "?");
		
		if (answer == true){
			// request to delete member
			var dataDelete = {'projectId': $scope.projectId, 'userId':member.userId, 'roleName': null};
			
			$http({
				method : 'DELETE',
				url : 'http://localhost:8080/ProManageREST/jaxrs/project/'+ $scope.projectId + '/member',
				data: JSON.stringify(dataDelete),
				headers: {
					'Content-Type':'application/json'
				}			
			}).success(function(data) {
				$window.alert("Member deleted with sucess.");
				getMembers();
				
			}).error(function(data, status, headers, config) {
				$window.alert("Sorry, we have a problem. Please try again later.");
			});
			
		}
		
	}

})