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
<script src="<%=request.getContextPath()%>/js/reports/highcharts.js"></script>
<script src="<%=request.getContextPath()%>/js/reports/exporting.js"></script>

<script src="<%=request.getContextPath()%>/js/reports/accessibility.js"></script>
<script src="<%=request.getContextPath()%>/js/reports/export-data.js"></script>

<script src="<%=request.getContextPath()%>/js/reports/year-select.js"></script>
<link rel="stylesheet" type="text/css" 	href="<%=request.getContextPath()%>/css/reports/reports.css">
</head>
<body>
<div>
<label>Select Year :</label> <select class="yrselectdesc form-control" id="reportSelect"></select>
</div>
<div>
<figure class="highcharts-figure">
    <div id="container"></div>

</figure>
</div>
</body>
<script>
function report(year){

var categoriesArr=[];
var dataArr=[];

	$.ajax({
		type : 'GET',
		url : "getCustomerTransactionReportData?year="+year+"&validationKey="+ new URLSearchParams(window.location.search).get('validationKey'),
		success : function(data) {
			jQuery.each(data, function(index, item) {
				categoriesArr.push(item.month)
				dataArr.push(item.cost)
			});
			generateReport(categoriesArr,dataArr,year)
		}
	});

	/* console.log(categoriesArr)
	console.log(dataArr)
	var data = ['Jan','Feb','Mar','Apr','May','Jun','Jul','Aug','Sep','Oct','Nov','Dec'];
	console.log(data) */

}
$(document).ready(function(e) {
//    $('.yearselect').yearselect();

    $('.yrselectdesc').yearselect({step:1, order: 'desc',start:2017});
    report(new Date().getFullYear() );
  //  $('.yrselectasc').yearselect({order: 'asc'});
});

$('select').on('change', function() {
	report(this.value );
	});

function generateReport(categoriesArr,dataArr,year){
	
	Highcharts.chart('container', {
	    chart: {
	        type: 'column'
	    },
	    title: {
	        text: 'Sales report of '+year
	    },
	   /*  subtitle: {
	        text: 'Source: WorldClimate.com'
	    }, */
	    xAxis: {
	        categories: categoriesArr,
	        crosshair: true
	    },
	    yAxis: {
	        min: 0,
	        title: {
	            text: 'Turn over in Rupees '
	        }
	    },
	    tooltip: {
	        headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
	        pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
	            '<td style="padding:0"><b>{point.y:.1f} mm</b></td></tr>',
	        footerFormat: '</table>',
	        shared: true,
	        useHTML: true
	    },
	    plotOptions: {
	        column: {
	            pointPadding: 0.2,
	            borderWidth: 0
	        }
	    },
	    series: [{
	        name: 'Sales & Servicing',
	        data: dataArr

	    }]
	});
}
</script>
</html>