package negocio;

import dao.PersonaDao;
import datos.Contribuyente;
import datos.Inspector;

public class PersonaABM {
	PersonaDao dao = new PersonaDao();
	
	public Contribuyente  traerContribuyente (int idPersona) {
		return dao.traerContribuyente(idPersona);
	}
	public Inspector traerInspector (int idPersona) {
		return dao.traerInspector(idPersona);
	}

}
