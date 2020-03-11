 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="javax.servlet.*"%>
<!DOCTYPE HTML>

<html>
<head>
<title>home</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<script src="<%=request.getContextPath()%>/js/angular.min.js"></script>
<script src="<%=request.getContextPath()%>/js/app.js"></script>
<!-- <link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" /> -->
<link href="<%=request.getContextPath()%>/css/app.css" rel="stylesheet" />
<%@include file="header.jsp" %>


<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->
<link rel="icon" type="image/png"
	href="<%=request.getContextPath()%>/images/icons/favicon.ico" />
<!--===============================================================================================-->
<%-- <link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/bootstrap/css/bootstrap.min.css"> --%>
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/fonts/iconic/css/material-design-iconic-font.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/animate/animate.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/animsition/css/animsition.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/select2/select2.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/util.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/main.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/alertify.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/modalForm.css">
<!--===============================================================================================-->

<!--===============================================================================================-->
<script
	src="<%=request.getContextPath()%>/css/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
<script
	src="<%=request.getContextPath()%>/css/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
<script src="<%=request.getContextPath()%>/css/bootstrap/js/popper.js"></script>
<script
	src="<%=request.getContextPath()%>/css/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
<script src="<%=request.getContextPath()%>/css/select2/select2.min.js"></script>
<!--===============================================================================================-->
<script
	src="<%=request.getContextPath()%>/css/daterangepicker/moment.min.js"></script>
<script
	src="<%=request.getContextPath()%>/css/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
<script
	src="<%=request.getContextPath()%>/css/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
<script src="<%=request.getContextPath()%>/js/main.js"></script>
<script src="<%=request.getContextPath()%>/js/welcome.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script
	src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
<script
	src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css">

<!-- <link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"> -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">

<!-- <script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script> -->
<script
	src="https://cdn.datatables.net/buttons/1.6.1/js/dataTables.buttons.min.js"></script>
<script
	src="https://cdn.datatables.net/buttons/1.6.1/js/buttons.flash.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/pdfmake.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/vfs_fonts.js"></script>
<script
	src="https://cdn.datatables.net/buttons/1.6.1/js/buttons.html5.min.js"></script>
<script
	src="https://cdn.datatables.net/buttons/1.6.1/js/buttons.print.min.js"></script>
</head>
<body ng-app="wApp" >
	<!-- class="container-login100" style="background-image: url('images/bg-01.jpg');"> -->
		<div id="contact"><button type="button" class="btn btn-info btn" data-toggle="modal" data-target="#contact-modal">Show Customer Form</button></div>
<div id="contact-modal" class="modal fade" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content" >
			<div class="modal-header" style="background-color: #cccccc;">
				<h3 style="margin-left: 37%;" >Register Customer</h3>
			</div>
			<form ng-submit="submit()" id="registerEmployeeForm" ng-controller="registerEmployeeController">
				<div class="modal-body">				
					<div class="form-group">
						<label for="name">First name:</label>
						<input type="text" name="firstName" ng-model="firstName"  id="firstName"  class="form-control">
					</div>
					<div class="form-group">
						<label for="name">Last name:</label>
						<input type="text" name="lastName" ng-model="lastName"  id="lastName"  class="form-control">
					</div>
					<div class="form-group">
						<label for="name">Mobile Number:</label>
						<input type="text" name="mobileNumber" ng-model="mobileNumber"  id="mobileNumber"  class="form-control">
					</div>
					<div class="form-group">
						<label for="email">Email:</label>
						<input type="email" name="email" id="email"  ng-model="email" class="form-control">
					</div>
					<!-- <div  class="form-group">
					<label for="Item">Item:</label>
						<select id="item" name="Item"  ng-model="item" class="form-control">
								<option value="s">Select</option>
						</select>
					</div> -->
					<div class="form-group">
						<label for="message">Joining Date:</label>
						<input type="date" name="joiningDate" id="joiningDate" ng-model="joiningDate" class="form-control">
					</div>					
				</div>
				<div class="modal-footer">					
					<button type="button" class="btn btn-default" id="closeModal" data-dismiss="modal">Close</button>
					 <button type="submit" class="btn btn-success">Register</button>
				</div>
			</form>
		</div>
	</div>
</div>
	<div style=" width: 90%; margin-left: 5%;">
		<table id="example" class="table table-striped table-bordered">
			<thead>
				<tr>
					<th>ID</th>
					<th>FirstName</th>
					<th>LastName</th>
					<th>Mobile Number</th>
					<th>eMail</th>
				</tr>
			</thead>
		</table>
	</div>
</body>
<script>
	$(document).ready(
			function() {
				var text = '<tbody>';
				$.ajax({
					type : 'GET',
					url : "getEmployees?validationKey="
							+ new URLSearchParams(window.location.search)
									.get('validationKey'),
					success : function(data) {
						jQuery.each(data, function(index, item) {
							text += '<tr><td>' + item.id + '</td><td>'
									+ item.firstName + '</td><td>'
									+ item.lastName + '</td><td>'
									+ item.mobileNumber + '</td><td>'
									+ item.email + '</td></tr>';
						});
						text += '</tbody>';
						$('#example').append(text);
						$('#example').DataTable({
							"bLengthChange": false
							/* dom: 'Bfrtip',
					        buttons: [
					        	 'copyHtml5',
					             'excelHtml5',
					             'csvHtml5',
					             'pdfHtml5'
					        ] */
							});
					}
				});

				//

			});

	$(document).ready( function() {
		
		$('#item').empty().append('<option>select</option>');        
	    $.ajax({
	            url: 'getMasterData?validationKey='+ new URLSearchParams(window.location.search).get('validationKey'),
	            dataType: 'json',
	            type: 'GET',
	            success: function(response) {
	              var array = response;
	              if (array != '')
	              {
	                for (i in array) {                        
	                 $("#item").append("<option value="+array[i].id+">"+array[i].name+"</option>");
	               }

	              }

	            },
	            error: function(x, e) {

	            }

	        });

	});
</script>
</html>