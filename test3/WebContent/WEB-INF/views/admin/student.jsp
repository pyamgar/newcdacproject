<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Startmin - Bootstrap Admin Theme</title>

    <!-- Bootstrap Core CSS -->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="assets/css/metisMenu.min.css" rel="stylesheet">

    <!-- Timeline CSS -->
    <link href="assets/css/timeline.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="assets/css/startmin.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="assets/css/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="assets/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
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
</head>
<body>

<div id="wrapper">

    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Startmin</a>
        </div>

        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>

        <!-- Top Navigation: Left Menu -->
        <ul class="nav navbar-nav navbar-left navbar-top-links">
            <li><a href="loginrelated/HomePage"><i class="fa fa-home fa-fw"></i> Website</a></li>
        </ul>

        <!-- Top Navigation: Right Menu -->
        <ul class="nav navbar-right navbar-top-links">
            <li class="dropdown navbar-inverse">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                    <i class="fa fa-bell fa-fw"></i> <b class="caret"></b>
                </a>
                <ul class="dropdown-menu dropdown-alerts">
                    <li>
                        <a href="#">
                            <div>
                                <i class="fa fa-comment fa-fw"></i> New Comment
                                <span class="pull-right text-muted small">4 minutes ago</span>
                            </div>
                        </a>
                    </li>
                    <li class="divider"></li>
                    <li>
                        <a class="text-center" href="#">
                            <strong>See All Alerts</strong>
                            <i class="fa fa-angle-right"></i>
                        </a>
                    </li>
                </ul>
            </li>
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                    <i class="fa fa-user fa-fw"></i> Admin <b class="caret"></b>
                </a>
                <ul class="dropdown-menu dropdown-user">
                    <li><a href="#"><i class="fa fa-user fa-fw"></i> Admin Profile</a>
                    </li>
                    <li class="divider"></li>
                    <li><a href="loginrelated/HomePage"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                    </li>
                </ul>
            </li>
        </ul>

        <!-- Sidebar -->
        <div class="navbar-default sidebar" role="navigation">
            <div class="sidebar-nav navbar-collapse">

                <ul class="nav" id="side-menu">
                    <li class="sidebar-search">
                        <div class="input-group custom-search-form">
                            <input type="text" class="form-control" placeholder="Search...">
                                <span class="input-group-btn">
                                    <button class="btn btn-primary" type="button">
                                        <i class="fa fa-search"></i>
                                    </button>
                                </span>
                        </div>
                    </li>
                    <li>
                        <a href="#" class="active"><i class="fa fa-dashboard fa-fw"></i> Dashboard</a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-sitemap fa-fw"></i> Subjects<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="showSub">Show Subjects</a>
                            </li>

                        </ul>
                    </li>
                    
                  
                     <li>
                        <a href="#"><i class="fa fa-sitemap fa-fw"></i> Student<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="#">Show Student</a>
                            </li>
                        </ul>
                    </li>
                </ul>

            </div>
        </div>
    </nav>

    <!-- Page Content -->
    <div id="page-wrapper">
        <div class="container-fluid">

            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Welcome Admin</h1>
                                    <div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
                            <h3 id="myModalLabel">Delete</h3>
                        </div>
                        <div class="modal-body">
                            <p></p>
                        </div>
                        <div class="modal-footer">
                            <button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
                            <button data-dismiss="modal" class="btn red" id="btnYes">Confirm</button>
                        </div>
   </div>
   <table class="table table-striped table-hover table-users">
    			<thead>
    				<tr>
    					
    					<th class="hidden-phone">Id</th>
    					<th>Name</th>
    					<th>Email</th>
    					<th class="hidden-phone">Password</th>
    					<th class="hidden-phone">Mobile No</th>
    					<th class="hidden-phone">Marks</th>
    					<th></th>
    					<th></th>
    				</tr>
    			</thead>

    			<tbody>
    			
	       <c:forEach var="title" items="${students}" begin="6" end="15" varStatus="loop">
		   
		
	    				<tr>
                        
    					<td class="hidden-phone">${loop.count}</td>
    					<td>${title.name}</td>
    					<td>${title.email}</td>
    					<td class="hidden-phone">dsd@${title.password}</td>
    					<td class="hidden-phone">${title.mobileNo}</td>
    					<td><a class="btn mini blue-stripe" href="#">Edit</a></td>

                        <td><a href="#" class="confirm-delete btn mini red-stripe" role="button" data-title="johnny" data-id="1">Delete</a></td>
                    </tr>
                    </c:forEach>
        		</tbody>

    		</table>
                    
                    
                </div>
            </div>

            <!-- ... Your content goes here ... -->

        </div>
    </div>

</div>

<!-- jQuery -->
<script src="assets/js/jquery.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="assets/js/bootstrap.min.js"></script>

<!-- Metis Menu Plugin JavaScript -->
<script src="assets/js/metisMenu.min.js"></script>

<!-- Custom Theme JavaScript -->
<script src="assets/js/startmin.js"></script>

</body>
</html>