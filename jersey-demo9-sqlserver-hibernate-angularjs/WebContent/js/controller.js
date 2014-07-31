var url = 'http://localhost:8089/RestDemo/rest';


function ListCtrl($scope, $http) {
    $http.get( url + '/users' ).success(function(data) {
        $scope.users = data;
    });

    $scope.orderProp = 'age';
}



function DetailCtrl($scope, $routeParams, $http) {
 
    $http.get( url + '/users/'+$routeParams.userId).success(function(data) {
        $scope.user = data;
    });
    
	$scope.save = function() {
		$http.put( url + '/users',  $scope.user).
		success(function(data, status, headers, config){
			$location.path('/');
        }).error(function(data, status, headers, config){
            alert("error"+status);
        }) ;
	};
	
	$scope.remove =  function(){
		$http({
			method:'DELETE',
			url: url + '/users/'+  $scope.user.userId ,
		})
		.success(function(data, status, headers, config){
			$location.path('/');
        }).error(function(data, status, headers, config){
            alert("error"+status);
        }) ;
	};
}
 
function CreateController($scope, $http) {
 
  
	$scope.add = function() {
		$http.post( url + '/users',  $scope.user).
		success(function(data, status, headers, config){
			$location.path('/');
        }).error(function(data, status, headers, config){
            alert("error"+status);
        }) ;
	};
}

//PhoneListCtrl.$inject = ['$scope', '$http'];
 