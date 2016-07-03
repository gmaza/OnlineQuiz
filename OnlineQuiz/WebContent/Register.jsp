<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Creative - Bootstrap 3 Responsive Admin Template">
    <meta name="author" content="GeeksLabs">
    <meta name="keyword" content="Creative, Dashboard, Admin, Template, Theme, Bootstrap, Responsive, Retina, Minimal">
    <link rel="shortcut icon" href="img/favicon.png">

    <title>Login Page 2 | Creative - Bootstrap 3 Responsive Admin Template</title>

    <!-- Bootstrap CSS -->    
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- bootstrap theme -->
    <link href="css/bootstrap-theme.css" rel="stylesheet">
    <!--external css-->
    <!-- font icon -->
    <link href="css/elegant-icons-style.css" rel="stylesheet" />
    <link href="css/font-awesome.css" rel="stylesheet" />
    <!-- Custom styles -->
    <link href="css/style.css" rel="stylesheet">
    <link href="css/style-responsive.css" rel="stylesheet" />

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 -->
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
</head>

  <body class="login-img3-body">

    <div class="container">

      <form class="login-form" action="SignUp" method="post">        
        <div class="login-wrap">
            <p class="login-img"><i class="icon_lock_alt"></i></p>
            <div class="input-group">
              <span class="input-group-addon"></span>
              <input type="text" name="username" class="form-control" placeholder="Username" autofocus>
            </div>
            <div class="input-group">
                <span class="input-group-addon"></span>
                <input type="password" name="password" class="form-control" placeholder="Password">
            </div>
             <div class="input-group">
                <span class="input-group-addon"></span>
                <input type="password" name="confirmPassword" class="form-control" placeholder="Confirm Password">
            </div>
            <div class="input-group">
              <span class="input-group-addon"></span>
              <input type="text" class="form-control" name="firstname" placeholder="Firstname" autofocus>
            </div>
            <div class="input-group">
              <span class="input-group-addon"></span>
              <input type="text" class="form-control" name="lastname" placeholder="Lastname" autofocus>
            </div>
            <div class="input-group">
              <span class="input-group-addon"></span>
              <input type="number" class="form-control" name="age" placeholder="Age" autofocus>
            </div>
            <div class="input-group">
              <span class="input-group-addon"></span>
              <input type="text" class="form-control" name="mail" placeholder="Mail" autofocus>
            </div>
       
            <button class="btn btn-info btn-lg btn-block" type="submit">Signup</button>
        </div>
      </form>

    </div>


  </body>
</html>
