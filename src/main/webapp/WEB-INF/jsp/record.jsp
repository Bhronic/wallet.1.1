<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
      <%@ page import = "com.example.model.Logbook" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
body{
font-family:"Segoe UI",Arial,sans-serif;
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
	background-color: lightblue;
}

</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<tr><td>ID</td><td>DATE</td><td>PAYMENT</td><td>AMOUNT</td><td>DESCRIPTION</td><td>USER</td><td>ACTIVE</tr>
<c:forEach var="list" items="${recordlist}">
<tr><td>${list.id }</td><td>${list.date }</td><td>${list.payment }</td><td>${list.amount }</td><td>${list.description }</td><td>${list.user }</td><td>${list.active }</td></tr>
</c:forEach>
</table>
</body>
</html>