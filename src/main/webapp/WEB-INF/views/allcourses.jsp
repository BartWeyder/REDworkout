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
          <a href="#" class="btn btn-danger"> + Add new course</a>           					
      </div>
     
							   
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
             <div class="caption">
                 <h4>Course name1</h4>
                 <p>Course name1 description</p>
                 <button type="button" class="btn btn-success" data-toggle="modal" data-target="#myModal">Read more</button>
                 
                 
                  <!-- Modal -->
                          <div class="modal fade" id="myModal" role="dialog">
                            <div class="modal-dialog">

                              <!-- Modal content-->
                              <div class="modal-content">
                                <div class="modal-header">
                                  <button type="button" class="close" data-dismiss="modal">&times;</button>
                                  <h4 class="modal-title">Course name1</h4>
                                </div>
                                <div class="modal-body">
                                <b>Duration of the course:</b> <span></span> 
                            <br><b> Count of trainings per week:</b> <span></span>
                            <br><b> Price for the whole course: </b> <span></span>
 
                                </div>
                                <div class="modal-footer">
                                  <button type="button" class="btn btn-inverse" data-dismiss="modal">Close</button>
                                </div>
                              </div>

                            </div>
                          </div>
                 
                 
             </div>
            </div>
         </div>
         

     </div> 
 </div>
		
<jsp:include page="fragments/footer.jsp" />
	</body>
</html>