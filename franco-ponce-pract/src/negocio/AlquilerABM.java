package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.AlquilerDao;
import datos.Alquiler;

public class AlquilerABM {
	AlquilerDao dao = new AlquilerDao();
	
	public Alquiler traerAlquiler(int id){
		return dao.traerAlquiler(id);
	}

	public double calcularPrecioFinal(Alquiler alquiler) {
		double n = 0;
		n = alquiler.precioFinal();
		return n;
	}
	public List<Alquiler> traerAlquiler(){
		return dao.traerAlquiler();
	}
	public double calcularPrecioFinal(LocalDate desde, LocalDate hasta) {
		double n = 0;
		List<Alquiler> traer = traerAlquiler();
		for(Alquiler a : traer) {
			if(a.getFechaDesde().isAfter(desde) || a.getFechaDesde().isEqual(desde) && a.getFechaHasta().isBefore(hasta) || a.getFechaHasta().isEqual(hasta)) {
				n += a.precioFinal();
			}
		}
		return n;
	}

}
