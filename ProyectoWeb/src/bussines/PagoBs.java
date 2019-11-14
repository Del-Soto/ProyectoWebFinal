package bussines;

import beans.Pago;
import dao.PagoDao;

public class PagoBs {
	private static String direccionBusq;
	
	public int registrarPago(Pago pago) {
		PagoDao pagoDao = new PagoDao();
		int codigo= (Integer) pagoDao.registrarPago(pago);
		return codigo;
	}
	public int eliminarPago(Pago pago) {
		PagoDao pagoDao= new PagoDao();
		int codigo =(Integer) pagoDao.eliminarPago(pago);
		return codigo;
	}
	
	public String buscarPago(Pago pago1) {
		String resultado="";
		PagoDao pagoDao = new PagoDao();
		Pago pago2 = new Pago();
		pago2=pagoDao.consultarPago(pago1);
		
		if ((pago2.getClavePago()!=null) &&(pago2.getMonto()!=0)) {
			direccionBusq=pago2.getClavePago();
			resultado="existe";
			
		}else {
			resultado="no existe";
		}
		return resultado;
	}
	
	public String consultarPago(Pago pago1) {
		String resultado="";
		PagoDao pagoDao = new PagoDao();
		Pago pago2 = new Pago();
		pago2=pagoDao.consultarPago(pago1);
		
		if ((pago2.getClavePago()!=null) &&(pago2.getMonto()!=0)) {
			direccionBusq=pago2.getClavePago();
			resultado="existe\n"
			          +"Se encontro la siguiente coincidencia:"
			          + "\nLa clave de pago es: "+ pago2.getClavePago()
			          + "\nEl monto es de: " + pago2.getMonto()
			          + "\nLa fecha de pago es: " +pago2.getFechaPago();
		}else {
			resultado="no existe";
		}
		return resultado;
	}
	public int actualizarPago(Pago pago2) {
		Pago pago3= new Pago();
		pago3.setClavePago(direccionBusq);
		PagoDao pagoDao = new PagoDao();
		int codigo=(Integer)pagoDao.actualizarPago(pago2, pago3);
		
		return codigo;
	}
}
