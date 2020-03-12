 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="javax.servlet.*"%>
<!DOCTYPE HTML>

<html>
<head>
<title>home</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<script
	src="<%=request.getContextPath()%>/css/jquery/jquery-3.2.1.min.js"></script>
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
<script src="<%=request.getContextPath()%>/js/masterData.js"></script>
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
	
	<link href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.6-rc.0/css/select2.min.css" rel="stylesheet" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.6-rc.0/js/select2.min.js"></script>
<script src="<%=request.getContextPath()%>/js/date-dd-MMM-yyyy.js"></script>
</head>
<body ng-app="masterDataApp" >
<div class="container" class="h-65 d-inline-block">
  <div class="row">
    <div class="col-sm-3">
      <form ng-controller="submitMasterDataController"  id="saveMasterData"  >
				<div class="modal-body">
					<div class="form-group">
						 <label>Select Customer : </label>
					        <select class="form-control select2" required="required" id="userSelect" p>
					        </select>
					</div>
					<div class="form-group">
						 <label>Select Item/Items : </label>
					        <select multiple class="form-control select2" required="required" id="itemSelect">
					        </select>
					</div>
					<div class="form-group">
						<label for="message">Servicing Date:</label>
						<input type="date" name="servicingDate" required="required" id="servicingDate" ng-model="servicingDate" class="form-control">
					</div>
					<div class="form-group">
						<label for="name">Cost :</label>
						<input type="number" name="cost" required="required" ng-model="cost"  id="cost"  class="form-control">
					</div>
				</div>
				<div class="modal-footer">					
					<button type="reset" class="btn btn-danger"  >Reset</button>
					 <button type="submit" id="submitCustomerTransaction" class="btn btn-success">Save</button>
				</div>
			</form>
    </div>
    <div class="col-sm-9">
      <table id="masterDataTable" class="table table-striped table-bordered">
			<thead>
				<tr>
					<th>ID</th>
					<th>Customer Name</th>
					<th>Service</th>
					<th>Service Date</th>
					<th>Cost</th>
				</tr>
			</thead>
		</table>
    </div>
  </div>
</div>
</body>
<script>
	$(document).ready(
			function() {
				var text = '<tbody>';
				$.ajax({
					type : 'GET',
					url : "getCustomerTransactionData?validationKey="
							+ new URLSearchParams(window.location.search)
									.get('validationKey'),
					success : function(data) {
						jQuery.each(data, function(index, item) {
							text += '<tr><td>'+ item.id +'</td><td>' + item.customer.firstName +' '+ item.customer.lastName+ '</td><td>'
									+ item.masterDataDetails + '</td><td>'
									+ item.serviceDate + '</td><td>'
									+ item.cost + '</td>';
							
						});
						text += '</tbody>';
						$('#masterDataTable').append(text);
						$('#masterDataTable').DataTable({
							"bLengthChange": false,
							columnDefs: [
							       { type: 'date-dd-mmm-yyyy', targets: 4}
							     ]
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

	/* ********************** */
					var append='';
				$.ajax({
					type : 'GET',
					url : "getMasterData?validationKey="+ new URLSearchParams(window.location.search).get('validationKey'),
					success : function(data) {
						jQuery.each(data, function(index, item) {
							
							append+= '<option value='+item.id+'>'+item.name+'</option>' 
						});
						$('#itemSelect').append(append);
						 $('#itemSelect').select2({width: "100%",placeholder: 'Choose One'	}).val('').trigger('change');
					}
				});


				var appendItem='';
				$.ajax({
					type : 'GET',
					url : "getEmployees?validationKey="+ new URLSearchParams(window.location.search).get('validationKey'),
					success : function(data) {
						jQuery.each(data, function(index, item) {
							
							appendItem+= '<option value='+item.id+'>'+item.firstName+' '+item.lastName+'</option>' 
						});
						$('#userSelect').append(appendItem);
						  $('#userSelect').select2({width: "100%",placeholder: 'Choose One'	}).val('').trigger('change');
					}
				});
				
			});

	
	
	 // $('#itemSelect').select2();


	function disableMe(id) {
		var data={}
		data.id=id;
		$.ajax({
		      type: 'PUT',
		      url: "disableMasterData/"+id+'?validationKey='+ new URLSearchParams(window.location.search).get('validationKey'),
		      success: function(resultData) {
		    	  location.reload();
			       },
			       error: function(resultData) {

				    alert(resultData); }
		});
	}

	function enableMe(id) {
		var data={}
		data.id=id;
 		$.ajax({
		      type: 'PUT',
		      url: "enableMasterData/"+id+'?validationKey='+ new URLSearchParams(window.location.search).get('validationKey'),
		      success: function(resultData) {
		    	  location.reload();
			       },
			       error: function(resultData) {

				    alert(resultData); }
		}); 

		
	}


	$("#submitCustomerTransaction").click(function() {
		
	
			if ($('#userSelect').val() == null
								|| $('#itemSelect').val() == ''
								|| $('#servicingDate').val() == ''
								|| $('#cost').val() == '') {
							return false
						}

				$.ajax({
					type : 'POST',
					url : 'saveCustomerTransactionData/'
							+ parseInt($('#userSelect').val())
							+ '/'
							+ $('#itemSelect').val().map(Number)
							+ '/'
							+ $('#servicingDate').val()
							+ '/'
							+ $('#cost').val()
							+ '/?validationKey='
							+ new URLSearchParams(window.location.search)
									.get('validationKey'),
					success : function(resultData) {
						location.reload();
					},
					error : function(resultData) {

						alert("failed to save ");
					}
				});
			});
</script>
</html>