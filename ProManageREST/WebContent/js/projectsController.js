/**
 * author: Mariana Arantes
 */

/* Get list of projects */

angular.module('promanage').controller("ProjectsController",
		function($scope, $window, $rootScope, $http) {

			$rootScope.pageTitle = "Project List";
			
			// only show button when there are projects
			$scope.showFlag = false;
			
			
			//get list of projects
			$http({
				method : 'GET',
				url : 'http://localhost:8080/ProManageREST/jaxrs/project'
			}).success(function(data) {
				// user has no projects
				if (data == undefined || data == ""){
					$scope.projects = "";
					$scope.message = "";
					$scope.showFlag = false;

				}else{
					$scope.projects = data;
					$scope.message = "Projects";
					$scope.showFlag = true;
				}
				
			}).error(function(data, status, headers, config) {
				// choose something to show in every error situation
				//$window.alert("Please try again later.")
			});
			
			// close project
			$scope.close = function(projectId){
				
				// get project details
				$http({
					method : 'GET',
					url : 'http://localhost:8080/ProManageREST/jaxrs/project/'+ projectId
				})

				.success(function(data) {
					// load data
					console.log(data);
					$scope.user = data;
					$scope.user.startDate = (new Date($scope.user.startDate));
					$scope.user.endDate = (new Date($scope.user.endDate));
					
					//change status
					$scope.user.status = "closed";
					
					// PUT data
					$http({
						method : 'PUT',
						url : 'http://localhost:8080/ProManageREST/jaxrs/project',
						data: JSON.stringify($scope.user),
						headers: {
							'Content-Type':'application/json'
						}
					}).success(function(data) {
						$window.alert("Project closed.");
				        $window.location.href = '';
							
					}).error(function(data, status, headers, config) {
						$window.alert("Please try again later.")
					});
					
				})

				.error(function(data, status, headers, config) {
					console.log('error');
				});
			}

})
