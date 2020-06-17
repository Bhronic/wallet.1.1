<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../css/index.css">
<meta charset="ISO-8859-1">
<title>Reset Password</title>
</head>
<body>
<table>
<form action="resetpassword" method="GET">
<tr><th>Reset Password </th></tr>
<tr><td>Username</br>
<input type="text" name="username">
</td></tr>
<tr><td>Security Question:- <select id="question" name="question">
<option> </option>
<option>What primary school did you attend?</option>
<option>In what town or city was your first full time job?</option>

</select></td></tr>
<tr><td>Answer:- <input type="text"  name="answer">
</td></tr>
<tr><td><input type="submit" value="Check">
</td></tr>
</form>
</table>
</body>
</html>