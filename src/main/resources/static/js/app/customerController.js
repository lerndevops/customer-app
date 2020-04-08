'use strict'

var module = angular.module('customer.controllers', []);
module.controller("customerController", [ "$scope", "customerService",
		function($scope, customerService) {
			$scope.customerDto = {
				customerId : null,
				firstName : null,
				lastName : null,
				customerName : null,
				emailId : null,
				age : 0,
				mobileNo:null
			};
			
			customerService.getCustomerById("1").then(function(value) {
				console.log(value.data);
			}, function(reason) {
				console.log("error occured");
			}, function(value) {
				console.log("no callback");
			});

			$scope.addCustomer = function() {
				customerService.addCustomer($scope.customerDto).then(function() {
					$scope.customerDto = {
							customerId : null,
							firstName : null,
							lastName : null,
							customerName : null,
							emailId : null,
							age : 0,
							mobileNo:null
						};
					$scope.customerSaveMsg = "Customer Added Successfully"
						
				}, function(reason) {
					console.log("error occured");
				}, function(value) {
					console.log("no callback");
				});
			}
			$scope.getAllCustomers = function() {
					console.log("works");
					customerService.getAllCustomers().then(function(value) {
						$scope.allCustomers= value.data;
					}, function(reason) {
						console.log("error occured");
					}, function(value) {
						console.log("no callback");
					});

			}
			$scope.customerRegTabClick = function() {
				console.log("works");
				$scope.customerSaveMsg = null;
			}
		} ]);