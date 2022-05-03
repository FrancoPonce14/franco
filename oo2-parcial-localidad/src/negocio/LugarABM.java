package negocio;

import dao.LugarDao;
import datos.Localidad;
import datos.Ubicacion;

public class LugarABM {
	LugarDao dao = new LugarDao();
	
	public Ubicacion traerUbicacion(int id) {
		return dao.traerUbicacion(id);		
	}
	 public Localidad traerLocalidad(int id) {
		return dao.traerLocalidad(id);
	 }
	 

}
