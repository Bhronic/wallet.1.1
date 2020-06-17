<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
   	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>ADD</title>
	<link href="../lumino/css/bootstrap.min.css" rel="stylesheet">
	<link href="../lumino/css/font-awesome.min.css" rel="stylesheet">
	<link href="../lumino/css/datepicker3.css" rel="stylesheet">
	<link href="../lumino/css/styles.css" rel="stylesheet">
	
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
	<link rel="stylesheet" type="text/css" href="../css/add.css">
<meta charset="ISO-8859-1">
</head>
<body>
<form action="method_update" action="GET">
<% String id = request.getParameter("id"); %>
<input type="hidden" name="id" value=<%=id %>>
<% String username = request.getParameter("username"); %>
<input type="hidden" name="username" value=<%=username %>>
</form>
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
						<em class="fa fa-envelope"></em><span class="label label-danger">15</span>
					</a>
						<ul class="dropdown-menu dropdown-messages">
							<li>
								<div class="dropdown-messages-box"><a href="profile.html" class="pull-left">
									<img alt="image" class="img-circle" src="http://placehold.it/40/30a5ff/fff">
									</a>
									<div class="message-body"><small class="pull-right">3 mins ago</small>
										<a href="#"><strong>John Doe</strong> commented on <strong>your photo</strong>.</a>
									<br /><small class="text-muted">1:24 pm - 25/03/2015</small></div>
								</div>
							</li>
							<li class="divider"></li>
							<li>
								<div class="dropdown-messages-box"><a href="profile.html" class="pull-left">
									<img alt="image" class="img-circle" src="http://placehold.it/40/30a5ff/fff">
									</a>
									<div class="message-body"><small class="pull-right">1 hour ago</small>
										<a href="#">New message from <strong>Jane Doe</strong>.</a>
									<br /><small class="text-muted">12:27 pm - 25/03/2015</small></div>
								</div>
							</li>
							<li class="divider"></li>
							<li>
								<div class="all-button"><a href="#">
									<em class="fa fa-inbox"></em> <strong>All Messages</strong>
								</a></div>
							</li>
						</ul>
					</li>
					<li class="dropdown"><a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
						<em class="fa fa-bell"></em><span class="label label-info">5</span>
					</a>
						<ul class="dropdown-menu dropdown-alerts">
							<li><a href="#">
								<div><em class="fa fa-envelope"></em> 1 New Message
									<span class="pull-right text-muted small">3 mins ago</span></div>
							</a></li>
							<li class="divider"></li>
							<li><a href="#">
								<div><em class="fa fa-heart"></em> 12 New Likes
									<span class="pull-right text-muted small">4 mins ago</span></div>
							</a></li>
							<li class="divider"></li>
							<li><a href="#">
								<div><em class="fa fa-user"></em> 5 New Followers
									<span class="pull-right text-muted small">4 mins ago</span></div>
							</a></li>
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
 
  <a  id="main" href="balance?username=<%=username%>">Available Balance</a> 
  
  
 <a  id="main" href="report?username=<%=username%>">Monthly Report</a>
 
 <a  id="main" id="signout" href="logout?username=<%=username%>">SignOut</a>
		<div class="map">
		
		
		<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="Home">
					<em class="fa fa-home"></em>
				</a></li>
				<li class="active">UPDATE</li>
			</ol>
		</div><!--/.row-->
		</div>
		</div>

</div>
<div class="addrecord">
<form action="addRecord" method="get">
<table>
<tr><th>Update Record</th></tr>
<tr><td> <div> <em class="fa fa-calendar"></em> Date : 
<input type="date" name="date"></div></td></tr>
</br>
<tr><td><div> <em class="fa fa-credit-card"></em>
Payment: <select id="payment" name="payment">
  <option value="Cash">Cash</option>
  <option value="Credit Card">Credit Card</option>
  <option value="Debit Card">Debit Card</option>
  <option value="UPI">UPI</option>
  <option value="INCOME">INCOME</option>
</select></div></td></tr>
<tr><td>
<div><em class="fa fa-money"></em>
Amount: <input type="text" name="amount"><br>
</div></td></tr>
<tr><td><div><em class="fa fa-comments"></em>
Description: <input type="text" size="15" name="description"><br>
</div></td></tr>


<tr id="save"><td>
<input type="submit" value="SAVE">

</td></tr>

</table>
</form>
</div>

    
    	
	<script src="../lumino/js/jquery-1.11.1.min.js"></script>
	<script src="../lumino/js/bootstrap.min.js"></script>
	<script src="../lumino/js/chart.min.js"></script>
	<script src="../lumino/js/chart-data.js"></script>
	<script src="../lumino/js/easypiechart.js"></script>
	<script src="../lumino/js/easypiechart-data.js"></script>
	<script src="../lumino/js/bootstrap-datepicker.js"></script>
	<script src="../lumino/js/custom.js"></script>
	<script>
		window.onload = function () {
	var chart1 = document.getElementById("line-chart").getContext("2d");
	window.myLine = new Chart(chart1).Line(lineChartData, {
	responsive: true,
	scaleLineColor: "rgba(0,0,0,.2)",
	scaleGridLineColor: "rgba(0,0,0,.05)",
	scaleFontColor: "#c5c7cc"
	});
};
	</script>

</body>



</html>



