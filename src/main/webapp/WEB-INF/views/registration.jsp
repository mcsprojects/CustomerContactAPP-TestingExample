<%@ page language="java"  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% // Author: M.C.S. %>

<html>
<head></head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Customer Registration Form</title>	
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>	
	<link href="<c:url value='/static/css/styles.css' />" rel="stylesheet"></link>    
</head>
<body>
    <div class="bootstrap-iso">
 	<div class="generic-container">
		
		<div class="well lead">Customer Registration Form</div>
		
	 	
			<div class="row">
			<div class="col-md-12 mx-auto">
				  
        
            <form:form method="POST" modelAttribute="customer" class="form-horizontal">
			<form:input type="hidden" path="id" id="id"/>
			
                <div class="form-group row">
                 <div class="col-sm-3">
					   <label for="name">Customer  Name<span class="blue">*</span></label>					
						<form:input type="text" path="name" id="name" class="form-control input-sm" placeholder="Customer Name"/>
					    <div class="has-error">
							<form:errors path="name" class="help-inline"/>
						</div>
					  </div>
                 <div class="col-sm-7">
                        <label for="address">Address<span class="blue">*</span></label>
                        <form:input type="text" class="form-control input-sm" id="address" path="address" placeholder="Address"/>
                        <div class="has-error">
							<form:errors path="address" class="help-inline"/>
						</div>
                 </div>
                 <div class="col-sm-2">
                        <label for="zip">Postal Code<span class="blue">*</span></label>
                        <form:input type="number" class="form-control input-sm" path="zip" id="zip" placeholder="Postal Code"/>
                         <div class="has-error">
							<form:errors path="zip" class="help-inline"/>
						</div>
                 </div>
                </div>
                <div class="form-group row">
                    <div class="col-sm-3">
                        <label for="contactPerson">Contact Person<span class="blue">*</span></label>
                        <form:input type="text" class="form-control input-sm" path="contactPerson" id="contactPerson" placeholder="Contact Person"/>
                        <div class="has-error">
							<form:errors path="contactPerson" class="help-inline"/>
						</div>
                    </div>
                    <div class="col-sm-3">
                        <label for="position">Position<span class="blue">*</span></label>
                        <form:input type="text" class="form-control input-sm" path="position" id="position" placeholder="Position"/>
                        <div class="has-error">
							<form:errors path="position" class="help-inline"/>
						</div>
                    </div>
                    <div class="col-sm-2">
                        <label for="phone">Phone<span class="blue">*</span></label>
                        <form:input type="text" class="form-control input-sm" path="phone" id="phone" placeholder="Phone"/>
                        <div class="has-error">
							<form:errors path="phone" class="help-inline"/>
						</div>
                    </div>
                     <div class="col-sm-4">
                        <label for="email">Email<span class="blue">*</span></label>
                        <form:input type="text" class="form-control input-sm" path="email" id="email" placeholder="Email"/>
                        <div class="has-error">
							<form:errors path="email" class="help-inline"/>
						</div>
                    </div>
               </div>
               <div class="form-group row">
                              
                   <div class="col-sm-2"> 
                       <label for="lastContact">Last Contact<span class="blue">*</span></label>                       
                        <form:input class="form-control input-sm" path="lastContact" id="lastContact" placeholder="dd/mm/yyyy"  />
                        <div class="has-error">
							<form:errors path="lastContact" class="help-inline"/>
						</div>
                    </div>
                    
                    <div class="col-sm-2">
                        <label for="nextContact">Next Contact</label>                                                                                                                 
                        <form:input class="form-control input-sm" path="nextContact" id="nextContact" placeholder="dd/mm/yyyy"  />
                        <div class="has-error">
							<form:errors path="nextContact" class="help-inline"/>
						</div>
                    </div>                    
                                       
                    <div class="col-sm-3">
                        <label for="leadStatus">Lead Status<span class="blue">*</span></label>
                        <form:select path="leadStatus" id="leadStatus" class="form-control" >
                        <form:option value=''>Select</form:option>
	                    <form:option value='Inactive'>Inactive</form:option>
                        <form:option value='Active' >Active</form:option>
                        <form:option value='Warm'>Warm</form:option>
                        <form:option value='Cold'>Cold</form:option>                        
                        </form:select> 
                        <div class="has-error">
							<form:errors path="leadStatus" class="help-inline"/>
					    </div>                        
                    </div>
                    
                    <div class="col-sm-2">
                        <p id="custom"><span class="blue-2">*</span>Denotes Required Field</p>
                        
                    </div>                  
                    
                </div>
               
                <div class="form-group row">
                    <div class="col-sm-12">
                        <label for="notes">Notes</label>
                        <form:textarea class="form-control rounded-0" path="notes" id="notes" rows="3"></form:textarea>                           
                        	
                     </div>
               </div>                
				
		  <div class="form-group row">
            <div class="col-sm-12">
				<div class="form-actions floatRight">
					<c:choose>
						<c:when test="${edit}">
							<input type="submit" value="Update" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/list' />">Cancel</a>
						</c:when>
						<c:otherwise>
							<input type="submit" value="Register" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/list' />">Cancel</a>
						</c:otherwise>
					</c:choose>		 							
	      </div>
	      </div>
	      </div>
	     
		</form:form>
	</div>
	</div>	
 </div>
 </div>  
</body>
</html>
