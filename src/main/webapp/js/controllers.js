'use strict';

/* Controllers */


function NavigationCtrl ($scope, $location) {
    $scope.isCurrentPath = function (path) {
      return $location.path() == path;
    };
}


function SwitchListCtrl($scope, $http, $location, Switch) {

  $scope.switches = Switch.query();

  $scope.editSwitch = function (switchId) {
      $scope.selectedSwitch = Switch.queryOne(switchId);
    console.log('editSwitch: '+switchId)
    
    //$scope.selectedSwitch = Switch.queryOne(switchId);
    $location.path('/configuration/edit/' + switchId);

  };


  $scope.turnSwitchOn = function (switchId) {
    Switch.turnOn(switchId)
  };

  $scope.turnSwitchOff = function (switchId) {
    Switch.turnOff(switchId)
  };

  $scope.turnAllSwitchesOn = function () {
  	Switch.turnAllSwitchesOn()
  };

  $scope.turnAllSwitchesOff = function () {
  	Switch.turnAllSwitchesOff()
  };

}


