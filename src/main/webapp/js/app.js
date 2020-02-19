var validationKey='';	
var app = angular.module('quoteApp', []);
	app.controller('postcontroller', function($scope, $http, $location) {
		$scope.submitForm = function(){
			
			var url = $location.absUrl() + "createUser";
			debugger
			var config = {
	                headers : {
	                    'Accept': 'application/json'
	                }
	        }
			var data = {
	               username: $scope.username,
	            password: $scope.password,
	            email :$scope.email
	        };
			
			$http.post(url, data, config).then(function (response) {
				$scope.postResultMessage = response.data;
				$scope.formName.$setUntouched()
			}, function error(response) {
				$scope.postResultMessage = "Error with status: " +  response.statusText;
			});
			
		
		}
	});

	app.controller('getcontroller', function($scope, $http, $location) {
		$scope.getfunction = function(){
			debugger
			var url = $location.absUrl() + "getUsers?validationKey="+validationKey;
			
			$http.get(url).then(function (response) {
				$scope.response = response.data
			}, function error(response) {
				$scope.postResultMessage = "Error with status: " +  response.statusText;
			});
		}
	});
	
	

	app.controller('loginController', function($scope, $http, $location) {
		debugger
	$scope.login = function() {
		var url = $location.absUrl()+ "login";
		var data = {
			username : $scope.username1,
			password : $scope.password1
		};
		
		$http.post(url, data).then(function (response) {
			$scope.postResultMessage = response.data;
			validationKey=response.data.validationKey;
			console.log("validationKey is "+validationKey);
			$scope.formName.$setUntouched()
		}, function error(response) {
			$scope.postResultMessage = "Error with status: " +  response.statusText;
		});
	}
});
	
	
	
	