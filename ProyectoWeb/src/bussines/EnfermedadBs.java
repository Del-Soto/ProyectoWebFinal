package bussines;

import dao.EnfermedadDao;
import beans.Enfermedad;

public class EnfermedadBs {
	public int registraContacto(Enfermedad medioContacto)
	{
		EnfermedadDao contactoDao = new EnfermedadDao();
		int codigo=(Integer)contactoDao.registrarContacto(Enfermedad);
		return codigo;
	}
public int actualizaPersona(Enfermedad medioContacto)
{
	EnfermedadDao contactoDao = new EnfermedadDao();
	int codigo=(Integer)contactoDao.actualizaPersona(medioContacto);
	return codigo;
}
public int borrar(Enfermedad medioContacto)
{
	EnfermedadDao contactoDao = new EnfermedadDao();
	int codigo=(Integer)contactoDao.borrar(medioContacto);
	return codigo;
}
	public Contacto findById(Integer id)
	{
		EnfermedadDao contactoDAO = new EnfermedadDao();
		Enfermedad medioContacto;
		medioContacto = contactoDAO.findbyId(id);
		System.out.println("--->BS.medioContacto" + medioContacto);
		return medioContacto;
	}
	
	public static void main(String[] args)
	{
		EnfermedadDao contactoDao = new EnfermedadDao();
		Enfermedad medioContacto;
		medioContacto = contactoDao.findbyId(1);
		if(medioContacto != null)
		{
			System.out.println("Nombre: " + medioContacto.getTelefono());
			System.out.println("Indicacion" + medioContacto.getCorreo());
		}
		else
		{
			System.out.println("Se genero algun error");
		}
	}
}