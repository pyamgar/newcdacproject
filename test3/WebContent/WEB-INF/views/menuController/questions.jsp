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
<%--  <script type="text/javascript" src="<c:url value="/js/custom.js" />"> </script>     
 --%>
 <script type="text/javascript">
 
 function myFunction(cnt) {
	    var x = document.getElementsByClassName('more');
	    for (i = 0; i < x.length; i++) { 
		    if(cnt==i)
			{
		    	 if (x[i].style.display === 'none') {
		 	        x[i].style.display = 'block';
		 	    } else {
		 	        x[i].style.display = 'none';
		 	    }
			}
	    }
	   
	}
 </script>

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
		</c:forEach> </div>
    <div class="col-sm-8 text-left"> 
      <h1 class="page_title">Questions</h1>
          <div class="col-md-12" id="main_content">
                         
      	  <c:forEach var="title" varStatus="theCount" items="${questions}">
            <div id="questions"> 
            
              <div class="qno">${theCount.index+1}</div>
              <div class="desc"><h5 class="question">${title.name}:</h5></div>
              <div class="row">
                <div class="col-sm-6 que_option">
                  <p class="1a"><input type="radio" name="1"/>&nbsp;<span>A.</span> ${title.option1}</p>
                  <p class="1b"><input type="radio" name="1"/>&nbsp;<span>B.</span> ${title.option2}</p>
                </div>
                <div class="col-sm-6 que_option">                                                    
                  <p class="1a"><input type="radio" name="1"/>&nbsp;<span>C.</span> ${title.option3}</p>
                  <p class="1a"><input type="radio" name="1"/>&nbsp;<span>D.</span> ${title.option4}</p>
                </div>
              </div>
              <div class="box-main">
                <a href="javascript:" class="answer_btn" onClick="myFunction(${theCount.index})">Answer</a>
                <div name="div" class="answer_box" id="explain_1" > 
		        <span class="more">

                  <h5>Answer :</h5>${title.answer}<br/>
                  <h5>Explanation :${title.description}</h5><br/>
           </span>
			
                 
                 </div>
              </div>
             </div>
             </c:forEach>
           
              <hr><div class="pag">Jump to page number :</div><div class="paginator"><ul class="pagination"><li class="disabled"><a href="#">&laquo;</a></li><li class="active"><a href="#">1<span class="sr-only">(current)</span></a></li><li><a href="#">2</a></li><li><a href="#">3</a></li><li><a href="#">4</a></li><li><a href="#">5</a></li><li><a href="#">&raquo;</a></li></ul></div>          </div>
         
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
