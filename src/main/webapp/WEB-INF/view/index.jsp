<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="javax.servlet.*"%>
<!DOCTYPE HTML>

<html>
<head>
<title>welcome</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<script src="<%=request.getContextPath()%>/js/angular.min.js"></script>
<script src="<%=request.getContextPath()%>/js/app.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<link href="<%=request.getContextPath()%>/css/app.css"
	rel="stylesheet" />
</head>
<body>

	<div class="container" ng-app="quoteApp">

		<h3 style="color: blue">create users</h3>

		<div ng-controller="postcontroller">
			<form class="form-horizontal" method="post" name="quoteForm"
				ng-submit="submitForm()">
				<!-- <div class="form-group">
				<label class="control-label col-sm-2" for="quoteId">Id:</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" name="quoteId" id="quoteId"
						placeholder="1" ng-model="id"/>
				</div>
			</div> -->
				<div class="form-group">
					<label class="control-label col-sm-2" for="quote">username
						: </label>
					<div class="col-sm-5">
						<input type="text" class="form-control" name="username"
							id="username" placeholder="Enter username" ng-model="username" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="quote">password
						: </label>
					<div class="col-sm-5">
						<input type="text" class="form-control" name="password"
							id="password" placeholder="Enter password" ng-model="password" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="quote">email:</label>
					<div class="col-sm-5">
						<input type="email" class="form-control" name="email" id="email"
							placeholder="Enter email" ng-model="email" />
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

		<div class="col-sm-offset-2 col-sm-10" ng-controller="getcontroller">
			<button id="btn-id" type="button" class="btn btn-primary"
				ng-click="getfunction()">Get All Users</button>
			<ul>
				<li ng-repeat="cust in response">{{cust.username + " " +
					cust.email +" "+cust.createdAt }}</li>
			</ul>
		</div>

		<div ng-controller="getcontroller">
			<button id="btn-id" type="button" class="btn btn-primary"
				ng-click="getfunction()">Get All Users</button>
			<table>
				<tr ng-repeat="cust in response">
					<td>{{cust.username}}</td>
					<td>{{ cust.email }}</td>
					<td>{{ cust.createdAt }}</td>
				</tr>
			</table>

		</div>

	</div>
</body>
</html>