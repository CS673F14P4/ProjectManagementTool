/**
 * 
 */
 angular.module('promanage').controller("MembersController", function($scope, $routeParams, $http) {

 	$scope.project = {'name':""};
 	$scope.projectId = $routeParams.projectId;
 	$scope.members = [];
 	
	// only show button when there are projects
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
				console.log('error');
			});


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
				console.log('error');
			});
 	
 	
	//delete a member
	$scope.del = function(member) {
		var answer = confirm("Are you sure you want to delete the member " + member.username + "?");
		
		if (answer == true){
			// request to delete member
			var dataDelete = {'projectid': $scope.projectId, 'userid':member.userId};
			
			$http({
				method : 'DELETE',
				url : 'http://localhost:8080/ProManageREST/jaxrs/project/'+ $scope.projectId + '/member',
				data: JSON.stringify(dataDelete),
				headers: {
					'Content-Type':'application/json'
				}			
			}).success(function(data) {
				$window.alert("Member deleted with sucess.");
				
			}).error(function(data, status, headers, config) {
				$window.alert("Sorry, we have a problem to delete member, try again later.");
			});
			
		}
		
	}

})