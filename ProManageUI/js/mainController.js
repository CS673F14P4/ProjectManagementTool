/**
 * author: Mariana Arantes 
 */

// declare the app with no dependencies
var myApp = angular.module('mainController', []);


myApp.factory('Data', function(){
    var data =
        {
            CurrentProject: ''
        };
    
    return {
        getCurrentProject: function () {
            return data.CurrentProject;
        },
        setCurrentProject: function (CurrentProject) {
            data.CurrentProject = CurrentProject;
        }
    };
});
