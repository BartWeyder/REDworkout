<!--
  Created by IntelliJ IDEA.
  User: achepta
  Date: 04.06.2017
  Time: 16:27
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
        body{
            background-color: rgb(255,255,255);
        }
        .centered-form{
            margin-top: 60px;
        }

        .centered-form .panel{
            background: rgba(255, 255, 255, 0.8);
        }


        .form-control {
            border-radius:0;
        }
        .form-control:focus {
            border-color: #cc181e;
            outline: 0;
            -webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.075),0 0 8px rgba(102,175,233,.6);
            box-shadow: inset 0 0 0 rgba(0,0,0,1),0 0 0 rgba(0,0,0,1);
        }

        .btn  {
            color:rgb(255,255,255);
            border-radius:0;
            border-color: #cc181e;
            background:rgb(204,24,30);
        }
        .btn:active {
            color:rgb(255,255,255);
            background:rgb(204,24,30)}

        .btn:hover {
            color:rgb(255,255,255);
            background:rgb(204,24,30)}



    </style>
</head>
<body>
    
<div class="container">
    <div class="row centered-form">
        <div class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title  text-center" >Sign in!</h3>
                </div>
                <div class="panel-body">
                    <form role="form" method="post" action="#">
                        <div class="form-group">
                            <input type="email" name="email" id="email" class="form-control input-sm" required placeholder="Email Address">
                        </div>

                        
                        <div class="form-group">
                            <input type="password" name="password" id="password" class="form-control input-sm" required placeholder="Password">
                        </div>
                        


                        <div class="form-group">
                            <input type="submit" value="Go" class="btn form-control input-sm">
                        </div>


                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
