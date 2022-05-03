package negocio;

import java.util.List;

import dao.EventoDao;
import datos.Cliente;
import datos.Evento;



public class EventoABM {
	EventoDao dao = new EventoDao();
	
	public int agregar(Evento e){
		return dao.agregar(e);
	}
	public Evento traer(long idEvento) {
		Evento aux = dao.traer(idEvento);
		return aux;
	}
	public void actualizar(Evento e) {
		dao.actualizar(e);
	}
	public void elimninar(Evento e) {
		dao.eliminar(e);
	}
	public List<Evento> traer(){
		return dao.traer();
	}
	public Evento traerEventoYClientes(long idEvento) {
		Evento e = dao.traerEventoYClientes(idEvento);
		return e;
	}
	public void agregarClienteAEvento(Cliente c, long idEvento) {
		Evento e = traerEventoYClientes(idEvento);
		e.getClientes().add(c);
		actualizar(e);
	}
	public void eliminarEventoACliente(Cliente c, long idEvento) {
		Evento e = traerEventoYClientes(idEvento);
		e.getClientes().remove(c);
		actualizar(e);
	}
}
