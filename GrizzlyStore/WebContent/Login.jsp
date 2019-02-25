<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Grizzly Store</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	
	<div align="center" style="margin-top: 100px;">
	<form action="login" method="post" >
	<img src="logo.JPG" alt="image contains logo" />
	<hr align="center" width="280px">
	<br>
	<input id="uname" type="text" placeholder="Username" name="uname"><br><br>
	<input id="pass" type="password" name="pass" placeholder="Password"><br>
	<p><%
		String login_msg=(String)request.getAttribute("errorMessage");  
		if(login_msg!=null)
		out.println("<font color=red size=2px>"+login_msg+"</font>");
	%></p>
	<input id="login" type="submit" value="login"> 
	</form>
	</div>
	
</body>
</html>