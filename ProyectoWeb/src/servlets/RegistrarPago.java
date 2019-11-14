package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

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
 * Servlet implementation class RegistrarPago
 */
@WebServlet("/RegistrarPago")
public class RegistrarPago extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrarPago() {
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
			String montop = (String)(request.getParameter("pago.monto"));
			String fechapago= (String) request.getParameter("pago.fechapago");
			if (clavepago==null || clavepago.isEmpty()) {
				rd= request.getRequestDispatcher("RegistrarTutor.jsp");
				codigo=-1;
				misesion.setAttribute("codigo", codigo);
				rd.forward(request, response);
				System.err.println("introduca una clave de pago" + codigo);
			}else if(montop==null || montop.isEmpty()) {
				
			}
			else {
				float monto = Float.parseFloat(request.getParameter("pago.monto"));
				Pago pago = new Pago();
				pago.setClavePago(clavepago);
				pago.setMonto(monto);
				pago.setFechaPago(fechapago);
				//pago.setFechaPago(fechapago);
				PagoBs pagobs = new PagoBs();
				int resultado = pagobs.registrarPago(pago);
				System.out.println("--->resultado " + resultado);
				if (resultado ==1) {
					System.out.println("--->Dentro del if" + resultado);
					rd = request.getRequestDispatcher("Exito.jsp");
					rd.forward(request, response);
				}
				
			}
}
}
