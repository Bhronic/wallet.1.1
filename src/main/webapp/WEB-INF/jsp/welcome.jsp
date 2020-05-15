<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
   <%@ page import = "com.example.model.logbook" %>
<!DOCTYPE html>
<html>
<head>
<style>
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
	background-color: lightblue;
}
</style>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>
<h1>
${login_message}
${record_message }
</h1>
<a href="add">Add Record</a>
<table>
<tr><th>Id</th><th>Date</th><th>Payment</th><th>Amount</th><th>Description</th></tr>
<c:forEach var="record"  items="${get_records}">
<tr><td>${record.id }</td><td>${record.date}</td><td>${record.payment }</td><td>${record.amount }</td><td>${record.description }</td></tr>

</c:forEach>

</table>

</body>
</html>