var getUrl = window.location;
var baseUrl = getUrl.protocol + "//" + getUrl.host + "/"
		+ getUrl.pathname.split('/')[1];

var validationKey = new URLSearchParams(window.location.search)
.get('validationKey');

var welcome = angular.module('masterDataApp', []);

welcome.controller('submitMasterDataController', function($scope, $http,
		$location) {
	
	$scope.saveMasterData = function() {
		var url = baseUrl + "/saveMasterData?validationKey=" + validationKey;
		var config = {
			headers : {
				'Accept' : 'application/json'
			}
		}
		var data = {};
		data.name = $scope.name;
		data.cost = $scope.cost;
		if((data.name==null || data.name=='') || (data.cost==null || data.cost=='')){
			return false;
		}
		
		$http.post(url, data, config).then(
				function(response) {
					$scope.postResultMessage = response.data;
					
					debugger
					

				},
				function error(response) {
					$scope.postResultMessage = "Error with status: "
							+ response.statusText;
				});
		$("#saveMasterData")[0].reset();
		location.reload();

	}
});