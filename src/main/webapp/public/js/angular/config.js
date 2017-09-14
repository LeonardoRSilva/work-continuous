 var $=jQuery;

var myApp = angular.module('myApp', ['ngRoute']);
	var produtos = [];
	
	// var produtos = [
	// 	{nome: 'monitor', preco: '15.50', data: 1393032898247},
	// 	{nome: 'Teclado', preco: '150.50', data: 1393032898247},
	// 	{nome: 'Placa de Video', preco: '15550', data: 1393032898247}
	// ];
myApp.config(function($routeProvider){
	$routeProvider
	.when('/',{templateUrl: 'app/views/home.html', controller: 'homeController'})

});


/*function paginacao($scope,ngTableParams,arrayPaginacao,porPagina){
	$scope.tableParams = new ngTableParams({
		page:1,
		count: porPagina
	}, {
		getData: function($defer, params) {
			$defer.resolve(arrayPaginacao.slice((params.page() -1) * params.count(), params.page() * params.count()));
		}
	});
}
*/