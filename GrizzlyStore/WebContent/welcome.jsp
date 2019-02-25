<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to Grizzly Store</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<%
	// to remove the cache data
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");	// works on HTTP 1.1
	response.setHeader("Pragma","no-cache"); // for HTTP 1.0
	response.setHeader("Expires","0"); // for proxy
	if(session.getAttribute("username")==null){
		response.sendRedirect("Login.jsp");
	}
	%>
	
	<div  class="header">
    	<div class="row">
    		<form action="logout">
			<img alt="image contains logo" src="logo2.JPG" height="60px" width="200px">
			<input id="search" type="text" placeholder="Search">
			<div class="right">
			<label id="welcome">Welcome, ${username}</label>
			<input id="logout" type="submit" value="Logout">
			</div>
			</form>
		</div>
	</div>
	
	<h2>File upload to database</h2>
	
	<form method="post" action="productdetailsupload">
            <label for="firstName">Product Id:</label>
            <input type="number" name="productId" placeholder="Enter Product ID" required/><br><br>
            <label for="lastName">Product name: </label>
            <input type="text" name="productName" placeholder="Enter Product Name" required/><br><br>
            <label for="lastName">Product Category: </label>
            <input type="text" name="productCategory" placeholder="Enter Product Category" required/><br><br>
            <label for="lastName">Product price: </label>
            <input type="number" name="productPrice" placeholder="Enter Product Price" required/><br><br>
            <label for="lastName">Product description: </label>
            <input type="text" name="productDesc" placeholder="Enter Product Description" required/><br><br>
            
            <input type="submit" value="Add">
        </form>
	
</body>
</html>