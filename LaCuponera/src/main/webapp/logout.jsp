<%@ page import="javax.servlet.http.HttpSession" %>
<%
    HttpSession session_actual = request.getSession(true);
    String operacion = request.getParameter("operacion");

    if (operacion.equals("salir")) {
        session_actual.setAttribute("usuarioLogin", null);
        response.sendRedirect("index.jsp");
    } 
%>
