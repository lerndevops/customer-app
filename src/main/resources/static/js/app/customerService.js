'use strict'

angular.module('customer.services', []).factory('customerService',
		[ "$http", "CONSTANTS", function($http, CONSTANTS) {
			var service = {};
			service.getCustomerById = function(customerId) {
				var url = CONSTANTS.getCustomerById + customerId;
				return $http.get(url,'application/json');
			}
			service.getAllCustomers = function() {
				return $http.get(CONSTANTS.getAllCustomers,'application/json');
			}
			service.addCustomer = function(customerDto) {
				return $http.post(CONSTANTS.addCustomer, customerDto);
			}
			return service;
		} ]);