<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>
<title>Upload Files</title>
</head>
<body>
<form:form method="post" modelAttribute="file_upload_bean" enctype="multipart/form-data">
	<form:input type="file" path="files" multiple="true" ></form:input>
	<input type="submit" value="Submit">
</form:form>
</body>
</html>