package bussines;

import dao.MedioContactoDao;
import beans.MedioContacto;

public class MedioContactoBs {
	public int registraContacto(MedioContacto medioContacto)
	{
		MedioContactoDao contactoDao = new MedioContactoDao();
		int codigo=(Integer)contactoDao.registrarContacto(medioContacto);
		return codigo;
	}
public int actualizaPersona(MedioContacto medioContacto)
{
	MedioContactoDao contactoDao = new MedioContactoDao();
	int codigo=(Integer)contactoDao.actualizaPersona(medioContacto);
	return codigo;
}
public int borrar(MedioContacto medioContacto)
{
	MedioContactoDao contactoDao = new MedioContactoDao();
	int codigo=(Integer)contactoDao.borrar(medioContacto);
	return codigo;
}
	public Contacto findById(Integer id)
	{
		MedioContactoDao contactoDAO = new MedioContactoDao();
		MedioContacto medioContacto;
		medioContacto = contactoDAO.findbyId(id);
		System.out.println("--->BS.medioContacto" + medioContacto);
		return medioContacto;
	}
	
	public static void main(String[] args)
	{
		MedioContactoDao contactoDao = new MedioContactoDao();
		MedioContacto medioContacto;
		medioContacto = contactoDao.findbyId(1);
		if(medioContacto != null)
		{
			System.out.println("Calle: " + medioContacto.getTelefono());
			System.out.println("Colonia" + medioContacto.getCorreo());
		}
		else
		{
			System.out.println("Se genero algun error");
		}
	}
}