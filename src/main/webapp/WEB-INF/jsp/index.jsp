<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../css/index.css" />
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<form action="validate" method="post">
<input type="hidden" name="page" value="1">
<div class="title">

User Login

</div>
</br></br>
<div class="username">
Username</br></br>

<input type="name"  name="username"></br></br>

 </div></br>

<div class="password"> 

Password
</br></br>

<input type="password" name="password"></br></br>

<input type="submit" value="login" name="login">

<a href="registration">SignUp</a>
</div>




</form>
</body>
</html>