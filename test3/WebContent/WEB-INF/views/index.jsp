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
    <link rel="stylesheet" href="css/index.css">
   

        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.js"></script>

 <!--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> !-->

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
      
      <a class="navbar-brand" href="">Aptitude Tutorial</a>
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
       </c:if>
       
          
            </ul>
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
      <h1>Welcome to Aptitude Tutorial.com!!! </h1>
      <p>Here, you can read aptitude questions and answers for your interview and entrance exams preparation.</p>
      
      <h3>Online Test | Placement Papers </h3>
      <br/>
      

      <h4>Infosys</h4>
      <p>Try free online Infosys test, placement papers, mock, aptitude and practice tests created by Aptitude Tutoria. Latest placement papers of Infosys cover all major areas of test, aptitude and english comprehension. You can also attempt placement paper of other companies like TCS, Wipro, Campgemini etc.<br/><br/></p>
      <h4>TCS</h4>
      <p>Try free online TCS test, placement papers, mock, aptitude and practice tests created by Aptitude Tutorial. Latest placement papers of Infosys cover all major areas of test, aptitude and english comprehension. You can also attempt placement paper of other companies like TCS, Wipro, Campgemini etc.<br/><br/></p>

      <h4>Capegimini</h4>
      <p>Try free online Capegimini test, placement papers, mock, aptitude and practice tests created by Aptitude Tutorial. Latest placement papers of Infosys cover all major areas of test, aptitude and english comprehension. You can also attempt placement paper of other companies like TCS, Wipro, Campgemini etc.<br/><br/> </p>

	
	    <h4>Infosys</h4>
      <p>Try free online Infosys test, placement papers, mock, aptitude and practice tests created by Aptitude Tutoria. Latest placement papers of Infosys cover all major areas of test, aptitude and english comprehension. You can also attempt placement paper of other companies like TCS, Wipro, Campgemini etc.<br/><br/></p>
      <h4>TCS</h4>
      <p>Try free online TCS test, placement papers, mock, aptitude and practice tests created by Aptitude Tutorial. Latest placement papers of Infosys cover all major areas of test, aptitude and english comprehension. You can also attempt placement paper of other companies like TCS, Wipro, Campgemini etc.<br/><br/></p>

      <h4>Capegimini</h4>
      <p>Try free online Capegimini test, placement papers, mock, aptitude and practice tests created by Aptitude Tutorial. Latest placement papers of Infosys cover all major areas of test, aptitude and english comprehension. You can also attempt placement paper of other companies like TCS, Wipro, Campgemini etc.<br/><br/> </p>

	

    </div>
    <div class="col-sm-2 sidenav">
      <div class="well">
        <p>ADS</p>
      </div>
      <div class="well">
        <p>ADS</p>
      </div>
    </div>
  </div>
</div>

<footer class="container-fluid text-center">
  <p>&copy 2017 by Popat Yamgar.</p>
  <p>Contact Us: <em>contact@Aptitutorial.com</em></p>
</footer>

</body>
</html>
