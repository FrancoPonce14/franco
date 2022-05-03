package negocio;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import dao.DosisDao;
import datos.Dosis;
import datos.Persona;


public class DosisABM {

	DosisDao dao = new DosisDao();
	
	public List<Dosis> traerDosis(Persona persona) {
		return dao.traerDosis(persona);
	}

	public List<Dosis> traerDosis(LocalDate fechaDesde, LocalDate fechaHasta){
		List<Dosis> aux = dao.traerDosis();
		List<Dosis> dosis = new ArrayList<Dosis>();
		
		for(Dosis d : aux) {
			if(d.getFecha().isAfter(fechaDesde) || d.getFecha().equals(fechaDesde) && d.getFecha().isBefore(fechaHasta) || d.getFecha().equals(fechaHasta)) {
				dosis.add(d);
			}
		}
		
		return dosis;
		
	}
	public List<Dosis> traerDosis(LocalDate fechaDesde, LocalDate fechaHasta, boolean tieneComorbilidades){
		List<Dosis> aux = traerDosis(fechaDesde, fechaHasta);
		List<Dosis> dosis = new ArrayList<Dosis>();
		
		for(Dosis d : aux) {
			if(d.getPersona().isTieneComorbilidad()) {
				dosis.add(d);
			}
		}
		return dosis;
	}
	
}
