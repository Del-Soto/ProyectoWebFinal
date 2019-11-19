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

import beans.Curso;
import bussines.CursoBS;

/**
 * Servlet implementation class ModificarCursoControl1
 */
@WebServlet("/ModificarCursoControl1")
public class ModificarCursoControl1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarCursoControl1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter out = response.getWriter();
		RequestDispatcher rd;
		HttpSession misesion = request.getSession();
		int codigo = 0;
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		String nombre= (String) request.getParameter("curso.nombre");
		
		if (nombre==null || nombre.isEmpty()) {
			rd= request.getRequestDispatcher("ModificarPago.jsp");
			codigo=-1;
			misesion.setAttribute("codigo", codigo);
			rd.forward(request, response);
			System.err.println("introduca una clave de pago" + codigo);
		}
		else {
			Curso curso1 = new Curso();
			curso1.setNombre(nombre);
			CursoBS cursobs = new CursoBS();
			String resultado = cursobs.buscarCurso(curso1);
			if (resultado =="existe") {
				rd= request.getRequestDispatcher("ModificarCursoDatos.jsp");
				System.out.println("--->Dentro del if" + resultado);
				misesion.setAttribute("Respuesta",resultado);
				rd.forward(request, response);
			}else {
				System.out.println("--->No se encuentra dentro del if porque: " + resultado);
			}
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
