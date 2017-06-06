<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<jsp:include page="fragments/head_default.jsp" />
		<title>Login page</title>
		<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
	</head>

	<body>
	<jsp:include page="fragments/header.jsp" />
	
<div class="container">
     <div class="row">
        <div class="container">
        <h2>Available courses</h2>
        <hr>
       </div>  
     </div>
     
     <div class="row" >
         <div  class="col-xs-6 col-sm-4 col-md-3 col-lg-3">
            <div class="thumbnail">
			 <img src="<c:url value='/static/img/thumbnail.png' alt="Course pic"/>"
            <img src="http://placehold.it/400x240/" alt="">
             <div class="caption">
                 <h4>Course name1</h4>
                 <p>Course name1 description</p>
                 <a href="#" class="btn btn-success">Read more</a>
             </div>
            </div>
         </div>
         <div  class="col-xs-6 col-sm-4 col-md-3 col-lg-3">
            <div class="thumbnail">
            <img src="http://placehold.it/400x240/" alt="">
             <div class="caption">
                 <h4>Course name2</h4>
                 <p>Course name2 description</p>
                 <a href="#" class="btn btn-success">Read more</a>
             </div>
            </div>
         </div>
         <div  class="col-xs-6 col-sm-4 col-md-3 col-lg-3">
            <div class="thumbnail">
            <img src="http://placehold.it/400x240/" alt="">
             <div class="caption">
                 <h4>Course name3</h4>
                 <p>Course name3 description</p>
                 <a href="#" class="btn btn-success">Read more</a>
             </div>
            </div>
         </div>                  

     </div> 
 </div>
		
<jsp:include page="fragments/footer.jsp" />
	</body>
</html>