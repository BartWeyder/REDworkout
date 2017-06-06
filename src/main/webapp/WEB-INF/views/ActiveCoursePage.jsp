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
            <div class="col-md-3"></div>
            <div class="col-md-6">
                <h3>Course name<br><small>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis quasi praesentium fuga asperiores excepturi non ut molestiae, consequuntur doloribus iste? Totam fugiat cum sed, esse molestias pariatur ex, ut accusantium. </small></h3>
                <p>Training finished/all:  25/50 </p>

                <div class="col-md-3"></div>
                <div class="col-md-6">
                    <form action="#" method="get">
                    
                    <div class="form-group"><a href="#"><input type="button" value="+ Add training" class="btn form-control input-sm"></a></div>



                    <div class="form-group">
                        <input type="submit" value="Finish course" class="btn form-control input-sm">
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