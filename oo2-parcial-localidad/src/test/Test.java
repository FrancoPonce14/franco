package test;

import java.time.LocalDate;

import datos.Localidad;
import datos.Ubicacion;
import negocio.LugarABM;
import negocio.PermisoABM;

public abstract class Test {

	public static void main(String[] args) {
		PermisoABM permiso = new PermisoABM();
		System.out.println("CU 1 : "+permiso.traerPermiso(4));
		LugarABM lugar = new LugarABM();
		Localidad l = lugar.traerLocalidad(3);
		System.out.println("CU 2 : "+l);
		System.out.println("CU 3 : "+l.ingresoHabilitado(4, LocalDate.of(2021, 5, 12)));
		System.out.println("CU 4 : "+l.ingresoHabilitado(4, LocalDate.of(2021, 5, 20)));
		System.out.println("CU 5 : "+l.ingresoHabilitado(4, LocalDate.of(2021, 5, 25)));
		Ubicacion u = lugar.traerUbicacion(4);
		System.out.println("CU 6 : "+u);
		System.out.println("CU 7 : "+l.ingresoHabilitado(3, LocalDate.of(2021, 4, 30)));
		System.out.println("CU 8 : "+l.ingresoHabilitado(3, LocalDate.of(2021, 3, 31)));

	}

}
