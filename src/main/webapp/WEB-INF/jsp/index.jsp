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
${registration_message}
<table border="1">
<form action="validate" method="post">
<tr><th>User Login</th></tr>
</br></br>

<tr><td>
Username</br></br>

<input type="name"  name="username"></br></br>
</td>
 </tr></br>

<tr>
<td>

Password
</br></br>

<input type="password" name="password"></br></br>
</td>
</tr>

<tr><td>
<input type="submit" value="login" name="login">

<a href="registration">SignUp</a>

</td></tr>
</form>
</table>


</body>
</html>