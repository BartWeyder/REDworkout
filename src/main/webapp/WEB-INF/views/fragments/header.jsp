<%--
  Created by IntelliJ IDEA.
  User: Настя
  Date: 05.06.2017
  Time: 12:50
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
      <header class="navbar navbar-inverse navbar-static-top red">
          <div class="container">
              <div><a href="#" class="navbar-brand"><img src="<c:url value='/static/img/logo.png' />" width="70" height="30" alt="Logo"></a></div>
                <sec:authorize access="hasRole('ADMIN') or hasRole('DBA') or hasRole('USER')">
                  <div class="right">
                      <ul class="nav navbar-nav">
                          <li class="dropdown">
                             <a class="dropdown-toggle" data-toggle="dropdown" href="#" > ${loggedinuser} <b class="caret"></b></a>
                              <ul class="dropdown-menu">
                                  <li><a href="<c:url value="/myprofile" /> ">My profile</a></li>
                                  <li><a href="#">Active course</a></li>
                                  <li><a href="#">All courses</a></li>
                              </ul>
                          </li>

                      </ul>
                  </div>
                </sec:authorize>
              
          
          </div>
      </header>   