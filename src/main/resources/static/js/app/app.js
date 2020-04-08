'use strict'

var customerApp = angular.module('customerApp', [ 'ui.bootstrap', 'customer.controllers',
		'customer.services' ]);
customerApp.constant("CONSTANTS", {
	getCustomerById : "/customer/details/",
	getAllCustomers : "/customer/all",
	addCustomer : "/customer/add"
});