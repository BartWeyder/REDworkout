<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Eugenij Kizim
  Date: 04-Jun-17
  Time: 18:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main</title>
    <jsp:include page="fragments/head_default.jsp" />
    <link href="<c:url value='/static/css/interface.css' />" rel="stylesheet" />
</head>
<body>
    <jsp:include page="fragments/header.jsp" />
    <div class="container">
        <h1>Welcome to REDworkout</h1>
        <h2>Let's start</h2>
        <c:choose>
            <c:when test="${active}">
                <div class="panel panel-primary panel-border">
                    <div class="panel-heading custom-panel-color">
                        Active course
                    </div>
                    <div class="panel-body">
                        <h3>${courseName}</h3>
                        <p>${courseDescription}</p>
                        <p>Trainings done: ${trainingsDone} of ${trainingsAmount}</p>
                        <a class="btn btn-danger" href="<c:url value="/active-course" />">Go to active course</a>
                    </div>
                </div>
            </c:when>
        </c:choose>
        <div class="panel panel-primary panel-border">
            <div class="panel-heading custom-panel-color">
                New courses on marketplace!
            </div>
            <div class="panel-body">
                Every day thousands of trainers adds their courses.
                <a class="btn btn-danger" href="<c:url value="/courses" /> ">Check it</a>
            </div>
        </div>

        <div class="panel panel-primary panel-border">
            <div class="panel-heading custom-panel-color">
                Create your own course
            </div>
            <div class="panel-body">
                It's simple as one-two-tree!
                <a class="btn btn-danger" href="<c:url value="/add/course" /> ">Create</a>
            </div>
        </div>
    </div>
</body>
</html>
