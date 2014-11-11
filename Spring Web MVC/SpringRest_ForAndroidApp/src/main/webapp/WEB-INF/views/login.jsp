<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Bootstrap Admin Theme</title>

    <!-- Bootstrap Core CSS -->
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="resources/css/plugins/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="resources/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="resources/font-awesome-4.1.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Please Sign In</h3>
                    </div>
                    <div class="panel-body">
                       <form:form modelAttribute="account" action="/app/">
                            <fieldset>
                                <div class="form-group">
                                   <form:label path="email"  >Email</form:label>
     							   <form:input path="email"  cssClass="form-control" placeholder="E-mail" />
                                </div>
                                <div class="form-group">
                                      <form:label path="password"  >Password </form:label>
     							  	  <form:password path="password" cssClass="form-control" placeholder="Password (greater than 4 character)" />
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input name="remember" type="checkbox" value="Remember Me">Remember Me ?
                                    </label>
                                </div>
                                <!-- Change this to a button or input when using this as a form -->
                                <button type="submit" class="btn btn-primary btn-lg btn-block">Sign in</button>
                             <input type="hidden" name="${_csrf.parameterName}"value="${_csrf.token}" />
                            </fieldset>
                       	</form:form>	
                       	<spring:hasBindErrors name="account">
                   	    		<spring:bind path="account.*">
									<c:forEach items="${status.errorMessages}" var="error">
									  <br>
                   	    	  		  <div class="alert alert-danger alert-dismissable">
                              		  	<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
										<c:out value="${error}"/>
                           			  </div>
									</c:forEach>
								</spring:bind>
						</spring:hasBindErrors>	
						<c:forEach items="${sessionExpired}" var="sessionExpired">  
  							 <br>   
  							 <div class="alert alert-danger alert-dismissable">
                              	<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
								<c:out value="${sessionExpired}"/>
                           	 </div>
						</c:forEach>
                    </div>
                    <button data-toggle="modal" data-target="#myModal" type="button" class="btn btn-link ">Sign Up ?</button>
                </div>
            </div>
        </div>
       
    </div>
 	<!-- Modal -->
             <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                  <div class="modal-dialog">
                        <div class="modal-content">
                              <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            <h4 class="modal-title" id="myModalLabel">Sign Up Form</h4>
                                        </div>
                                <div class="modal-body">
                                       <fieldset>
                                     	    <div class="form-group">
			                                    <input class="form-control" placeholder="Display Name" name="name" type="text" value="">
			                                </div>
			                                <div class="form-group">
			                                    <input class="form-control" placeholder="E-mail" name="email" type="email" autofocus>
			                                </div>
			                                <div class="form-group">
			                                    <input class="form-control" placeholder="Password" name="password" type="password" value="">
			                                </div>
                          			  </fieldset>
                               </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                            <button type="button" class="btn btn-primary">Sign Up</button>
                                        </div>
                                    </div>
                                    <!-- /.modal-content -->
                   </div>
                 <!-- /.modal-dialog -->
            </div>
    <!-- /.modal -->
    <!-- jQuery Version 1.11.0 -->
    <script src="resources/js/jquery-1.11.0.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="resources/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="resources/js/plugins/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="resources/js/sb-admin-2.js"></script>
	 <script>
            $("#email").attr('required', ''); 
            $("#email").prop('type', 'email');
            $("#password").attr('required', ''); 
            $("#password").attr('pattern','.{4,10}'); 
    </script>
</body>

</html>
