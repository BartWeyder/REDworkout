<!--
  Created by IntelliJ IDEA.
  User: achepta
  Date: 04.06.2017
  Time: 18:07
  To change this template use File | Settings | File Templates.
-->


<html lang="en">
<head>
    <title>RegPage</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <style>
        <%@ include file="/static/css/app.css" %>
    </style>

</head>

<body>
<div class="container">
    <div class="row centered-form">
        <div class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title text-center" >Sign up faster! </h3>
                </div>
                <div class="panel-body">
                    <form role="form" method="post" action="#">
                        <div class="row">
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <div class="form-group">
                                    <input type="text" name="first_name" id="first_name" class="form-control input-sm" required placeholder="First Name">
                                </div>
                            </div>
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <div class="form-group">
                                    <input type="text" name="last_name" id="last_name" class="form-control input-sm" required placeholder="Last Name">
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <input type="email" name="email" id="email" class="form-control input-sm" required placeholder="Email Address">
                        </div>

                        <div class="row">
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <div class="form-group">
                                    <input type="password" name="password" id="password" class="form-control input-sm" required placeholder="Password">
                                </div>
                            </div>
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <div class="form-group">
                                    <input type="password" name="password_confirmation" id="password_confirmation" required class="form-control input-sm" placeholder="Confirm Password">
                                </div>
                            </div>
                        </div>


                        <div class="form-group">
                            <input type="submit" value="Register" class="btn form-control input-sm">
                        </div>


                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="container">
    <div class="row">
        <div class="col-md-4"></div> 
        <div class="col-md-4" align=center> 
            <h3>WHY DO YOU NEED IT</h3>
        </div>
        <div class="col-md-4"></div>
    </div>
    <div class="rov">
        <div class="col-md-3"></div>
        <div class="col-md-6 text-center">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reprehenderit sunt assumenda aut odio numquam soluta voluptate, maiores dolor, ipsa laboriosam consectetur repellendus praesentium at dolores ipsum nam asperiores libero rem!</div>
        <div class="col-md-3"></div>
    </div>
</div>

</body>
</html>
