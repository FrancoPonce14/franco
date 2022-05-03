package test;

import negocio.AutomotorABM;
import negocio.InspeccionABM;
import negocio.PersonaABM;

public class TestParcial {

	public static void main(String[] args) {
		PersonaABM p = new PersonaABM();
		AutomotorABM a = new AutomotorABM();
		InspeccionABM i = new InspeccionABM();
		
		System.out.println("CU 1 --> "+ p.traerContribuyente(2));
		System.out.println("CU 2 --> "+ p.traerInspector(1));
		System.out.println("CU 3 --> "+ a.traerAutomotor("LLL444"));
		System.out.println("CU 4 --> "+ i.traerInspeccion(1));
		System.out.println("CU 5 --> "+ i.traerInspeccion(a.traerAutomotor("LLL444")));

	}

}
