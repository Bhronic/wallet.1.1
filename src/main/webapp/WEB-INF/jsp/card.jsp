<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
   <%@ page import = "com.example.model.Logbook" %>
<!DOCTYPE html>
<html>
<head>

	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Cards</title>
	<link href="../lumino/css/bootstrap.min.css" rel="stylesheet">
	<link href="../lumino/css/font-awesome.min.css" rel="stylesheet">
	<link href="../lumino/css/datepicker3.css" rel="stylesheet">
	<link href="../lumino/css/styles.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="./css/card.css"/>
	
	<!--Custom Font-->
	<link href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="../Table/images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="../Table/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="../Table/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="../Table/vendor/animate/animate.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="../Table/vendor/select2/select2.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="../Table/vendor/perfect-scrollbar/perfect-scrollbar.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="../Table/css/util.css">
	<link rel="stylesheet" type="text/css" href="../Table/css/main.css">
<!--===============================================================================================-->

	<link rel="stylesheet" type="text/css" href="../css/welcome.css">
<meta charset="ISO-8859-1">

</head>
<body>


<% String username = request.getParameter("username"); %>
	<nav class="navbar navbar-custom navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#sidebar-collapse"><span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span></button>
				<p class="navbar-brand" href="#"><span>Wallet  </span>  Management</p>
				<ul class="nav navbar-top-links navbar-right">
					<li class="dropdown"><a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
						<em class="fa fa-lock"></em>
					</a>
						<ul class="dropdown-menu dropdown-messages">
							<li>
								<div class="dropdown-messages-box">
								</div>
							</li>
							<li class="divider"></li>
							<li>
								<div class="dropdown-messages-box">
								 <a  id="main" id="signout" href="logout?username=<%=username%>">SignOut</a></div>
							</li>
						
						</ul>
					</li>
						<li class="dropdown"><a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
						<em class="fa fa-bell"></em><span class="label label-info">${Notification }</span>
					</a>
						<ul class="dropdown-menu dropdown-alerts">
							<li>
									<h4>Reminders :- </h4></br>
									<c:forEach var="list" items="${bell }">
									
								<a class ="reminders" href="reminders">${list }</a></br>
									</c:forEach>
									
							</li>
						</ul>
					</li>
				</ul>
			</div>
		</div><!-- /.container-fluid -->
	</nav>

		
		<div class="main">
		
		<a id="main" href="home">Home</a>

 <a  id="main" href="add">Add Record</a>

 <a  id="main" href="cards" >Manage Cards</a> <a href="reminders" class="notification"><span>Reminder</span><span class="badge">3</span></a>
 
  <a  id="main" href="balance">Available Balance</a> 
  
  
 <a  id="main" href="report?username=<%=username%>">Monthly Report</a>
 
</div>
		<div class="map">
		
		
		<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#">
					<em class="fa fa-home"></em>
				</a></li>
				<li class="active">Manage Cards</li>
			</ol>
		</div><!--/.row-->
		</div>
		</div>

<a href="addcard">Add New Card</a>
<br><br>

<div class="card-columns" style="width:800px; margin-left:50px;"> 
			<c:forEach var="list" items="${cardlist }">
		
				<div class="card bg-light ">
				<div class="card-body text-left">
				
					<h4 class="card-title"> ${list.mastervisa}</h4>
						
						<br>
						
						<p class="card-text">${ list.number}</p>
						
						<br>
						
							
					<p class="card-text">		${list.debitcredit }    &nbsp &nbsp ${list.expiry}</p>
					
					<br>
						
					<p class="card-text">		${list.name } &nbsp &nbsp ${list.cvv } </p>
					
						<br>
					<p class="card-text">		<a href="deletecard?id=${list.id }"  class="card-link">Delete</a></p>
							
						
						</div>
				</div>
					
					</c:forEach>
				</div>
			
				



<!--===============================================================================================-->	
	<script src="../Table/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="../Table/vendor/bootstrap/js/popper.js"></script>
	<script src="../Table/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="../lumino/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src=../lumino/js/main.js"></script>
</body>
</html>