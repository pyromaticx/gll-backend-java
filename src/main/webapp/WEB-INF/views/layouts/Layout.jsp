<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="${pageContext.request.contextPath}/static/css/style.css" rel="stylesheet" type="text/css" media="screen" />
<title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>

<body>

<div id="outer">

	<div id="header">
		<tiles:insertAttribute name="header"></tiles:insertAttribute>
	</div>

	<div id="content">
		<div id="leftBar">
			<tiles:insertAttribute name="leftBar"></tiles:insertAttribute>
		</div>
		<div id="middleBar">
			<tiles:insertAttribute name="middleBar"></tiles:insertAttribute>
		</div>
		<div id="rightBar">
			<tiles:insertAttribute name="rightBar"></tiles:insertAttribute>
		</div>
	</div>
	
	<div id="footer">
		<tiles:insertAttribute name="footer"></tiles:insertAttribute>
	</div>

</div>

</body>
</html>