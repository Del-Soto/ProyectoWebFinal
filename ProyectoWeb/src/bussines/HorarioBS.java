package bussines;

import beans.Horario;
import dao.HorarioDao;

public class HorarioBS {
private static String direccionBusq;
	
	public int registrarHorario(Horario horario) {
		HorarioDao horarioDao = new HorarioDao();
		int codigo= (Integer)horarioDao.registrarHorario(horario);
		return codigo;
	}
	
	public int eliminarHorario(Horario horario) {
		HorarioDao horarioDao = new HorarioDao();
		int codigo =(Integer) horarioDao.eliminarHorario(horario);
		return codigo;
	}
	
	public String buscarHorario(Horario horario1) {
		String resultado="";
		HorarioDao horarioDao = new HorarioDao();
		Horario horario2 = new Horario();
		horario2 = horarioDao.consultarHorario(horario1);

		if (horario2.getHorarioInicio() !=null) {
			direccionBusq=horario2.getHorarioInicio();
			resultado="existe";
			
		}else {
			resultado="no existe";
		}
		return resultado;
	}

	public String consultarHorario(Horario horario1) {
		String resultado="";
		HorarioDao horarioDao = new HorarioDao();
		Horario horario2 = new Horario();
		horario2 = horarioDao.consultarHorario(horario1);
		return resultado;
	}
	
	public int actualizarHorario(Horario horario2) {
		Horario horario3= new Horario();
		horario3.setHorarioInicio(direccionBusq);
		HorarioDao horarioDao = new HorarioDao();
		int codigo=(Integer)horarioDao.actualizarHorario(horario2, horario3);
		
		return codigo;

	}
}
