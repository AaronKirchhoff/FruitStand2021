<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    


    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add a new fruit</title>
<link rel="stylesheet" href="css/main.css" />
<link rel="stylesheet" href="/webjars/bootstrap/4.5.2/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</head>
<body>
<div class="col-5 mx-auto" >
		<h4 class="display-4">Add a Fruit</h4>
		<form:form action="/addFruit" method="post" modelAttribute="fruit">
		    <div class="form-group">
		        <form:label path="name">name:</form:label>
		        <form:errors path="name" class="text-danger"/>
		        <form:input class="form-control" path="name"/>
		    </div>
		    <div class="form-group">
		        <form:label path="color">color:</form:label>
		        <form:errors path="color" class="text-danger"/>
		        <form:input class="form-control" path="color"/>
		    </div>
		    <div class="form-group">
		        <form:label path="size">size:</form:label>
		        <form:errors path="size" class="text-danger"/>
		        <form:input class="form-control" path="size"/>
		    </div>
		    <div class="form-group">
		        <form:label path="domesticOrImport">Domestic or Import:</form:label>
		        <form:errors path="domesticOrImport" class="text-danger"/>
		        <form:input class="form-control" path="domesticOrImport"/>
		    </div>
		    <div class="form-group">
		        <form:label path="content">Content:</form:label>
		        <form:errors path="content" class="text-danger"/>
		        <form:textarea rows="4" class="form-control" path="content"/>
		    </div>
		    <input class="btn btn-primary" type="submit" value="Create"/>
		</form:form> 
	</div>


</body>
</html>