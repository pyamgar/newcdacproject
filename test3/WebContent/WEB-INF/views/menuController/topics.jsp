<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Aptitude Tutorial</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="css/bootstrap.css">
   <link rel="stylesheet" href="css/bootstrap-theme.css">

        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.js"></script>

 <!--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> !-->
  <style> 
    /*Remove the navbar's default margin-bottom and rounded borders */ 
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
      height:60px;
    }
    
    /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
    .row.content {height: 570px}
    
    /* Set gray background color and 100% height */
    .sidenav {
      padding-top: 20px;
      background-color: #f1f1f1;
      height: 100%;
    }
    
    /* Set black background color, white text and some padding */
    footer {
      background-color: #555;
      color: white;
      padding: 15px;
    }

    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
        
      }
      .row.content {height:auto;} 
    }


  </style>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="loginrelated/HomePage">Aptitude Tutorial</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
     <!-- <ul class="nav navbar-nav">
        <li class="active"><a href="#">Home</a></li>
        <li><a href="#">About</a></li>
        <li><a href="#">Projects</a></li>
        <li><a href="#">Contact</a></li>
      </ul>  !-->
      <ul class="nav navbar-nav navbar-right">
<c:if test="${sessionScope.studentSession==null}">
	   <li><a href="loginrelated/logins"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
       
        <li><a href="loginrelated/register"><span class="glyphicon glyphicon-log-in"></span> Register </a></li>
     </c:if>
     <c:if test="${sessionScope.studentSession!=null}">
 	         <li><a href=""><span class="glyphicon glyphicon-log-in"></span> Welcome,${sessionScope.studentSession.name}! </a></li>
 		 
	</c:if>
       <c:if test="${sessionScope.studentSession !=null}">
        <li><a href="loginrelated/logout"><span class="glyphicon glyphicon-log-in"></span> Logout </a></li>
       </c:if>      </ul>
    </div>
  </div>
</nav>
  
<div class="container-fluid text-center">    
  <div class="row content">
    <div class="col-sm-2 sidenav">
         <c:forEach var="title" items="${sub}">
		
			<ul> 
				<a href="topics?subid=${title.subId}">${title.name}</a>
				</br>
			</ul>		
		</c:forEach>
    </div>
    <div class="col-sm-8 text-left"> 
      <h1>Aptitude</h1>
          <div class="col-sm-4">
            <ul class="sub_nav_list">
            
         <c:forEach var="title" items="${topics}">
			<li> 
				<a href="questions?Tid=${title.tid}">${title.name}</a>
				</br>
			</li>		
		</c:forEach>
        </ul>
          </div>
          <div class="col-sm-4">
            <ul class="sub_nav_list ">

		 	  <c:forEach var="title" items="${topics}">
			<li> 
				<a href="questions?Tid=${title.tid}">${title.name}</a>
				</br>
			</li>		
		</c:forEach>

           </ul> 
          </div>
        </div>
          <div class="col-sm-2 sidenav">
      <div class="well">
       <!-- <div class="sidebar">
        <div id="content">
  <div class="panel panel-info">
    <div class="panel-heading">
      <h3 class="panel-title">LIKE US ON FACEBOOK</h3>
    </div>
    <div class="panel-body">
      <iframe src="//www.facebook.com/plugins/likebox.php?href=https%3A%2F%2Fwww.facebook.com%2Fexmadda&amp;height=258&amp;colorscheme=light&amp;show_faces=true&amp;header=false&amp;stream=false&amp;show_border=true&amp;appId=503847759669081" scrolling="no" frameborder="0" style="border:none; overflow:hidden; width:100%; height:100px;"></iframe>
    </div>
  </div>!-->

        <p>ADS</p>
      </div>
      <div class="well">
        <p>ADS</p>
      </div>
    </div>
  
   <!-- <div class="col-sm-2 sidenav"> ....... </div>
!-->

  </div>
</div>

<footer class="container-fluid text-center">
  <p>&copy 2017 by Popat Yamgar.</p>
  <p>Contact Us: <em>contact@Aptitutorial.com</em></p>
</footer>

</body>
</html>
