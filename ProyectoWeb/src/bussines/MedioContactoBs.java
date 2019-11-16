package bussines;

import dao.MedioContactoDao;
import beans.MedioContacto;

public class MedioContactoBs {
	public int registraContacto(MedioContacto medioContacto)
	{
		ContactoDao contactoDao = new ContactoDao();
		int codigo=(Integer)contactoDao.registrarContacto(medioContacto);
		return codigo;
	}
public int actualizaPersona(MedioContacto medioContacto)
{
	ContactoDao contactoDao = new ContactoDao();
	int codigo=(Integer)contactoDao.actualizaPersona(medioContacto);
	return codigo;
}
public int borrar(MedioContacto medioContacto)
{
	ContactoDao contactoDao = new ContactoDao();
	int codigo=(Integer)contactoDao.borrar(medioContacto);
	return codigo;
}
	public Contacto findById(Integer id)
	{
		ContactoDao contactoDAO = new ContactoDao();
		MedioContacto medioContacto;
		medioContacto = contactoDAO.findbyId(id);
		System.out.println("--->BS.medioContacto" + medioContacto);
		return medioContacto;
	}
	
	public static void main(String[] args)
	{
		ContactoDao contactoDao = new ContactoDao();
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