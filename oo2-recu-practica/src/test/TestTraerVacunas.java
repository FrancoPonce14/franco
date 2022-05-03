package test;


import java.time.LocalDate;

import datos.Persona;
import negocio.DosisABM;
import negocio.PersonaABM;
import negocio.VacunaABM;

public class TestTraerVacunas {

	public static void main(String[] args) {
		PersonaABM persona=new PersonaABM();
		VacunaABM vacuna=new VacunaABM();
		 //DosisABM dosis=new DosisABM();
		
		System.out.println("CU 1 "+persona.traePersona(33333333));
		System.out.println("CU 1.5 "+vacuna.traerVacuna(1).calcularMesesDesdeElaboracion(LocalDate.of(2020, 10, 10)));
		System.out.println("CU 2 "+vacuna.TraerVacuna(1, 2));
        
        // Persona perso = persona.traePersona(33333333);
        // System.out.println(dosis.traerDosis(perso));
        //System.out.println("\n\n");
        //System.out.println(dosis.traerDosis(LocalDate.of(2020, 6, 1), LocalDate.of(2020, 6, 15)));
        //System.out.println("\n\n");
        //System.out.println(dosis.traerDosis(LocalDate.of(2020, 6, 1), LocalDate.of(2020, 6, 15), true));

        
	}

}
