<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../css/index.css">
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>

<form action="/save" method="POST">
<table border="1">
<tr><th>Register User</th></tr>
<tr><td>UserName  :- <input type="text" name="username"></td></tr>
<tr><td>Password  :- <input type="text" name="password"></td></tr>
<tr><td>Email 	  :- <input type="email" name="email"></td></tr>
<tr><td>Profession:- <input type="text" name="profession"></td></tr>

<tr><td><input type="submit" value="submit"></td></tr>
</table>
</form>

</body>
</html>