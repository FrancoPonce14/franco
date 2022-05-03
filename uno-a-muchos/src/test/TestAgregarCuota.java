package test;

import java.time.LocalDate;

import dao.HibernateUtil;
import datos.Cuota;
//import datos.Cuota;
import datos.Prestamo;
import negocio.CuotaABM;
import negocio.PrestamoABM;

public class TestAgregarCuota {

	public static void main(String[] args) {

		
		
		PrestamoABM prestamoABM = new PrestamoABM();
		CuotaABM cuotaABM = new CuotaABM();
        long idPrestamo = 1;
        System.out.println("\n---> TraerPrestamo idPrestamo=" + idPrestamo + "\n\n");
        try {
            Prestamo p = prestamoABM.traerPrestamo(idPrestamo);
            System.out.println(p + "\nPertenece a " + p.getCliente());
            Cuota c1 = new Cuota(1,LocalDate.of(2019, 05, 10),0.0,0.0,0.0,500.0,0.0,false, LocalDate.of(2019, 04, 20),0.0, p);
			Cuota c2 = new Cuota(2,LocalDate.of(2019, 06, 10),0.0,0.0,0.0,500.0,0.0,false, LocalDate.of(2019, 05, 20),0.0, p);
			Cuota c3 = new Cuota(3,LocalDate.of(2019, 07, 10),0.0,0.0,0.0,500.0,0.0,false, LocalDate.of(2019, 06, 20),0.0, p);
			prestamoABM.agregar(LocalDate.of(2019, 04, 10), 1000, 0.0, 3, p.getCliente());
			cuotaABM.agregarCuota(c1);
			cuotaABM.agregarCuota(c2);
			cuotaABM.agregarCuota(c3);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
			HibernateUtil.getSessionFactory().close();
		}
        
	}

}
