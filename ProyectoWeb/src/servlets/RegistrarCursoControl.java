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
 * Servlet implementation class RegistrarCursoControl
 */
@WebServlet("/RegistrarCursoControl")
public class RegistrarCursoControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrarCursoControl() {
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
		
		String nombre = (String) request.getParameter("curso.nombre");
		String fechaInicio = (String)(request.getParameter("curso.fechaInicio"));
		String fechaFin= (String) request.getParameter("curso.fechaFin");
		
		if (nombre==null || nombre.isEmpty()) {
			rd= request.getRequestDispatcher("RegistrarTutor.jsp");
			codigo=-1;
			misesion.setAttribute("codigo", codigo);
			rd.forward(request, response);
			System.err.println("introduca una clave de pago" + codigo);
		}
		else {
			Curso curso = new Curso();
			curso.setNombre(nombre);
			curso.setFechaInicio(fechaInicio);
			curso.setFechaFin(fechaFin);
			
			CursoBS cursobs = new CursoBS();
			int resultado = cursobs.registrarCurso(curso);
			System.out.println("--->resultado " + resultado);
			if (resultado ==1) {
				System.out.println("--->Dentro del if" + resultado);
				rd = request.getRequestDispatcher("Exito.jsp");
				rd.forward(request, response);
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
