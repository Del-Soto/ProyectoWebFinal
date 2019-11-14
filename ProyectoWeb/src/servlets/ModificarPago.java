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

import beans.Pago;
import bussines.PagoBs;

/**
 * Servlet implementation class ModificarPago
 */
@WebServlet("/ModificarPago")
public class ModificarPago extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarPago() {
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
		String clavepago= (String) request.getParameter("pago.clavepago");
		if (clavepago==null || clavepago.isEmpty()) {
			rd= request.getRequestDispatcher("ModificarPago.jsp");
			codigo=-1;
			misesion.setAttribute("codigo", codigo);
			rd.forward(request, response);
			System.err.println("introduca una clave de pago" + codigo);
		}
		else {
			Pago pago1 = new Pago();
			pago1.setClavePago(clavepago);
			PagoBs pagobs = new PagoBs();
			String resultado = pagobs.buscarPago(pago1);
			if (resultado =="existe") {
				rd= request.getRequestDispatcher("ModificarPago2.jsp");
				System.out.println("--->Dentro del if" + resultado);
				misesion.setAttribute("Respuesta",resultado);
				rd.forward(request, response);
			}else {
				System.out.println("--->No se encuentra dentro del if porque: " + resultado);
			}
			
		}
		
	}
}
