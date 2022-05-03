package negocio;

import java.util.List;

import dao.ClienteDao;
import datos.Cliente;

public class ClienteABM {
	ClienteDao dao = new ClienteDao();
	
	public void agregar(Cliente c) {
		dao.agregar(c);
	}
	public Cliente traer(int idCliente) {
		Cliente aux = dao.traer(idCliente);
		return aux;
	}
	public List<Cliente> traer(){
		return dao.traer();
	}
	public Cliente traerClientePorDNI(int dni) {
		Cliente aux = dao.traerClientePorDNI(dni);
		return aux;
	}

}
