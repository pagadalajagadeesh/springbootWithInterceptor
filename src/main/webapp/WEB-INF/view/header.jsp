<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html>
<html>
<head>
<title>Jagdi</title>
<script
	src="<%=request.getContextPath()%>/css/jquery/jquery-3.2.1.min.js"></script>
<meta charset="ISO-8859-1">
<style>
* {
	box-sizing: border-box;
}

body {
	margin: 0;
	font-family: Arial, Helvetica, sans-serif;
}

.header {
	overflow: hidden;
	background-color: #f1f1f1;
	/*padding: 20px 10px;*/
}

.header a {
	float: left;
	color: black;
	text-align: center;
	padding: 12px;
	text-decoration: none;
	font-size: 13px;
	line-height: 25px;
	border-radius: 4px;
}

.header a.logo {
	font-size: 25px;
	font-weight: bold;
}

.header a:hover {
	background-color: #ddd;
	color: black;
}

.header a.active {
	background-color: dodgerblue;
	color: white;
}

.header-right {
	float: right;
}

@media screen and (max-width: 500px) {
	.header a {
		float: none;
		display: block;
		text-align: left;
	}
	.header-right {
		float: none;
	}
}
</style>
<% String validationKey=request.getParameter("validationKey"); %>
</head>
<body>
	<div class="header">
		<a href="#default" class="logo">***</a>
		<div class="header-right" id="menu">
			<a data="welcome" href="welcome?validationKey=<%=validationKey%>"  href="#home">Home</a> 
			<a data="masterData" href="masterData?validationKey=<%=validationKey%>">Master Data</a>
			<a data="customerTransactions" href="customerTransactions?validationKey=<%=validationKey%>">Customer Transactions</a>
			<a data="about" href="#about">About</a>
		</div>
	</div>
</body>
<script>
$(document).ready(function() {
	
	$('#menu').find('a').each(function(e) {
		  if(document.URL.split('/')[4].substring(0,document.URL.split('/')[4].indexOf("?"))==$(this).attr('href').substring(0,$(this).attr('href').indexOf("?"))){
			  $(this).addClass("active");
			  }
	  //  console.log($(this).attr('href'));
	});
})
</script>
</html>