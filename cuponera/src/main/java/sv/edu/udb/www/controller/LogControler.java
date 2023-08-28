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
import java.io.IOException;


@WebServlet("/logControler")
public class LogControler extends HttpServlet {
    // Resto de tu código

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String usuarioLogin = request.getParameter("usuarioLogin");
        String contraLogin = request.getParameter("contraLogin");

        // Instanceamos la clase modelo
        LoginModel login = new LoginModel();
        try {
            LogBeans logBeans = login.login(usuarioLogin);
            	//Quiere decir que si va vacio no lo dejará entrar
            	if(logBeans.getUsuarioLogin().isEmpty() || logBeans.getContraLogin().isEmpty()) {
            		  response.sendRedirect("index.jsp?Error");
            	}else {
	                // Si está todo correcto, lo redireccionará
	                if (logBeans != null && logBeans.getContraLogin().equals(contraLogin)) {
	                	if(logBeans.getTipoUsuario().equals("Administrador")) {
	                		 response.sendRedirect("usuarios/administrador/inicioAE.jsp?status=correcto");
	                	}else if(logBeans.getTipoUsuario().equals("AdministradorEmpresa")) {
	                		 response.sendRedirect("usuarios/adminEmpresa/inicioA.jsp?status=correcto");
	                	}

	                    response.sendRedirect("index.jsp?status=correcto");
	                } else {
	                    response.sendRedirect("error404.jsp?Error");
	                }
            	}
        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(LogControler.class.getName()).log(Level.SEVERE, null, ex);
            response.sendRedirect("error404.jsp?Error");
        }
    }
}