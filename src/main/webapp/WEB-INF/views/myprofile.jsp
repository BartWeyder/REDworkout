<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<jsp:include page="fragments/head_default.jsp" />
		<title>My profile</title>
		<link href="<c:url value='/static/css/bootstrap.css' />"  rel="stylesheet"/>
		<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"/>
		<link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />
	</head>

	<body>
	<jsp:include page="fragments/header.jsp" />
<div class="container">
      <div class="row">
      <div class="col-md-5  toppad  pull-right col-md-offset-3 ">
           <A href="#" >Edit Profile</A> |

        <A href="#" >Logout</A>
       <br>

      </div>
        <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad" >
   
   
          <div class="panel panel-danger panel-info">
            <div class="panel-heading">
              <h3 class="panel-title">Name Surname</h3>
            </div>
            <div class="panel-body">
              <div class="row">
                <div class="col-md-3 col-lg-3 " align="center"> <img src="<c:url value='/static/img/userpic.png' />" class="img-circle img-responsive" alt="User Pic">
																 </div>
                
                <div class=" col-md-9 col-lg-9 "> 
                  <table class="table table-user-information">
                    <tbody>
                      <tr>
                        <td>Email:</td>
                        <td><a href="mailto:info@support.com">info@support.com</a></td>
                      </tr>
                      
                      <tr>
                        <td>Date of Birth:</td>
                        <td>01.01.1988</td>
                      </tr>                      
          
                       
                     <tr>
                        <td>Gender:</td>
                        <td>Male</td>
                      </tr>
                       


                        <td>Phone Number</td>
                        <td>+380998765432
                        </td>
                           

                    </tbody>
                  </table>
                  
                  <a href="#" class="btn  btn-danger">All my courses</a>

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