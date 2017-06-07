<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<jsp:include page="fragments/head_default.jsp" />
		<title>Active Course Page</title>
		<link href="<c:url value='/static/css/bootstrap.css' />"  rel="stylesheet"></link>
		<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
		<link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />
	</head>

	<body>
	<jsp:include page="fragments/header.jsp" />

 	<div class="container">
        <div class="row">
            <div>
                <h3>Course name<br><small>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis quasi praesentium fuga asperiores excepturi non ut molestiae, consequuntur doloribus iste? Totam fugiat cum sed, esse molestias pariatur ex, ut accusantium. </small></h3>
                    <div class="form-group"><a href="createtraining.jsp"><input type="button" value="+ Add training" class="btn btn-danger  input-sm"></a></div>
                    <hr>
                 <h4>List of my trainings: </h4>                   
                <hr>
                <p>Training finished/all:  25/50 </p>


                    <form action="main.jsp" method="get">
                    




                    <div class="form-group">
					
                        <input type="submit" value="Finish course" class="btn btn-success input-sm">
                    </div>       


                </form>
</div>
        </div>
    </div>             
	

	<jsp:include page="fragments/footer.jsp" />
	</body>
</html>