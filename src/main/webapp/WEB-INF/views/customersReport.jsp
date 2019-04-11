<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% // Author: M.C.S. %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Customers Report Page</title>
        <c:url value='/customersReport/report' var="reportLink" />
        <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
        <link href="<c:url value='/static/css/styles.css' />" rel="stylesheet"></link>
    </head>
    <body>
        <div class="generic-container">
            <%@include file="authbar03.jsp" %>        
            
            
                <div class="well">                   
                   <a href="${reportLink}/pdf">Customers Report in PDF Format</a>                                       
                </div> 
                <div class="well">
                   <a href="${reportLink}/xls">Customers Report in XLS Format </a>                     
                </div>
                <div class="well">
                   <a href="${reportLink}/csv">Customers Report in CSV Format</a>                    
                </div> 
           
            
        </div>
    
</body>

</html>