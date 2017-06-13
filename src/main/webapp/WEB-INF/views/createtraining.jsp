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
        <div class="row centered-form">
            <div class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title  text-center" >New Training Form</h3>
                    </div>
                    <div class="panel-body">
                       	<form:form method="POST" modelAttribute="training" action="activetraining.jsp">
							<form:input type="hidden" path="id" id="id"/>
                        <form role="form" method="post" action="activetraining.jsp">
                           
                           							                            <div class="form-group">
                                   <p>Training Name:</p>
                               </div> 
                            <div class="form-group">
							<form:input type="text" path="trainingName" id="trainingName" required placeholder="Training name" class="form-control input-sm"/>
						<div class="has-error">
							<form:errors path="trainingName" class="help-inline"/>
						</div>                               
                            </div>
                           

                            <div class="form-group">
 							<form:input type="textarea" path="trainingDescription" id="trainingDescription" placeholder="Smth about it" class="form-control input-sm"/>
						<div class="has-error">
							<form:errors path="trainingDescription" class="help-inline"/>
						</div>                                
                      
                            </div>

                            
                            <div class="form-group">
                                   <p>Choose number of excersises:</p>
                               </div> 

                            <div class="form-group">
                                <select name="tags" id="tags" class="form-control input-sm" multiple >
<!--                                     Load tist of exercises here -->
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                    <option value="5">5</option>
                                </select>
                            </div>



                            <div class="form-group">
							  <input type="submit" value="Create!" class="btn btn-danger form-control input-sm">
                            </div>


                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
                                  
	

	<jsp:include page="fragments/footer.jsp" />
	</body>
</html>