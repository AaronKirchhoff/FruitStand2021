<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    


    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Shopping Cart</title>
<link rel="stylesheet" href="css/main.css" />
<link rel="stylesheet" href="/webjars/bootstrap/4.5.2/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</head>
<meta charset="ISO-8859-1">
<title>Shopping cart</title>
</head>
<body class="container col-3">
<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th>My Cart</th>
					<th>Remove Item</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${ user.shoppingCart }" var="myFruitCart">
				<tr>
					<td>${ myFruitCart.name }</td>	
					<td> <a href="/removefromcart/${myFruitCart.id }">Delete</a></td>					
				</tr>
			</c:forEach>
			</tbody>
		</table>
		
		<a href="/fruitstand" class="btn btn-success">Back to Dasboard</a>
		<a href="/fruitstand/shopall" class="btn btn-warning d-inline float-right">Keep Shopping</a>
		
		
		




</body>
</html>