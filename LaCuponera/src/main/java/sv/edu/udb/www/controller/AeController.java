import sv.edu.udb.www.model.AeModel;
import sv.edu.udb.www.beans.AeBeans;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AeController")
public class AeController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            AeModel aeModel = new AeModel();
            List<AeBeans> listaOfertas = aeModel.listarOfertas();

            if (listaOfertas != null) {
                request.setAttribute("listaOfertas", listaOfertas);
                // Redirigir a la página JSP donde deseas mostrar la lista
                request.getRequestDispatcher("/listaOfertas.jsp").forward(request, response);
            } else {
                // Manejo de errores si no se pueden listar las ofertas
                request.setAttribute("error", "No se pudieron listar las ofertas.");
                request.getRequestDispatcher("/error.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de errores si ocurre una excepción SQL
            request.setAttribute("error", "Error al listar las ofertas.");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}
