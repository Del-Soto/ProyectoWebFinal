package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrarEnfermedad
 */
@WebServlet("/")
public class RegistrarEnfermedad extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrarEnfermedad() {
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
		response.setContentType("UTF-8");
		
		String telefono = (String) request.getParameter("mediocontacto.telefono2");
		String correo = (String) request.getParameter("mediocontacto.correo2");
		String id=(String)request.getParameter("id");
		
		if(telefono.isEmpty() || correo.isEmpty()||id.isEmpty())
		{
			rd = request.getRequestDispatcher("mediodecontacto.jsp");
			codigo = -1;
			misesion.setAttribute("codigo", codigo);
			rd.forward(request, response);
			System.err.println("--->codigo++++" + codigo);
		}
		else
		{
			Enfermedad contacto = new Enfermedad();
			contacto.setTelefono(telefono);
			contacto.setCorreo(correo);
			contacto.setId(Integer.parseInt(id));
		
		EnfermedadBs contactobs = new EnfermedadBs();
		int resultado = contactobs.actualizaPersona(contacto);
		System.out.println("--->resultado" + resultado);
		
		if(resultado == 1)
		{
			System.out.println("--->Dentro del if" + resultado);
			rd = request.getRequestDispatcher("exito.jsp");
			codigo = 1;
			misesion.setAttribute("codigo", codigo);
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