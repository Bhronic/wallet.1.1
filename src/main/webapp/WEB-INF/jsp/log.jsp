<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
      <%@ page import = "com.example.model.Admin" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
body{
font-family:"Segoe UI",Arial,sans-serif;
}
.sidenav {
  height: 100%;
  width: 170px;
  position: fixed;
  z-index: 1;
  top: 0;
  left: 0;
  background-color: #111;
  overflow-x: hidden;
  padding-top: 20px;
}

.sidenav a {
  padding: 6px 8px 6px 16px;
  text-decoration: none;
  font-size: 20px;
  color: #818181;
  display: block;
}

.sidenav a.active {
  background-color: #4CAF50;
  color: white;
}

.sidenav a:hover:not(.active) {
  background-color: #555;
  color: white;
}

.main {
  margin-left: 160px; /* Same as the width of the sidenav */
  font-size: 20px; /* Increased text to enable scrolling */
  padding: 0px 10px;
}

@media screen and (max-height: 450px) {
  .sidenav {padding-top: 15px;}
  .sidenav a {font-size: 10px;}
}

table, td, th {  
	
  border: 1px solid #ddd;
  text-align:centre;
}

table {
  border-collapse: collapse;
  width: 100%;
}

td,th {
 text-align: centre;
  padding:10px;
}
th{
	background-color: #800000;
	font-weight:normal;
	color:white;
}
h1{
font-weight:normal;
}

</style>
</head>
<body>
<div class="sidenav">
  <a href="homepage">Home</a>
  </br>
<a href="viewall">View All Records</a>
</br>
<a href="viewuser">View All User</a>
</br>

<a href="viewlogs">View User Logs</a>
</br>

<a href="logout">Logout</a>
</div>
<div class="main">
<h1>List of User Log</h1>
<form action="selectlog" method="GET">

<select id="user" name="user">
<option>Select User</option>
<c:forEach var="list" items="${ul}">
<option > <!-- href="selectuser" -->${list.userName }</option>
</c:forEach>
</select><input type="submit" value="GO">
</form>
<table>
<tr><th>ID</th><th>USER</th><th>DATE/TIME</th><th>ACTIVITY</th></tr>
<c:forEach var="list" items="${loglist}">
<tr><td>${list.id }</td><td>${list.userName }</td><td>${list.dateandtime }</td><td>${list.activity }</td></tr>
</c:forEach>
</table>
</div>
</body>
</html>