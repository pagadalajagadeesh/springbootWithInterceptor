var getUrl = window.location;
var baseUrl = getUrl.protocol + "//" + getUrl.host + "/"
		+ getUrl.pathname.split('/')[1];

var validationKey = new URLSearchParams(window.location.search)
		.get('validationKey');
var welcome = angular.module('wApp', []);

welcome.controller('registerEmployeeController', function($scope, $http,
		$location) {
	$scope.submit = function() {
		var url = baseUrl + "/saveEmployee?validationKey=" + validationKey;
		var config = {
			headers : {
				'Accept' : 'application/json'
			}
		}
		var data = {};
		data.firstName = $scope.firstName;
		data.lastName = $scope.lastName;
		data.mobileNumber = $scope.mobileNumber;
		data.email = $scope.email;
		data.joiningDate = $scope.joiningDate;
		//data.masterDataId = $scope.item;
		$http.post(url, data, config).then(
				function(response) {
					$scope.postResultMessage = response.data;
					$("#registerEmployeeForm")[0].reset();
					$("#closeModal").click();
					location.reload();

				},
				function error(response) {
					$scope.postResultMessage = "Error with status: "
							+ response.statusText;
				});

	}
});
