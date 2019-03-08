<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User manager</title>
<link rel="stylesheet" media="screen" type="text/css" title="style" href="././register.css"/>
</head>
<body>

	<c:import url="/WEB-INF/menu/menu.jsp" />
	<c:import url="/WEB-INF/user/form.jsp" />	
    <c:if test="${ errorStatus == false }">
		<c:import url="/WEB-INF/user/card.jsp" />
	</c:if>
	
</body>
</html>