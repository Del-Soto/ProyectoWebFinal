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

import beans.MedioContacto;
import bussines.MedioContactoBs;

public class EliminarMedioContacto {
	@WebServlet("/ContactoControl")
	public class ContactoControl extends HttpServlet {
		private static final long serialVersionUID = 1L;
	       
	    public ContactoControl() {
	        super();
	    }

		protected void doGet(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
			PrintWriter out = response.getWriter();
			RequestDispatcher rd;
			HttpSession misesion = request.getSession();
			
			int codigo = 0;
			
			response.setContentType("text/html");
			response.setContentType("UTF-8");
			
			String telefono = (String) request.getParameter("mediocontacto.telefono");
			String correo = (String) request.getParameter("mediocontacto.correo");
			
			if(telefono.isEmpty() || correo.isEmpty())
			{
				rd = request.getRequestDispatcher("mediodecontacto.jsp");
				codigo = -1;
				misesion.setAttribute("codigo", codigo);
				rd.forward(request, response);
				System.err.println("--->codigo++++" + codigo);
			}
			else
			{
				Contacto contacto = new Contacto();
				contacto.setTelefono(telefono);
				contacto.setCorreo(correo);
			
			
			ContactoBs contactobs = new ContactoBs();
			int resultado = contactobs.registraContacto(contacto);
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
	}
}