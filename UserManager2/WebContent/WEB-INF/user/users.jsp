<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Users</title>
<link rel="stylesheet" media="screen" type="text/css" title="style" href="././register.css"/>
</head>
<body>

	<c:import url="/WEB-INF/menu/menu.jsp" />     <%-- Importation du menu.jsp  --%>
	<br/>
	<table id="tbl_user">						
		<tr id="thead">								<%-- champs des colonnes --%>
			<th>Email</th>
			<th>Nom </th>
			<th> delete </th>
		</tr>

		<c:forEach items="${userList}" var="users">
			<tr>
				<td class="key">${users.key}</td>
				<td class="id">${users.value.getId()}</td>
							
			</tr>
		</c:forEach>

	</table>

</body>
</html>