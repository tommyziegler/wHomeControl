'use strict';


// Declare app level module which depends on filters, and services
var myApp = angular.module('wHomeControl', ['wHomeControl.filters', 'wHomeControl.services', 'wHomeControl.directives']);
myApp.config(['$routeProvider', function($routeProvider) {

    // Home
	$routeProvider.when('/', {templateUrl: 'partials/switches.html', controller: SwitchListCtrl});

    // Configuration
    $routeProvider.when('/configuration', {templateUrl: 'partials/configuration.html', controller: SwitchListCtrl});
    $routeProvider.when('/configuration/edit/:id', {templateUrl: 'partials/edit.html', controller: SwitchListCtrl});

    // Contact
    $routeProvider.when('/contact', {templateUrl: 'partials/contact.html'});




    // All others redirect to Home
    $routeProvider.otherwise({redirectTo: '/'});
}]);