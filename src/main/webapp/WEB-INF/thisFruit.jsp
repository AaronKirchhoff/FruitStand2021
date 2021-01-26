<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    


    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>This Fruit</title>
<link rel="stylesheet" href="main.css" />
<link rel="stylesheet" href="/webjars/bootstrap/4.5.2/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</head>
<meta charset="ISO-8859-1">
<title>This Fruit</title>
</head>
<body>
	<div class="container">
		<div class="text-center mx-auto col bg-light">
			<h2 class="display-2"> ${ myFruit.name }</h2>
			<p> <span class="font-weight-bold">Fruit color:</span> ${myFruit.color}</p>
			<p> <span class="font-weight-bold">Fruit size:</span> ${myFruit.size}</p>
			<p> <span class="font-weight-bold">Domestic or Import:</span> ${myFruit.domesticOrImport}</p>
			<p> <span class="font-weight-bold">Content:</span> ${myFruit.content}</p>
			
			<a href="/fruitstand" class="btn btn-info">Back to Dashboard</a>
			<a href="/fruitstand/${ myFruit.id }/edit" class="btn btn-secondary">Edit Fruit</a>
			<a href="/delete/${myFruit.id}" class="btn btn-danger">Delete</a>
				
		</div>
	</div>
	
	
	


</body>
</html>