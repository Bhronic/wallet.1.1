<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
   <%@ page import = "com.example.model.Logbook" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../css/filter1.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Selected Records!</h1>
<table>
<tr><th>Id</th><th>Date</th><th>Payment</th><th>Amount</th><th>Description</th></tr>
<c:forEach var="record"  items="${record}">
<tr><td>${record.id }</td><td>${record.date}</td><td>${record.payment }</td><td>${record.amount }</td><td>${record.description }</td></tr>
</c:forEach>
</table>
</body>
</html>