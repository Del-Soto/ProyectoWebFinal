package bussines;

import dao.EscuelaDao;
import beans.Escuela;
public class EscuelaBs {
			
	public int registraEscuela(Escuela contacto)
		{
			EscuelaDao contactoDao = new EscuelaDao();
			int codigo=(Integer)contactoDao.registrarEscuela(contacto);
			return codigo;
		}
	public int actualizaPersona(Escuela contacto)
	{
		EscuelaDao contactoDao = new EscuelaDao();
		int codigo=(Integer)contactoDao.actualizaPersona(contacto);
		return codigo;
	}
	public int borrar(Escuela contacto)
	{
		EscuelaDao contactoDao = new EscuelaDao();
		int codigo=(Integer)contactoDao.borrar(contacto);
		return codigo;
	}
		public Escuela findById(Integer id)
		{
			EscuelaDao contactoDAO = new EscuelaDao();
			Escuela contacto;
			contacto = contactoDAO.findbyId(id);
			System.out.println("--->BS.contacto" + contacto);
			return contacto;
		}
		
		public static void main(String[] args)
		{
			EscuelaDao contactoDao = new EscuelaDao();
			Escuela contacto;
			contacto = contactoDao.findbyId(1);
			if(contacto != null)
			{
				System.out.println("Calle: " + contacto.getTelefono());
				System.out.println("Colonia" + contacto.getCorreo());
			}
			else
			{
				System.out.println("Se genero algun error");
			}
		}	
}