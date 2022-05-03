package negocio;

import java.util.List;

import dao.ClienteDao;
import datos.Cliente;
import datos.Evento;

public class ClienteABM {
	ClienteDao dao = new ClienteDao();
	
	public int agregar(Cliente c){
		return dao.agregar(c);
	}
	public Cliente traer(long idCliente) {
		Cliente aux = dao.traer(idCliente);
		return aux;
	}
	public void actualizar(Cliente c) throws Exception{
	boolean modificar = true;
	Cliente existeCliente= dao.traer(c.getIdCliente());
	if(existeCliente!=null && existeCliente.getIdCliente()!=c.getIdCliente()) {
		modificar= false;
		throw new Exception("El cliente existe, no se puede modificar porque ya hay otro con ese DNI");
	}
	if(modificar==true) {
		dao.actualizar(c);
	}
	}
	public void elimninar(long idCliente) throws Exception {
		Cliente c = dao.traer(idCliente);
		if(c==null) {
			throw new Exception("No puedo eliminar algo que no existe");
		}
		dao.eliminar(c);
	}
	public List<Cliente> traer(){
		return dao.traer();
	}
	public Cliente traerClienteyEventos(long idCliente) {
		return dao.traerClienteyEventos(idCliente);
	}
	/*public void agregarEventoACliente(Evento e, long idCliente) {
		Cliente c = this.traerClienteyEventos(idCliente);
		c.getEventos().add(e);
		actualizar(c);
	}
	public void eliminarEventoACliente(Evento e, long idCliente) {
		Cliente c = this.traerClienteyEventos(idCliente);
		c.getEventos().remove(e);
		actualizar(c);
	}*/
	public boolean agregarEventoACliente(Evento e, Cliente c) {
		return dao.agregarEvento(e, c);
	}
	public boolean eliminarEventoACliente(Evento e, Cliente c) {
		return dao.eliminarEvento(e, c);
	}
}
