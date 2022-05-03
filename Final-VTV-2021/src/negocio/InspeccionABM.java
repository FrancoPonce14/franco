package negocio;

import java.util.List;

import dao.InspeccionDao;
import datos.Automotor;
import datos.Inspeccion;

public class InspeccionABM {
	InspeccionDao dao= new InspeccionDao();
	
	public Inspeccion traerInspeccion (int idInspeccion) {
		return dao.traerInspeccion(idInspeccion);
	}
	public List<Inspeccion> traerInspeccion (Automotor automotor){
		return dao.traerInspeccion(automotor);
	}

}
