<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>New Training Form</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>

    </head>
    <body>

    <div class="container">
        <div class="row centered-form">
            <div class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title  text-center" >New Training Form</h3>
                    </div>
                    <div class="panel-body">
                        <form role="form" method="post" action="#">
                            <div class="form-group">
                                <input type="text" name="training_name" id="training_name" class="form-control input-sm" required placeholder="Training name">
                            </div>


                            <div class="form-group">
                                <textarea name="about_exercise"  id="about_exercise" class="form-control input-sm" placeholder="Smth about it"></textarea>
                            </div>

                            <div class="form-group">
                                   <p>Select exercises or create new:</p>
                               </div>   

                            <div class="form-group"><a href="#"><input type="button" value="+ New exercise" class="btn form-control input-sm"></a></div>

                            <div class="form-group">
                                   <p>Choose excersises:</p>
                               </div> 

                            <div class="form-group">
                                <select name="tags" id="tags" class="form-control input-sm" multiple >
                                    <!-- Load tist of exercises here -->
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                    <option value="5">5</option>
                                </select>
                            </div>



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