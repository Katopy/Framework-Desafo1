<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="javax.servlet.http.HttpSession"%>
<%
// Obtenemos el dato de la sesión
String usuarioLogin = (String) session.getAttribute("usuarioLogin");
if (usuarioLogin == null || usuarioLogin.isEmpty()) {
    response.sendRedirect("../../index.jsp");
}else{
%>

<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Administrador</title>
<link rel="stylesheet" href="../../css/bootstrap1.min.css">
<jsp:include page="../../menu.jsp" />
</head>
<body>
<br><br><br>
	<h1>Este es el administrador de empresa</h1>
	<script src="../../js/jquery-3.2.1.slim.min.js"></script>
	<script src="../../js/bootstrap1.min.js"></script>
</body>
</html>

<%}%>