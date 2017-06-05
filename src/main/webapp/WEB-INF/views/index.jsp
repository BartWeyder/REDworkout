<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: bartw
  Date: 28-May-17
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Red Workout</title>
</head>
<body>
    <h1>Hello Page.</h1>
    <c:forEach items="${exercises}" var="exercise">
        <h2>${exercise.exerciseName}</h2>

    </c:forEach>
</body>
</html>
