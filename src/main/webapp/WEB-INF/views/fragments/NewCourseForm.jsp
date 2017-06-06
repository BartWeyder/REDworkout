<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>New Course Form</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
    </head>
    <body>

    <div class="container">
        <div class="row centered-form">
            <div class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title  text-center" >New Cource Form</h3>
                    </div>
                    <div class="panel-body">
                        <form role="form" method="post" action="#">
                            <div class="form-group">
                                <input type="text" name="course_name" id="course_name" class="form-control input-sm" required placeholder="Course name">
                            </div>


                            <div class="form-group">
                                <textarea name="about_exercise"  id="about_exercise" class="form-control input-sm" placeholder="Smth about it"></textarea>
                            </div>

                            <div class="form-group">
                                   <p>Training days per week:</p>
                               </div> 

                            <div class="form-group">
                                <select name="tags" id="tags" class="form-control input-sm" multiple >
                                    <!-- Load tist of exercises here -->
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                    <option value="5">5</option>
                                    <option value="6">6</option>
                                </select>
                            </div>

                            <div class="form-group">
                                   <p>Duration in weeks:</p>
                               </div> 

                            <div class="form-group">
                                <select name="tags" id="tags" class="form-control input-sm" multiple >
                                    <!-- Load tist of exercises here -->
                                    <option value="1">4</option>
                                    <option value="2">6</option>
                                    <option value="3">8</option>
                                    <option value="4">12</option>
                                    <option value="5">16</option>
                                    <option value="6">25</option>
                                </select>
                            </div>
                            

                            <div class="form-group"><a href="#"><input type="button" value="+ Add training" class="btn form-control input-sm"></a></div>



                            <div class="form-group">
                                <input type="submit" value="Create!" class="btn form-control input-sm">
                            </div>


                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </body>
</html>