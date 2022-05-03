package negocio;

import java.util.ArrayList;
import java.util.List;

import dao.PersonaDao;
import datos.Abonado;
import datos.Empresa;

public class PersonaABM {
	PersonaDao dao = new PersonaDao();
	
	public List<Empresa> traerEmpresa(){
		return dao.traerEmpresa();
	}
	public List<Abonado> traerAbonado(){
		return dao.traerAbonado();
	}
	public List<Abonado> traerAbonado(String apellido){
		List<Abonado> aux = dao.traerAbonado();
		List<Abonado> abonado = new ArrayList<Abonado>();
		for(Abonado a : aux) {
			if(a.getApellido().equals(apellido)) {
				abonado.add(a);
			}
		}
		return abonado;
	}
	public Abonado traerAbonado(long dni) {
		return dao.traerAbonado(dni);	}

}
