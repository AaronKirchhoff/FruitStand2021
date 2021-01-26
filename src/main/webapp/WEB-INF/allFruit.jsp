<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    


    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Fruit</title>
<link rel="stylesheet" href="/main.css" />
<link rel="stylesheet" href="/webjars/bootstrap/4.5.2/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</head>
<meta charset="ISO-8859-1">
<title>The Fruit Stand</title>
</head>
<body class="shopall">

	<div class="container">
		<h2 class="text-center mx-auto display-1 bg-secondary rounded-bottom">The Fruit Stand Online!!</h2>
		<table class="table table-striped table-dark table-hover">
			<thead>
				<tr>
					<th>Name</th>
					<th>Color</th>
					<th>Size</th>
					<th>Domestic or Import</th>
					
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${ fruit }" var="myfruit">
				<tr>
					<td> <a href="/fruitstand/${myfruit.name}/${myfruit.id}"> ${ myfruit.name }</a></td>
					<td>${ myfruit.color }</td>
					<td>${ myfruit.size }</td>
					<td>${ myfruit.domesticOrImport }</td>
											
				</tr>
			</c:forEach>
			</tbody>
		</table>
		<a href="/fruitstand" class="btn btn-success">Back to Dasboard</a>
		<a href="/logout" type="button" class="btn btn-info d-inline float-right">Logout</a>
	
		
		
	</div>

</body>
</html>