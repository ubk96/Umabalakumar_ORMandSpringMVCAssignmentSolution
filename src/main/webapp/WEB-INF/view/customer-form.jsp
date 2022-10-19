<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>Save Customer</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

</head>
<body>
	<div class="container">
		<h4>Save Customer</h4>
		<br>
		<form action="/GradedAssignment3/customer/save" method="post">
			<input type="hidden" name="id" value="${customer.id}">
			<div class="form-inline">
				<input type="text" name="firstName" value="${customer.firstName}"
					placeholder="customer firstName" class="form-control mb-4 col-4">
			</div>
			<div class="form-inline">
				<input type="text" name="lastName" value="${customer.lastName}"
					placeholder="customer LastName" class="form-control mb-4 col-4">
			</div>
			<div class="form-inline">
				<input type="text" name="email" value="${customer.email}"
					placeholder="email" class="form-control mb-4 col-4">
			</div>
			<br>
			<button type="submit" class="btn btn-info col-2">Save</button>
		</form>
		<br> <a href="/GradedAssignment3/customer/list">Back to List</a>

	</div>
</body>
</html>