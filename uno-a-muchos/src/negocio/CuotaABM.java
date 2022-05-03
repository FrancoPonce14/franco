package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.CuotaDao;
import datos.Cuota;
import datos.Prestamo;

public class CuotaABM {
	/*private CuotaDao dao = CuotaDao.getInstancia();
	private static CuotaABM instancia;*/
	CuotaDao dao = new CuotaDao();
	
	
    /*public static CuotaABM getInstancia() {
        if (instancia == null) {
            instancia = new CuotaABM();
        }
        return instancia;
    }*/
	
	
	public Cuota traer(long idCuota) {
		Cuota c = dao.traer(idCuota);
		return c;
	}
	public int agregar(int nroCuota, LocalDate fechaVencimiento, double saldoPendiente, double amortizacion,
			double interesCuota, double cuota, double deuda, boolean cancelada, LocalDate fechaDePago,
			double punitorios, Prestamo prestamo) {
		Cuota c = new Cuota(nroCuota, fechaVencimiento, saldoPendiente, amortizacion, interesCuota, cuota, deuda, cancelada, fechaDePago, punitorios, prestamo);
		return dao.agregar(c);
	}
	public void modificar(Cuota c) {
		dao.Actualizar(c);
	}
	public void eliminar(long idCuota) {
		Cuota c = dao.traer(idCuota);
		dao.Eliminar(c);
	}
	public List<Cuota> traerCuotas(Prestamo p){
		return dao.traer(p);
	}
	public Cuota agregarCuota(Cuota cuota) {
		Cuota c = null;
		
		return c;
	}

}
