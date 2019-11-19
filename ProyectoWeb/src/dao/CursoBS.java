package dao;

import beans.Curso;
import dao.CursoDao;

public class CursoBS {
	
private static String direccionBusq;
	
	public int registrarCurso(Curso curso) {
		CursoDao cursoDao = new CursoDao();
		int codigo= (Integer)cursoDao.registrarCurso(curso);
		return codigo;
	}
	
	public int eliminarCurso(Curso curso) {
		CursoDao cursoDao = new CursoDao();
		int codigo =(Integer) cursoDao.eliminarCurso(curso);
		return codigo;
	}
	
	public String buscarCurso(Curso curso1) {
		String resultado="";
		CursoDao cursoDao = new CursoDao();
		Curso curso2 = new Curso();
		curso2 = cursoDao.consultarCurso(curso1);
		
		if (curso2.getNombre() !=null) {
			direccionBusq=curso2.getNombre();
			resultado="existe";
			
		}else {
			resultado="no existe";
		}
		return resultado;
	}

	public String consultarPago(Curso curso1) {
		String resultado="";
		CursoDao cursoDao = new CursoDao();
		Curso curso2 = new Curso();
		curso2 = cursoDao.consultarCurso(curso1);
		/*
		if ((curso2.getClavePago()!=null) &&(curso2.getMonto()!=0)) {
			direccionBusq=curso2.getClavePago();
			resultado="existe\n"
			          +"Se encontro la siguiente coincidencia:"
			          + "\nLa clave de pago es: "+ pago2.getClavePago()
			          + "\nEl monto es de: " + pago2.getMonto()
			          + "\nLa fecha de pago es: " +pago2.getFechaPago();
		}else {
			resultado="no existe";
		}*/
		return resultado;
	}
	
	public int actualizarCurso(Curso curso2) {
		Curso curso3= new Curso();
		curso3.setNombre(direccionBusq);
		CursoDao cursoDao = new CursoDao();
		int codigo=(Integer)cursoDao.actualizarCurso(curso2, curso3);
		
		return codigo;

	}
}
