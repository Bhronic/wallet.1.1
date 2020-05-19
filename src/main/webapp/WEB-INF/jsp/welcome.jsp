<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
   <%@ page import = "com.example.model.Logbook" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../css/welcome.css">
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>
<h1>
${login_message}
${record_message }
<% String username = request.getParameter("username"); %>
</h1>
</br>	
</br>

<a href="add?username=<%=username%>">Add Record</a>
<a href="filterrecords?username=<%=username%>">Filter Records</a>

<table>
<tr><th>Id</th><th>Date</th><th>Payment</th><th>Amount</th><th>Description</th><th>Update</th><th>Delete</th></tr>
<c:forEach var="record"  items="${get_records}">
<tr><td>${record.id }</td><td>${record.date}</td><td>${record.payment }</td><td>${record.amount }</td><td>${record.description }</td><td><a href="recorduptodate?username=<%=username%>&id=${record.id }">Update</a></td><td><a href="deleterecord?username=<%=username%>&id=${record.id }&date=${record.date}&payment=${record.payment}&amount=${record.amount}&description=${record.description}">Delete</a></td></tr>

</c:forEach>

</table>

</body>
</html>