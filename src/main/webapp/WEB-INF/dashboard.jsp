<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    


    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fruit Dashboard</title>
<link rel="stylesheet" href="main.css" />
<link rel="stylesheet" href="/webjars/bootstrap/4.5.2/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</head>
<meta charset="ISO-8859-1">
<title>Fruit Dashboard</title>
</head>
<body class="dashboard">
	<h2 class=" jumbotron mx-auto border border-success mt-4 display-3 text-center" style="width: 1200px" >Welcome to the Fruit Stand, ${ user.firstName }</h2>
	<div class="container">
		
		
		<a href="/fruitstand/addnew" class="btn btn-success btn-lg">Add a new fruit</a>
		<a href="/fruitstand/shopall" class="btn btn-warning btn-lg d-inline float-right">search all fruit</a>
		
		
		
		
	</div>
		
		
		
		

</body>
</html>