<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html>
    <html>
    <head>
<link rel="stylesheet" type="text/css" href="../css/add.css">
    <title>Update</title>
    </head>
    <body>
    <form action="method_update" action="GET">
    <% String id = request.getParameter("id"); %>
    <input type="hidden" name="id" value=<%=id %>>
    <% String username = request.getParameter("username"); %>
<input type="hidden" name="username" value=<%=username %>>
<div class="title">
<h2>Update Record</h2></div>
<div class="date">
Date:<input type="date" name="date"><br></div>
<div class="payment">
Payment Method: <select id="payment" name="payment">
  <option value="cash">Cash</option>
  <option value="credit">Credit Card</option>
  <option value="debit">Debit Card</option>
  <option value="upi">UPI</option>
</select><br>
</div>
<div class="amount">
Amount: <input type="text" name="amount"><br>
</div>
<div class="description">
Description:<input type="text" size="15" name="description"><br>
</div>
<div class="submit">
<input type="submit" value="save">

</div>
    </form>
    </body>
    </html>