	var app = angular.module('quoteApp', []);
	app.controller('postcontroller', function($scope, $http, $location) {
		$scope.submitForm = function(){
			var url = $location.absUrl() + "products";
			
			var config = {
	                headers : {
	                    'Accept': 'text/plain'
	                }
	        }
			var data = {
	               id: $scope.id,
	            quote: $scope.name
	        };
			
			$http.post(url, data, config).then(function (response) {
				$scope.postResultMessage = response.data;
			}, function error(response) {
				$scope.postResultMessage = "Error with status: " +  response.statusText;
			});
			
		
		}
	});

	/*app.controller('getcontroller', function($scope, $http, $location) {
		$scope.getfunction = function(){
			var url = $location.absUrl() + "quotes";
			
			$http.get(url).then(function (response) {
				$scope.response = response.data
			}, function error(response) {
				$scope.postResultMessage = "Error with status: " +  response.statusText;
			});
		}
	});*/