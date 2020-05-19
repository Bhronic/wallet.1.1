<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
   <%@ page import = "com.example.model.Logbook" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../css/filter.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<tr><th>Select Date</th></tr>
<% String username = request.getParameter("username"); %>

<form action="get_filter" method="GET">

<input type="hidden" name="user" value="<%=username %>"></br>
<tr><td>
<div class="date">
<input type="date" name="date1"> to <input type="date" name="date2"></br></br>
</div></td></tr>
<tr><td>
<div class="submit">
<input type="submit" value="submit">
</div>
</td></tr>
</form>

</table>
</body>
</html>