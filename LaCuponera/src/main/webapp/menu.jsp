<%@ page import="javax.servlet.http.HttpSession"%>
<%
// Obtenemos el dato de la sesión
String usuarioLogin = (String) session.getAttribute("usuarioLogin");
if (usuarioLogin == null || usuarioLogin.isEmpty()) {
    response.sendRedirect("index.jsp");
} else {
%>


<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top"
	role="navigation">
	<div class="container">
		<a class="navbar-brand" href="#">La Cuponera</a>
		<button class="navbar-toggler border-0" type="button" data-toggle="collapse" data-target="#exCollapsingNavbar">&#9776;</button>
		<div class="collapse navbar-collapse" id="exCollapsingNavbar">
			<ul class="nav navbar-nav flex-row justify-content-between ml-auto">
				<li class="dropdown order-1">
					<button type="button" id="dropdownMenu1" data-toggle="dropdown"
						class="btn btn-outline-secondary dropdown-toggle">
						<i class="fa fa-user"></i>
						<%=usuarioLogin%>
					
					</button>
					<ul class="dropdown-menu dropdown-menu-right mt-2">
						<li> <a class="dropdown-item" href="../../logout.jsp?operacion=salir"> <i class="fa fa-sign-out"></i> Logout</a></li>
					</ul>
				</li>
			</ul>
		</div>
	</div>
</nav>
	<% } %>

