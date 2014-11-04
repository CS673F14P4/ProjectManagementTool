/**
 * author: Mariana Arantes 
 */

/* Get list of projects */
/* 
function projectsController($scope,$http) {
  $http.get("http://localhost:8080/ProManageREST/jaxrs/project")
  .success(function(response) {$scope.projects = response;});
}*/

/* just for test */
function projectsController($scope) {

  $scope.projects = [{"description": "Bla bla bla about projetc A", "name": "Project A"},
                     {"description": "Bla bla bla about projetc B", "name": "Project B"},
                     {"description": "Bla bla bla about projetc C", "name": "Project C"},
                     {"description": "Bla bla bla about projetc D", "name": "Project D"}];
  
}