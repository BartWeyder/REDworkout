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
           <div class="row centered-form">
            <div class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title  text-center" >New Course Form</h3>
                    </div>
                    <div class="panel-body">
						 <form:form method="POST" modelAttribute="course" action="activecourse.jsp">
							
							                            <div class="form-group">
                                   <p>Course Name:</p>
                               </div> 
                            <div class="form-group">
							<form:input type="text" path="courseName" id="courseName" required placeholder="Course name" class="form-control input-sm"/>
						<div class="has-error">
							<form:errors path="courseName" class="help-inline"/>
						</div>                               
                            </div>


                            <div class="form-group">
							<form:input type="textarea" path="courseDescription" id="courseDescription" placeholder="Smth about it" class="form-control input-sm"/>
						<div class="has-error">
							<form:errors path="courseDescription" class="help-inline"/>
						</div>  
                            </div>

                            <div class="form-group">
                                   <p>Training days per week:</p>
                               </div> 

                            <div class="form-group">
							<form:input type="text" path="trainingsPerWeek" id="trainingsPerWeek" class="form-control input-sm"/>
						<div class="has-error">
							<form:errors path="trainingsPerWeek" class="help-inline"/>
						</div>  
                            </div>
<!--
                            <div class="form-group">
                                <select name="tags" id="tags" class="form-control input-sm" multiple >
                                     Load tist of exercises here 
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                    <option value="5">5</option>
                                    <option value="6">6</option>
                                </select>
                            </div>
-->

                            <div class="form-group">
                                   <p>Duration in weeks:</p>
                               </div> 
                               
                             <div class="form-group">
							<form:input type="text" path="duration" id="duration" class="form-control input-sm"/>
						<div class="has-error">
							<form:errors path="duration" class="help-inline"/>
						</div>  
                            </div>                              

<!--
                            <div class="form-group">
                                <select name="tags" id="tags" class="form-control input-sm" multiple >
                                     Load tist of exercises here 
                                    <option value="1">4</option>
                                    <option value="2">6</option>
                                    <option value="3">8</option>
                                    <option value="4">12</option>
                                    <option value="5">16</option>
                                    <option value="6">25</option>
                                </select>
                            </div>
-->
                            

                            <div class="form-group">
							
                                <input type="submit" value="Create!" class="btn btn-danger form-control input-sm">
                            </div>


                   </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>                                
	

	<jsp:include page="fragments/footer.jsp" />
	</body>
</html>