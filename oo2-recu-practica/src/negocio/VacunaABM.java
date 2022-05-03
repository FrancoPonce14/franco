package negocio;

import datos.Vacuna;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import dao.VacunaDao;

public class VacunaABM {
	VacunaDao dao=new VacunaDao();
	
	
	public List<Vacuna>TraerVacuna(int mesesDesde, int mesesHasta){
		
		List <Vacuna>aux=new ArrayList<Vacuna>();
		List<Vacuna> vacunas = dao.traerVacuna();
		for(Vacuna v : vacunas){
			int num = v.calcularMesesDesdeElaboracion(LocalDate.now());
			if(num >= mesesDesde && num >= mesesHasta) {
				aux.add(v);
			}
				
		}

		return aux;
}
	public Vacuna traerVacuna(int id) {
		return dao.traerVacuna(id);
	}
}
