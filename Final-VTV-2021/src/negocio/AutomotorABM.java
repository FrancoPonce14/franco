package negocio;

import dao.AutomotorDao;
import datos.Automotor;

public class AutomotorABM {
	AutomotorDao dao = new AutomotorDao();
	public Automotor traerAutomotor (String dominio) {
		return dao.traerAutomotor(dominio);
	}

}
