

angular.module('appMain', ['ngRoute']).config(['$routeProvider', function ($routeProvider) {
    $routeProvider.
        when('/users', {templateUrl: 'partials/list.html', controller: ListCtrl}).
        when('/users/:userId', {templateUrl: 'partials/detail.html', controller: DetailCtrl}).
		when('/create', {
			templateUrl: 'partials/create.html',
			controller: CreateController
		}).
        otherwise({redirectTo: '/users'});
}]);