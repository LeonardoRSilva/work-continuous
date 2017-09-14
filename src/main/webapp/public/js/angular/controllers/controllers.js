myApp.controller('homeController',  function($scope, $http){

var BASE_URL;
if (window.location.port === "8081" ) {
    BASE_URL = 'http://localhost:8080/api/usuario';
}else{
    BASE_URL = window.location.origin + '/api/usuario';
}

	$scope.usuario = {};
	$scope.usuarios = [];
	 $scope.showForm = false;
	 $scope.messages;


	$scope.newusuario = function() {
      $scope.usuario = {};
      $scope.showForm = true;
    };


	$scope.cancelusuario = function() {
      $scope.showForm = false;
    };

	//------findall
		function findall(){
				$http.get(BASE_URL).success(function(data){



						$scope.usuarios = data;
                        console.log("scope usuarios:");


						//-----paginacao
					//	paginacao($scope,ngTableParams,usuarios,3);



					// 	//-----paginacao primeiro exemplo
					// $scope.tableParams = new ngTableParams({
					// 	page: 1,
					// 	count: 3
					// }, {
					// 	//total: data.length,
					// 	getData: function($defer, params) {
					// 		$defer.resolve(usuarios.slice((params.page() -1) * params.count(), params.page() * params.count() ));
					// 	}
					// });

					});
		}


		findall();
		//------save
		$scope.saveusuario = function(usuario) {
		      if ((usuario.id === undefined) || (usuario.id === null)) {
		        add(usuario);
		         $scope.usuarios = [];
		         findall();
		      } else {
		        update(usuario);
		        $scope.usuarios = [];
                findall();
		      }
		      $scope.showForm = false;


		};


		//------add
		 function add(index) {
			var requestParams = {
	       	method: 'POST',
	        url: BASE_URL,
	        headers: { 'Content-Type': 'application/json' },
	        data: index
      		};


      		 $http(requestParams).then(function(evt) {
		        var tran = evt.data;
		       console.log($scope.usuarios);

                $scope.usuarios.push(tran.data);

      		});



      		

		}

		

	//------edit
		$scope.edit = function(index){
			
			
			console.log(index);
			$scope.tr_edit = true;
			$scope.usuario_editar = index;
			$scope.usuario_editar.password ='';
		}

	//-----cancelar
		$scope.cancelar = function(){
			$scope.tr_edit = false;
		}

	//----atualizar
		$scope.atualizar = function(index){
			
			var requestParams = {
	       	method: 'PUT',
	        url: BASE_URL,
	        headers: { 'Content-Type': 'application/json' },
	        data: index
      		};
/*
      $http(requestParams).then(function(evt) {
        for (var i = 0; i < $scope.usuarios.length; i++) {
        	//console.log("index:"+index);
          if ($scope.usuarios[i].id == index.id) {

            $scope.usuarios[i] = index;
          }
        }
      });*/
      		$scope.tr_edit = false;
		}
	// ----deletar
		$scope.deletar = function(index){
			var indexof = $scope.usuarios.indexOf(index);
			$scope.usuarios.splice(indexof, 1);
		}


});
