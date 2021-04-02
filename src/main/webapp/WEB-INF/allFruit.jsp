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
		<h2 class="text-center mx-auto display-1 bg-secondary rounded-bottom m-0">The Fruit Stand Online!!</h2>
		<h2 class="bg-light pb-1 pr-1 m-0 text-right">My Cart |  <span class="badge badge-secondary"><c:out value="${user.shoppingCart.size()}"/></span></h2>
		
		<table class="table table-striped table-dark table-hover">
			<thead>
				<tr>
					<th>Name</th>
					<th>Color</th>
					<th>Size</th>
					<th>Domestic or Import</th>
					<th>Add to Cart</th>
					<th>Action</th>
					<th>Number of likes</th>
					
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${ fruit }" var="myfruit">
				<tr>
					<td> <a href="/fruitstand/${myfruit.name}/${myfruit.id}"> ${ myfruit.name }</a></td>
					<td>${ myfruit.color }</td>
					<td>${ myfruit.size }</td>
					<td>${ myfruit.domesticOrImport }</td>
					<td> <a class="text-success" href="/addtocart/${myfruit.id }">+Cart</a></td>
					<td><c:choose>
						<c:when test="${myfruit.likers.contains(user)}">
							<a class="text-danger" href="/unlike/${myfruit.id}">Unlike</a>
						</c:when>
						<c:otherwise>
						<a class="text-warning" href="/like/${myfruit.id}">Like!</a>
						</c:otherwise>
						</c:choose>
					</td>
					<td><c:out value="${myfruit.likers.size()}"/></td>
					
					
											
				</tr>
			</c:forEach>
			</tbody>
		</table>
		<a href="/fruitstand" class="btn btn-success">Back to Dasboard</a>
		<a href="/fruitstand/mycart" class="btn btn-primary">My Shopping Cart</a>
		<a href="/logout" type="button" class="btn btn-info d-inline float-right">Logout</a>
	
		<h3>Upload form</h3>
		<form class="bg-secondary" method="POST" action="somthing" enctype="multipart/form-data">
		<div class="form-data">Select File:<input type="file" name="image"></div>
		<div class="form-data"><textarea name="description" placeholder="please enter something"/></textarea></div>
		<button class="btn btn-primary">upload pic!</button>
		
		</form>
		
	</div>

</body>
</html>