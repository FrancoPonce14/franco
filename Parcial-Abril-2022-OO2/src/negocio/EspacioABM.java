package negocio;

import datos.Aula;
import datos.Espacio;
import funciones.Funciones;

import java.time.LocalDate;
import java.util.List;


import dao.EspacioDao;


public class EspacioABM {
	EspacioDao dao = new EspacioDao();
	
	public Espacio traer(LocalDate fecha, char turno, Aula aula) {
		List<Espacio> t = dao.traer();
		Espacio ee = null;
		for(Espacio e : t) {
			if(e.getFecha().isEqual(fecha) && e.getTurno() == turno && e.getAula().getId() == aula.getId()) {
				ee = e;
			}
		}
		
		
		return ee;
		
	}
	public int agregar(LocalDate fecha, char turno, Aula aula, boolean libre) throws Exception{
		Espacio n = this.traer(fecha, turno, aula);
		if (n != null) {
			throw new Exception ("Ya existe ese espacio! ");
		}
		Espacio agregar = new Espacio(fecha, turno, aula, libre);
		return dao.agregar(agregar);
	}
	public void agregarEspacioMes(int mes, int anio, char turno, Aula aula) throws Exception {

		List<Espacio> aux = dao.traer();
		for(Espacio pp : aux) {
			LocalDate hoy = LocalDate.now();
			LocalDate maniana = hoy.plusDays(1);
			LocalDate fecha = Funciones.traerFecha(anio, mes, maniana.getDayOfMonth());
			Espacio espacio = this.traer(fecha, pp.getTurno(), pp.getAula());
			if(espacio.isLibre()) {
				agregar(pp.getFecha(), turno, aula, true);
			}
		}

	}

}
