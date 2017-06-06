<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<jsp:include page="fragments/head_default.jsp" />
		<title>Banned user</title>
		<link href="<c:url value='/static/css/bootstrap.css' />"  rel="stylesheet"></link>
		<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
		<link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />
	</head>

	<body>
	<jsp:include page="fragments/header.jsp" />

	<div class="container">
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<table class="table">
					<thread>
						<tr>
							<th>First name</th>
							<th>Last name</th>
							<th>E-mail</th>
							<th></th>
						</tr>
					</thread>
					<tbody>
						<tr>
							<td>Anastasiya</td>
							<td>Bobyr</td>
							<td>a.bobyr@gmail.com</td>
							<td><a href="#" class="btn  btn-danger">Unblock</a></td>
						</tr>
						<tr>
							<td>Eugenij</td>
							<td>Kizim</td>
							<td>e.kizim@gmail.com</td>
							<td><a href="#" class="btn  btn-danger">Unblock</a></td>
						</tr>
						<tr>
							<td>Nikita</td>
							<td>Tyshkevych</td>
							<td>n.tyskkevych</td>
							<td><a href="#" class="btn  btn-danger">Unblock</a></td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="col -md-3"></div>
		</div>
	</div>
	

	<jsp:include page="fragments/footer.jsp" />
	</body>
</html>