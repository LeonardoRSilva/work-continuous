//mouse
myApp.filter('capitalize', function(){
	return function(input, scope){
		input = input.toLowerCase();
		return input.substr(0,1).toUpperCase()+input.substr(1);
	} 
});