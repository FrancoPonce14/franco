package test;

import java.time.LocalDate;
import java.util.List;

import datos.Telepeaje;
import negocio.PersonaABM;
import negocio.RodadoABM;
import negocio.TelepeajeABM;

public class Test {

	public static void main(String[] args) {
		PersonaABM persona = new PersonaABM();
		RodadoABM rodado = new RodadoABM();
		TelepeajeABM telepeaje = new TelepeajeABM();
		
		
		System.out.println("CU 1  ---> "+persona.traerEmpresa());
		System.out.println("CU 2  ---> "+persona.traerAbonado());
		System.out.println("CU 3  ---> "+persona.traerAbonado("Gonzalez"));
		System.out.println("CU 4 ---> "+telepeaje.cerrarCaja(LocalDate.of(2020, 11, 1)));
		System.out.println("CU 5 ---> "+rodado.traerRodado("BBB222"));
		List<Telepeaje> t = telepeaje.traerTelepeaje(rodado.traerRodado("BBB222"));
		System.out.println("CU 6 ---> "+t);
		for(Telepeaje tele : t) {
			System.out.println("CU 7 ---> Recargo: "+tele.calcularRecargo(5));
		}
		System.out.println("CU 8 ---> "+persona.traerAbonado(55555555));
		System.out.println("CU 9 ---> "+telepeaje.traerTelepeaje("CCC333"));
		
	}

}
