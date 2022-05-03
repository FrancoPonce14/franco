package negocio;

import dao.AulaDao;
import datos.Aula;

public class AulaABM {
	AulaDao dao = new AulaDao();
	public Aula traer(int id) {
		return dao.traer(id);
	}

}
