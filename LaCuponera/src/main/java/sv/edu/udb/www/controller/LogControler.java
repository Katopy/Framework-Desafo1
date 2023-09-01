package sv.edu.udb.www.controller;

import sv.edu.udb.www.model.LoginModel;
import sv.edu.udb.www.beans.LogBeans;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/logControler")
public class LogControler extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String usuarioLogin = request.getParameter("usuarioLogin");
		String contraLogin = request.getParameter("contraLogin");

		String operacion = request.getParameter("operacion");
		if (operacion != null && operacion.equals("salir")) {
			// Invalidar la sesión actual y redirigir al inicio o a otra página
			HttpSession session = request.getSession(false); // Obtener la sesión sin crear una nueva si no existe
			if (session != null) {
				session.invalidate(); // Invalidar la sesión actual
			}
			response.sendRedirect("index.jsp"); // Redirigir a la página de inicio u otra página
		} else {

			// Instanceamos la clase modelo
			LoginModel login = new LoginModel();
			HttpSession session = request.getSession(); // Obtenemos la sesión actual o creamos una nueva
			try {
				LogBeans logBeans = login.login(usuarioLogin);

				if (logBeans.getUsuarioLogin().isEmpty() || logBeans.getContraLogin().isEmpty()) {
					response.sendRedirect("index.jsp?Error");
				} else if (logBeans != null && logBeans.getContraLogin().equals(contraLogin)) {
					if (logBeans.getTipoUsuario().equals("Administrador")) {
						response.sendRedirect("usuarios/administrador/inicioA.jsp");
						session.setAttribute("usuarioLogin", usuarioLogin); 
						
					} else if (logBeans.getTipoUsuario().equals("AdministradorEmpresa")) {
						response.sendRedirect("usuarios/adminEmpresa/inicioAE.jsp");
						session.setAttribute("usuarioLogin", usuarioLogin); 
						
					}else if (logBeans.getTipoUsuario().equals("Cliente")) {
						response.sendRedirect("usuarios/cliente/inicioC.jsp");
						session.setAttribute("usuarioLogin", usuarioLogin);
						
					}else if (logBeans.getTipoUsuario().equals("Dependiente")) {
						response.sendRedirect("usuarios/dependiente/inicioD.jsp");
						session.setAttribute("usuarioLogin", usuarioLogin);
					} 
				} else {
					response.sendRedirect("index.jsp");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
				Logger.getLogger(LogControler.class.getName()).log(Level.SEVERE, null, ex);
				response.sendRedirect("error404.jsp");
			}

		}
	}
}