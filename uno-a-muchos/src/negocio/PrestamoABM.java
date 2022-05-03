package negocio;

import dao.PrestamoDao;
import java.time.LocalDate;
import java.util.List;
import datos.Cliente;
import datos.Prestamo;

public class PrestamoABM {
	private PrestamoDao dao = new PrestamoDao();

	public Prestamo traerPrestamo(long idPrestamo) throws Exception{
		//IMPLEMENTAR: SI EL NO EXISTE EL PRESTAMO LANZAR LA EXCEPCION
		Prestamo p = dao.traer(idPrestamo);
		if(p == null) {
			throw new Exception("NO EXISTE EL PRESTAMO");
		}
		return p;
	}

	public List<Prestamo> traerPrestamo(Cliente c) {
		return dao.traer(c);
	}
	
	public int agregar(LocalDate fecha, double monto, double interes, int cantCuotas, Cliente cliente) {
		Prestamo p = new Prestamo(fecha, monto, interes, cantCuotas, cliente);
		return dao.agregar(p);
	}
	public void modificar(Prestamo p) {
		dao.Actualizar(p);
	}
	public void eliminar(Prestamo p) {
		dao.Eliminar(p);
	}
}
