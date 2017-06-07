<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<jsp:include page="fragments/head_default.jsp" />
		<title>Active Course Page</title>
		<link href="<c:url value='/static/css/bootstrap.css' />"  rel="stylesheet">
		<link href="<c:url value='/static/css/app.css' />" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />
	</head>

	<body>
	<jsp:include page="fragments/header.jsp" />

	<div class="container">
        <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-6">
                <h3>${course.courseName}<br><small>${course.courseDescription} </small></h3>
                <p>Training finished ${trainingsDone} of ${trainingsAmount} </p>

                <div class="col-md-3"></div>
                <div class="col-md-6">
                    <form action="#" method="get">
                    
                    <div class="form-group"><a href="<c:url value="/set/training" />" class="btn form-control input-sm">+ Add training</a></div>



                    <div class="form-group">
                        <a href="<c:url value="course/finish" />" class="btn form-control input-sm">Finish course</a>
                    </div>       


                </form>
                </div>
                <div class="col-md-3"></div>

            </div>
            <div class="col -md-3"></div>
        </div>
    </div>
	

	<jsp:include page="fragments/footer.jsp" />
	</body>
</html>