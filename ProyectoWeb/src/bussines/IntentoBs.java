package bussines;

import beans.Intento;
import dao.IntentoDao;

public class IntentoBs {
private static String direccionBusq;
	
	public int registrarIntento(Intento intento) {
		IntentoDao intentoDao = new IntentoDao();
		int codigo= (Integer) intentoDao.registrarIntento(intento);
		return codigo;
	}
	public int eliminarIntento(Intento intento) {
		IntentoDao intentoDao= new IntentoDao();
		int codigo =(Integer) intentoDao.eliminarIntento(intento);
		return codigo;
	}
	
	public String buscarIntento(Intento intento1) {
		String resultado="";
		IntentoDao intentoDao = new IntentoDao();
		Intento intento2 = new Intento();
		intento2=intentoDao.consultarIntento(intento1);
		
		if ((intento2.getIntento()!=0) &&(intento2.getInstitucion()!=null)&& (intento2.getFechaintento()!=null)) {
			direccionBusq=intento2.getInstitucion();
			resultado="existe";
			
		}else {
			resultado="no existe";
		}
		return resultado;
	}
	
	public String consultarIntento(Intento intento1) {
		String resultado="";
		IntentoDao intentoDao = new IntentoDao();
		Intento intento2 = new Intento();
		intento2=intentoDao.consultarIntento(intento1);
		
		if ((intento2.getIntento()!=0) &&(intento2.getInstitucion()!=null)&& (intento2.getFechaintento()!=null)) {
			direccionBusq=intento2.getInstitucion();
			resultado="existe\n"
			          +"Se encontro la siguiente coincidencia:"
			          + "\nEl intento es: "+ intento2.getIntento()
			          + "\nLa institucion es : " + intento2.getInstitucion()
			          + "\nLa fecha de intento es : " +intento2.getFechaintento();
		}else {
			resultado="no existe";
		}
		return resultado;
	}
	public int actualizarIntento(Intento intento2) {
		Intento intento3= new Intento();
		intento3.setInstitucion(direccionBusq);
		IntentoDao pagoDao = new IntentoDao();
		int codigo=(Integer)pagoDao.actualizarIntento(intento2, intento3);
		
		return codigo;
	}
}
