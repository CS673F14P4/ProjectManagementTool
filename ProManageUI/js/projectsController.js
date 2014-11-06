/**
 * author: Mariana Arantes 
 */


/* Get list of projects */

/*function projectsController($scope, $http, Data) {
 
	$http.get("http://localhost:8080/ProManageREST/jaxrs/project").success(function(response) {
		
		// user doesn't have projects
		if (response === undefined || response === null || response === "") {
			$scope.message = "";
			$scope.projects = [];
		}
		// user has projects
		else {
			$scope.message = "Projects";
			$scope.projects = response;
		}
	});
	
	// Get project id and update shared data
   	$scope.getProject = function(obj) {
		var id = obj.currentTarget.attributes.data.nodeValue;
		Data.setCurrentProject(id);
		// redirect to project page
		$window.location.href = '../html/projectview.html';
	};
	
}
*/

/* just for test because server side to get list is not working yet*/
function projectsController($scope, Data, $window) {

	$scope.projects = [{"description": "Bla bla bla about projetc A", "name": "Project A", "idproject": "1"},
                     {"description": "Bla bla bla about projetc B", "name": "Project B", "idproject" : "2"},
                     {"description": "Bla bla bla about projetc C", "name": "Project C", "idproject" : "3"},
                     {"description": "Bla bla bla about projetc D", "name": "Project D", "idproject" : "4"}];
	
	$scope.message = "Projects";  
	
	// Get project id and update shared data
    $scope.getProject = function(obj) {
        var id = obj.currentTarget.attributes.data.nodeValue;
        Data.setCurrentProject(id);
        // redirect to project page
        $window.location.href = '../html/projectview.html';
    };

}
