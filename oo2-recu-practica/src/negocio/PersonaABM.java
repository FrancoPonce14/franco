package negocio;

import dao.PersonaDao;
import datos.Persona;

public class PersonaABM {
	PersonaDao dao=new PersonaDao();
	public Persona traePersona(long documento){
		return dao.traerPersona(documento);
	}
}
