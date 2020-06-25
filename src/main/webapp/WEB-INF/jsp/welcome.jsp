<%@page import="java.util.List"%>
<%@page import="com.example.daoimpl.LogbookDaoImpl"%>
<%@page import="com.example.dao.LogbookDao"%>
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
	<title>Home</title>
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
<meta charset="ISO-8859-1">
<title>Welcome</title>
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
								 <a  id="signout" href="logout?username=<%=username%>">SignOut</a></div>
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
		
		<a id="main" href="home?username=<%=username%>">Home</a>

 <a  id="main" href="add">Add Record</a>

 <a  id="main" href="cards" >Manage Cards</a> <a href="reminders" class="notification"><span>Reminder</span><span class="badge">3</span></a>
 
  <button  id="main" onclick="availablebalance()" style="background-color:white;">Available Balance</button	> 
  
  
 <a  id="main" href="report?username=<%=username%>">Monthly Report</a>
 </div>
 
 <script>
 function balance(){
	var xmlhttp = new XMLHttpRequest();
	xmlhttp.onreadystatechange = function(){
	    if (this.readyState == 4 && this.status == 200) {
	    	document.getElementById("balance").innerHTML = this.responseText;
	    }
	    xhttp.open("GET", "balance.jsp", true);
	    xhttp.send(); 
	}
 }
 </script>
 <script>
 function availablebalance(){
	 var x = "balance";
		document.getElementById("balance").innerHTML=x;

	<!--LogbookDao logbook = new LogbookDaoImpl();
	
	var username = session.getAttribute("username");
	var currentmonth = logbook.getCurrentmonth();
	var totalexpenseincome = logbook.totalexpense(username, 0);
	var totalincome= logbook.calculateincome("income", username, 0);
	var expense = logbook.totalExpenseCrurrentMonth(username, 0, currentmonth);
	var availablebalance = totalincome-(totalexpenseincome-totalincome);-->

	 }
 </script>

<h1 id="balance" style="color:white;"></h1>


		<div class="map">
		
		
		<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#">
					<em class="fa fa-home"></em>
				</a></li>
				<li class="active">Home</li>
			</ol>
		</div><!--/.row-->
		</div>
		</div>
		<form action="get_filter" method="GET"> 

<input type="hidden" name="username"value="<%=username %>"> 

<input type="hidden" name="page" value="1">
<div class="welcome">
<h1>
 Welcome ${login_message }  <br>
 ${record_message }

</h1>
<br>
<div class="expense">

<h3>
Total Expense is ${total_expense}  


</h3>
</div>
</div>
</form>


</br>

</br>	
</br>
		
		</div><!--/.row-->
	
	
	<script src="../lumino/js/jquery-1.11.1.min.js"></script>
	<script src="../lumino/js/bootstrap.min.js"></script>
	<script src="../lumino/js/chart.min.js"></script>
	<script src="../lumino/js/chart-data.js"></script>
	<script src="../lumino/js/easypiechart.js"></script>
	<script src="../lumino/js/easypiechart-data.js"></script>
	<script src="../lumino/js/bootstrap-datepicker.js"></script>
	<script src="../lumino/js/custom.js"></script>



<form action="get_filter" method="get">
<input type="hidden" name="page" value="1">
<div class="input"><input type="date" name="date1" value="DAte"> <span class="to">TO</span> <input type="date" name="date2"> <input type="submit" value="Search">
   </div>
 </form></br></br>
	<div class="limiter">
		<div class="container-table100">
			<div class="wrap-table100">
				<div class="table100 ver1 m-b-110">
					<table data-vertable="ver1">
						<thead>
							<tr class="row100 head">
								<th class="column100 column1" data-column="column1">ID</th>
								<th class="column100 column2" data-column="column2">Date</th>
								<th class="column100 column3" data-column="column3">Payment</th>
								<th class="column100 column4" data-column="column4">Amount</th>
								<th class="column100 column5" data-column="column5">Description</th>
								<th class="column100 column6" data-column="column6">Update</th>
								<th class="column100 column7" data-column="column7">Delete</th>
							
							</tr>
						</thead>
						<tbody>
						<c:forEach var="record"  items="${get_records}">
							<tr class="row100">
								<td class="column100 column1" data-column="column1">${record.id }</td>
								<td class="column100 column2" data-column="column2">${record.date}</td>
								<td class="column100 column3" data-column="column3">${record.payment }</td>
								<td class="column100 column4" data-column="column4">${record.amount }</td>
								<td class="column100 column5" data-column="column5">${record.description }</td>
								
								<td class="column100 column6" data-column="column6"><a href="recorduptodate?username=<%=username%>&id=${record.id }">Update</a></td>
								<td class="column100 column7" data-column="column7"><a  href="deleterecord?username=<%=username%>&id=${record.id }&date=${record.date}&payment=${record.payment}&amount=${record.amount}&description=${record.description}">Delete</a></td>
					<!--  		<td class="column100 column8" data-column="column8"><button onclick="deleterecord()">Delete</button>
					 			<script>
								function deleterecord(){
									if(confirm("Confirm Delete?")){
										location.href='deleterecord?&id=${record.id }&date=${record.date}&payment=${record.payment}&amount=${record.amount}&description=${record.description}';
									}else{
										
									}
								}
								
								</script>
								</td> -->
							</tr>

			</c:forEach>
						</tbody>
					</table>
					
					
				<% 
					session=request.getSession();
					int size=(int)session.getAttribute("size");
					int limit =Math.round(size/10)+1;
					System.out.print(limit);
					for (int i=1;i<=limit;i++){ %>
					<a  id="page"  href="/pages?page=<%=i%>&date1=${date1}&date2=${date2}"><%= i %></a>
	
					<%} %>
				</div></div></div></div>

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