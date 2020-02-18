<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
 
<html>
<head>
	  <title>Quotes</title>
	  <meta charset="utf-8" />
	  <meta name="viewport" content="width=device-width, initial-scale=1" />
	       <script src="/js/angular.min.js" ></script>    
        <script src="/js/app.js"></script>
	  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
	  <link href="css/app.css" rel="stylesheet"/>
</head>
<body>
 
<div class="container" ng-app="quoteApp">
 
	<h3 style="color:blue">Feel inspired by Famous Quotes.</h3>
	
	<div ng-controller="postcontroller">
		<form class="form-horizontal" name="quoteForm" ng-submit="submitForm()">
			<div class="form-group">
				<label class="control-label col-sm-2" for="quoteId">Id:</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" name="quoteId" id="quoteId"
						placeholder="1" ng-model="id"/>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="quote">Quote:</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" name="quote" id="quote"
						placeholder="Enter Quote" ng-model="quote"/>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">Submit</button>
				</div>
			</div>
		</form>
 
		<div class="col-sm-offset-2 col-sm-10">
			<p>{{postResultMessage}}</p>
		</div>
	</div>
	
	<!-- <div class="col-sm-offset-2 col-sm-10" ng-controller="getcontroller">
		<button id="btn-id" type="button" class="btn btn-primary" ng-click="getfunction()">Get All Quotes</button>
		<ul>
        	<li ng-repeat="cust in response">{{cust.quoteId + " " + cust.quote}}</li>
    	</ul>
	</div> -->
	
</div>
</body>
</html>