package negocio;

import dao.PermisoDao;
import datos.Permiso;

public class PermisoABM {
	PermisoDao dao = new PermisoDao();
	
	public Permiso traerPermiso(int id) {
		return dao.traerPermiso(id);
	}

}
