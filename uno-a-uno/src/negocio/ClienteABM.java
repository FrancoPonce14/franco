package negocio;

import java.time.LocalDate;
import java.util.List;
import dao.ClienteDao;
import datos.Cliente;
import datos.Contacto;

public class ClienteABM {
	ClienteDao dao = new ClienteDao();

	public Cliente traer(long idCliente) {
		Cliente c = dao.traer(idCliente);
		return c;
	}

	public Cliente traer(int dni) {
		Cliente c = dao.traer(dni);
		return c;
	}

	public int agregar(String apellido, String nombre, int dni, LocalDate fechaDeNacimiento, Contacto contacto) throws Exception {
		//CONSULTAR SI EXISTE UN CLIENTE CON EL MISMO DNI, SI EXISTE ARROJAR LA EXCEPCION
		Cliente c = this.traer(dni);
		if(c != null) {
			throw new Exception("Ya existe una persona con dni --> "+dni+" Ingrese otro");
		}
		return dao.agregar(new Cliente(apellido, nombre, dni, fechaDeNacimiento, contacto));
	}

	@SuppressWarnings("null")
	public void modificar(Cliente c) throws Exception {
		//IMPLEMENTAR ANTES DE ACTUALIZAR QUE NO EXISTA UN CLIENTE CON EL MISMO
		//DOCUMENTO A MODIFICAR Y CON EL MISMO ID, LANZAR LA EXCEPCION
		Cliente d1 = this.traer(c.getDni());

		if(d1 != null) {
			throw new Exception("Ya existe una persona con dni --> "+d1.getDni()+" Ingrese otro");
		}
		if(c.getIdCliente() != d1.getIdCliente()) {
			throw new Exception("No se puede modificar la persona con id --> "+c.getIdCliente()+" Ya que no existe!");
		}

		dao.actualizar(c);
	}

	public void eliminar(long idCliente) throws Exception{
		//EN ESTE CASO ES FISICA EN GRAL. NO SE SI APLICARIA EN ESTE CASO DE USO, SI
		//SE HICIERA HABRIA QUE VALIDAR QUE EL CLIENTE NO TENGA DEPENDENCIAS
		Cliente c = dao.traer(idCliente);
		//IMPLEMENTAR QUE SI ES NULL ARROJE LA EXCEPCION 
		if(c == null) {
			throw new Exception("NULL ---> "+idCliente);
		}
		dao.eliminar(c);
	}

	public List<Cliente> traer() {
		return dao.traer();
	}
	public Cliente traerClienteYContacto(long idCliente) throws Exception {
		Cliente c = dao.traerClienteYContacto(idCliente);
		if(c == null) {
			throw new Exception("NULL --> "+idCliente);
		}
		return c;
	}
}
