package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.TelepeajeDao;
import datos.Rodado;
import datos.Telepeaje;

public class TelepeajeABM {
	TelepeajeDao dao = new TelepeajeDao();
	
	public List<Telepeaje> traerTelepeaje(Rodado rodado){
		return dao.traerTelepeaje(rodado);
	}
	public List<Telepeaje> traerTelepeaje(String dominio){
		return dao.traerTelepeaje(dominio);	}

	public double cerrarCaja(LocalDate fecha) {
		return dao.cerrarCaja(fecha);
	}
}
