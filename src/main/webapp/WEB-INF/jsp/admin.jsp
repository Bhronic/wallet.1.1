<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body{
font-family:"Segoe UI",Arial,sans-serif;
}
.sidenav {
  height: 100%;
  width: 170px;
  position: fixed;
  z-index: 1;
  top: 0;
  left: 0;
  background-color: #111;
  overflow-x: hidden;
  padding-top: 20px;
}

.sidenav a {
  padding: 6px 8px 6px 16px;
  text-decoration: none;
  font-size: 20px;
  color: #818181;
  display: block;
}

.sidenav a.active {
  background-color: #4CAF50;
  color: white;
}

.sidenav a:hover:not(.active) {
  background-color: #555;
  color: white;
}
.main {
margin-top:100px;
  margin-left: 500px; /* Same as the width of the sidenav */
  font-size: 30px; /* Increased text to enable scrolling */
  padding: 0px 10px;
}

@media screen and (max-height: 450px) {
  .sidenav {padding-top: 15px;}
  .sidenav a {font-size: 10px;}
}

h1{
font-weight:normal;

}
h2{
font-weight:normal;
 margin-left:60px;
}
</style>
</head>
<body>


<div class="sidenav">
  <a href="homepage">Home</a>
  </br>
<a href="viewall">View All Records</a>
</br>
<a href="viewuser">View All User</a>
</br>

<a href="viewlogs">View User Logs</a>
</br>
<a href="logout">Logout</a>
</div>
<div class="main">
<h1>Welcome</h1>
<h2>Admin</h2>

</div>
</body>
</html>