/**
 * 
 */
(function() {
  var app = angular.module('jobSearch', ['ngSanitize']	);
  app.controller('VagasController', function($scope, $http) {
	  $scope.tiposOrdenacao = [
	                 	      { nome : "Crescente", codigo : "CRES"},
	                 	      { nome : "Decrescente", codigo: "DESC"}
	                 	  ];
	  $scope.ordenacaoSelecionada = {nome : "", codigo: ""};
	  $scope.filtros = {
			  vagas : '',
			  cidade: '',
			  ordenar: '',
			  tipoOrdenacao: ''
	  };
	  
	  
	  $scope.getVagas = function(){
		  this.filtros.tipoOrdenacao = this.ordenacaoSelecionada.codigo;
		  $http.get('http://localhost:8080/backend-test/api/vagas?filtro='+this.filtros.vagas+'&cidade='+this.filtros.cidade+'&salario='+this.filtros.tipoOrdenacao).
		        then(function(response) {
		        	$scope.vagasJson = angular.fromJson(response.data.docs);

		        	console.log("Encontrados "+response.data.docs.length+"registros");
		        }, function(error){
		        	console.log(error);
		        });  
	  };
  });
})();