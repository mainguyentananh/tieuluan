<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
		
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/bootstrap/css/bootstrap.min.css"/>" />
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style-3.css"/>" />
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/jquery-ui.css"/>" />
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/ft/css/all.css"/>" />
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/ft/css/fontawesome.css"/>" />
	
	<link rel="icon" href='<c:url value="/resources/images/logo.jpg"/>'/>
	<title>Trang Chủ</title>
	
</head>
<body>
		
		<tiles:insertAttribute name="dialog" />
		<tiles:insertAttribute name="menu" />
		<tiles:insertAttribute name="header" />
		<tiles:insertAttribute name="content" />
		<tiles:insertAttribute name="footer" />
		
		
		<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.5.1.js" />"></script>
        <script type="text/javascript" src="<c:url value="/resources/bootstrap/js/bootstrap.min.js" />"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/sunshop.js" />"></script>
    
        
</body>
</html>