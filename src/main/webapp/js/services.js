'use strict';

/* Services */

var app = angular.module('wHomeControl.services', ['ngResource']);
app.value('version', '0.1');


// http://localhost:8080/switches
var url = "../switches";

// http://localhost:8080/switches/switch
var switchAppContext = "/switch";



app.service('Switch', function($http) {

  this.query = function() {
  	console.log("Returning Switches");

	  return $http.get(url).then(function (response) {
	    console.log(response);
	    return response.data;
	});
  };

  this.queryOne = function(id) {
    console.log("Returning One Switch");
    
    return $http.get(url + "/" + id).then(function (response) {
      console.log(response);
      return response.data;
    });
  };

  this.turnOn = function(id) {
  	console.log(id);
  	var request = '{"status": "1"}';
  	console.log(request);
  	return $http.put(url + "/" + id + switchAppContext,request).then(function (response) {
	    console.log(response);
	    return response.data;
	});
  };

  this.turnOff = function(id) {
  	console.log(id);
  	var request = '{"status": "0"}';
  	console.log(request);
  	return $http.put(url + "/" + id + switchAppContext,request).then(function (response) {
	    console.log(response);
	    return response.data;
	});
  };

  this.turnAllSwitchesOn = function() {
    console.log("Turning on all switches");
    var request = '{"status": "1"}';
    console.log(request);
    return $http.put(url + switchAppContext ,request).then(function (response) {
      console.log(response);
      return response.data;
  });
  };

  this.turnAllSwitchesOff = function() {
    console.log("Turning off all switches");
    var request = '{"status": "0"}';
    console.log(request);
    return $http.put(url + switchAppContext,request).then(function (response) {
      console.log(response);
      return response.data;
  });
  };

});



