<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title></title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="css/style.css" rel="stylesheet">
         <link href="css/login.css" rel="stylesheet">
         <link href="<c:url value='/css/login.css'/>" type="text/css"
	         rel="stylesheet" />
	<link href="<c:url value='/css/bootstrap.min.css'/>" type="text/css"
	rel="stylesheet" />
	<link href="<c:url value='/css/bootstrap-theme.min.css.map'/>" type="text/css"
	rel="stylesheet" />
    </head>
    <body>
<!--
    you can substitue the span of reauth email for a input with the email and
    include the remember me checkbox
    -->
    		<h2 align="center">${requestScope.mesg}</h2>
    
    <div class="container">
        <div class="card card-container">
            <!-- <img class="profile-img-card" src="//lh3.googleusercontent.com/-6V8xOA6M7BA/AAAAAAAAAAI/AAAAAAAAAAA/rzlHcD0KYwo/photo.jpg?sz=120" alt="" /> -->
            <img id="profile-img" class="profile-img-card" src="//ssl.gstatic.com/accounts/ui/avatar_2x.png" />
            <p id="profile-name" class="profile-name-card"></p>
            <form modalAttribute="student" method="post" class="form-signin">
                <span id="reauth-email" class="reauth-email"></span>
                <input type="email" name="email" path="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
                <input type="password" name="password" path="password" id="inputPassword" class="form-control" placeholder="Password" required>
                <div id="remember" class="checkbox">
                    <label>
                        <input type="checkbox" value="remember-me"> Remember me
                    </label>
                </div>
                <input class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Sign in</input>
            </form><!-- /form -->
            <a href="register" class="forgot-password">
                click here register?
            </a>
        </div><!-- /card-container -->
    </div><!-- /container -->
    </body>
</html>