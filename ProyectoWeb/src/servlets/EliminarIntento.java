package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Intento;
import bussines.IntentoBs;

/**
 * Servlet implementation class EliminarIntento
 */
@WebServlet("/EliminarIntento")
public class EliminarIntento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarIntento() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		RequestDispatcher rd;
		HttpSession misesion = request.getSession();
		int codigo = 0;
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		String institucion= (String) request.getParameter("intento.institucion");
		if(institucion==null || institucion.isEmpty()) {
			rd= request.getRequestDispatcher("EliminarIntento.jsp");
			codigo=-1;
			misesion.setAttribute("codigo", codigo);
			rd.forward(request, response);
			System.err.println("introduca una institucion" + codigo);
		}else {
			Intento intento= new Intento();
			intento.setInstitucion(institucion);
			IntentoBs intentobs = new IntentoBs();
			int resultado= intentobs.eliminarIntento(intento);
			if (resultado ==1) {
				System.out.println("--->Dentro del if" + resultado);
				misesion.setAttribute("Respuesta",resultado);
				rd = request.getRequestDispatcher("Exito.jsp");
				rd.forward(request, response);
			}else {
				rd = request.getRequestDispatcher("Error.jsp");
				rd.forward(request, response);
			}
		}
	}
}
