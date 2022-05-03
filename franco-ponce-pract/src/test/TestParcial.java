package test;

import java.time.LocalDate;

import negocio.AlquilerABM;
import negocio.PropiedadABM;

public class TestParcial {

	public static void main(String[] args) {
		PropiedadABM p = new PropiedadABM();
		AlquilerABM a = new AlquilerABM();
		System.out.println("\nCU 1 --> "+p.traerPropiedad());
		System.out.println("\nCU 2 --> "+a.traerAlquiler(1));
		System.out.println("\nCU 3 --> "+p.traerPropiedad(true));
		System.out.println("\nCU 4 --> "+a.calcularPrecioFinal(a.traerAlquiler(1)));
		System.out.println("\nCU 5 --> "+a.calcularPrecioFinal(LocalDate.of(2022, 3, 2), LocalDate.of(2022, 3, 9)));

	}

}
