<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<meta name="language" content="English" />
		
		<title>Login</title>
		<link href="${pageContext.request.contextPath}/static/css/normalize.css" rel="stylesheet" type="text/css" media="screen" />
		<link href="${pageContext.request.contextPath}/static/css/global.css" rel="stylesheet" type="text/css" media="screen" />
	</head>

	<body>
	
<section id="content" class="cf">
	<!-- ajax loader -->
	<div id="loader"></div>
	<h2 class="head">Login</h2>
	<section id="login" class="cf">
		<nav>
			<ul>
				<li><a href="<c:url value="/login-twitter" />" class="twitter">Login with Twitter</a></li>
				<li><a href="<c:url value="/login-facebook" />" class="facebook">Login with Facebook</a></li>
				<li><a href="<c:url value="/login-linkedin" />" class="linkedin">Login with LinkedIn</a></li>
			</ul>
		</nav>
	</section>
</section>
</body>
</html>
