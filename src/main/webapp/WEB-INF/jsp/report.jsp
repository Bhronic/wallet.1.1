     <!-- chart.jsp-->
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    	pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>
    <head>
<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<title>Report</title>
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

<title>Monthly Report</title>
    
    <script type="text/javascript">
    window.onload = function() {
    	 
    	var dps = [[]];
    	var chart = new CanvasJS.Chart("chartContainer", {
    		theme: "dark2", // "light1", "dark1", "dark2"
    		animationEnabled: true,
    		title: {
    			text: "Average Expense"
    		},
    	//	axisX: {
    		//	valueFormatString: "MMM"
    //		},
    		axisY: {
    			title: "Expense in (thousands )",
    			suffix: " "
    		},
    		data: [{
    			type: "line",
    		//	xValueType: "dateTime",
    		//	xValueFormatString: "MMM",
    			yValueFormatString: "#,##0 ",
    			dataPoints: dps[0]
    		}]
    	});
    	 
    //	var xValue;
    	var label;
    	var yValue;
    	 
    	<c:forEach items="${dataPointsList}" var="dataPoints" varStatus="loop">	
    		<c:forEach items="${dataPoints}" var="dataPoint">
    		label = "${dataPoint.label}";
    			yValue = parseFloat("${dataPoint.y}");
    			dps[parseInt("${loop.index}")].push({
    				label : label,
    				y : yValue
    			});		
    		</c:forEach>	
    	</c:forEach> 
    	 
    	chart.render();
    	 
    	}
    </script>

   

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
 
  <a  id="main" href="balance?username=<%=username%>">Available Balance</a> 
  
  
 <a  id="main" href="report?username=<%=username%>">Monthly Report</a>
 </div>

		<div class="map">
		
		
		<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#">
					<em class="fa fa-home"></em>
				</a></li>
				<li class="active">Monthly Report</li>
			</ol>
		</div><!--/.row-->
		</div>
		</div>
		

		
		
		
		<div id="chartContainer" style="height: 325px; width: 100%; margin-top:-40px; float: right;postion:fixed; "></div>
		
    	<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
		
		
				    	<div class="info">
<h3>Summary :</h3></br>
        <h4>Last Month Total : ${total_expense_lastmonth} &nbsp & &nbsp Current Month Total : ${total_expense_currentmonth}</h4></br>
<h4>${message } Compared To Last Month .</h4></div></br>

		
		
		<div class="table">
		<form action="report" method="get">
		<select id="month" name="month">
		<option value="0">Select Month </option>
		<option value="1">January</option>
		<option value="2">February</option>
		<option value="3">March</option>
		<option value="4">April</option>
		<option value="5">May</option>
		<option value="6">June</option>
		<option value="7">July</option>
		<option value="8">August</option>
		<option value="9">September</option>
		<option value="10">October</option>
		<option value="11">November</option>
		<option value="12">December</option>
		</select>
		<input type="submit" value="Search">
		</form>



		<table>
	<tr><th>Id</th><th>Date</th><th>Amount</th><th>Payment</th><th>Description</th></tr>
	<c:forEach var="record" items="${record_list }">
			<tr>
			<td >${record.id }</td>
								<td >${record.date}</td>
								<td >${record.payment }</td>
								<td >${record.amount }</td>
								<td >${record.description }</td></tr>
								</c:forEach>
		</table>
		<% 
					session=request.getSession();
					int size=(int)session.getAttribute("size");
					int limit =Math.round(size/10)+1;
					System.out.print(limit);
					for (int i=1;i<=limit;i++){ %>
		<a href="report?page=<%=i %>&month=${month }"><%=i%></a>
			<%} %>
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
 
                         

