<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% // Author: M.C.S. %>
<!DOCTYPE html>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Customer Contact Management</title>	
   <link href="<c:url value='static/css/bootstrap.css' />" rel="stylesheet"></link>	
   <link href="<c:url value='static/css/home.css' />" rel="stylesheet"></link>			
   <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css"></link>
   <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css" rel='stylesheet' type='text/css'></link>	    
   <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
   
      
</head>

<body>
     
   <div id="mainWrapper">
    <div class="page-container">
    <div class="page-card">	 
      <div class="title-app">
		  <h1>CustomerContact<span>Management</span></h1>
		  <h2>Spring 4 + Hibernate 4 +  MySQL + JasperReports + Maven Integration Example</h2> 
		  <h2 id="custom-h2">Mockito with TestNG Example</h2>                   
      </div>            
	     <img src="<c:url value='static/images/photo01.png'/>"/> 
	    
	   <div class="login-form">																				
		<div class="form-actions">								
			<a href="<c:url value='/list' />" class="btn btn-block btn-primary btn-default">GET START</a>
	   </div>     
	   </div>  	          
      </div>
     </div>          
   </div>
</body>
</html>
