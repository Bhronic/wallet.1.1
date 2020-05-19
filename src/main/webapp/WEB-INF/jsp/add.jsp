<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="../css/add.css">
<title>ADD</title>
</head>
<body>
<form action="addRecord" method="post">
<% String username = request.getParameter("username"); %>
<input type="hidden" name="username" value=<%=username %>>
<table>

<tr><th>Enter your daily expense</th></tr>
<tr><td>
Date:  <input type="date" name="date"></td></tr>
<tr><td>
Payment: <select id="payment" name="payment">
  <option value="cash">Cash</option>
  <option value="credit">Credit Card</option>
  <option value="debit">Debit Card</option>
  <option value="upi">UPI</option>
</select></td></tr>
<tr><td>

Amount: <input type="text" name="amount"><br>
</td></tr>
<tr><td>
Description: <input type="text" size="15" name="description"><br>
</td></tr>

<tr><td>
<input type="submit" value="SAVE">

</td></tr>
</table>
</form>
</body>
</html>