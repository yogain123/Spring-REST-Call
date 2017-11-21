var app = angular.module("myApp",[]);
app.controller("myCtrl",function($scope,$http)
		{
	
	setTimeout(function() {
		$scope.demo();
		
	},50);
	
	
	$scope.add = function()
	{
		
		$http.post("/test/list",$scope.workListQuery).then(function()
				{
			console.log("success");
			
				},function()
				{
					console.log("error");
				});
		
		setTimeout(function() {
			$scope.demo();
			
		},50);
		
		
		
		
		
	};
	
	$scope.del = function(data)
	{
		console.log(data);
		let url = "/test/list/"+data;
		$http.get(url).then(function(dataCame)
				{
				console.log(dataCame);
				},function()
				{
					console.log("errorrrrr")
				});
		setTimeout(function() {
			$scope.demo();
			
		},50);
		
		
	};
	
	$scope.update = function(app)
	{
		$scope.newApp = app;
		console.log("newApp "+JSON.stringify($scope.newApp));
		//console.log(JSON.stringify($scope.workListQueryModal));
		$scope.workListQueryModal.firstName = $scope.newApp.firstName;
		$scope.workListQueryModal.lastName = $scope.newApp.lastName;
		$scope.workListQueryModal.email = $scope.newApp.email;
		//console.log(JSON.stringify($scope.workListQueryModal));
		console.log("inside update");
		$scope.title = "Update";
		$scope.description = "Update Data";
		$('#modal').modal('show')
		
		
	};
	
	$scope.ok = function()
	{
		console.log("inside ok");
		
		console.log(JSON.stringify($scope.workListQueryModal));
		
		$http.post("/test/list/update",$scope.workListQueryModal).then(function()
				{
			console.log("success");
			
				},function()
				{
					console.log("error");
				});
		
		setTimeout(function() {
			$scope.demo();
			
		},50);
		
	};

	$scope.demo = function () {
		$http.get("/test/next").then(function(data){
			$scope.appData = data.data;
			console.log("data success "+JSON.stringify(data.data));
		},function(error)
		{
			console.log("Error");
		});
		$http.get("/test/list").then(function(data){
			$scope.appData = data.data;
			console.log("data success "+JSON.stringify(data.data));
		},function(error)
		{
			console.log("Error");
		});
    };
		});
