import sv.edu.udb.www.model.OfertasModel;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "OfertasModel", urlPatterns = {"/ofertas"})
public class OfertaController extends HttpServlet {
	ArrayList<String> listaErrores = new ArrayList<>();
        OfertasModel oferta = new OfertasModel();
    
        protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        	((ServletResponse) response).setContentType("text/html;charset=UTF-8");
        	if (request.getParameter("op") ==null) {
        		listar(request, response);
        		return;
        	}
        	
        	String operacion = request.getParameter("op");
        	
        	switch(operacion) {
        	case "listar":
        		listar(request, response);
        		break;
        		case "nuevo":
        		nuevo(request, response);
        		break;
        		case "insertar":
        		insertar(request, response);
        		break;
        		case "obtener":
        		obtener(request, response);
        		break;
        		case "modificar":
        		modificar(request, response);
        		break;
        		case "eliminar":
        		eliminar(request, response);
        		break;
        		case "detalles":
        		detalles(request, response);
        		break;
        		default:
        		request.getRequestDispatcher("/error404.jsp").forward(request, response);
        		break;
        	}
        }

}
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	processRequest(request, response);
}

}


