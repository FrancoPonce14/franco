package test;

import java.time.LocalDate;

import negocio.AulaABM;
import negocio.EdificioABM;
import negocio.EspacioABM;

public class TestParcial {

	public static void main(String[] args) {
		EdificioABM e = new EdificioABM();
		AulaABM a = new AulaABM();
		EspacioABM espacio = new EspacioABM();
		
		//CU 1
		//cree otro toString porque en el principal saque las set<aula> aulas para que no se genere un bucle infinito 
		// de stackoverflow -->> y si usaba ese mismo no me iba a mostrar las aulas por eso el segundo tostring
		System.out.println("CU 1 --> "+ e.traerEdificioConAulas(2).toString2());
		//CU 2
		System.out.println("CU 2 --> "+ a.traer(6));
		//CU 3
		System.out.println("CU 3 --> "+espacio.traer(LocalDate.of(2022, 5, 1), 'M', a.traer(6)));
		//CU 4
		/*try {
			System.out.println("CU 4 --> (Excepcion de abajo)");
			espacio.agregar(LocalDate.of(2022, 5, 1), 'M', a.traer(6), true);
		}catch(Exception ee) {
			System.out.println(ee);
		}
		//CU 5
		try {
			System.out.println("CU 5 --> (Agregar espacio mes (algunos agrega y los que ya existen tira EXPCECION)");
			espacio.agregarEspacioMes(5, 2022, 'M', a.traer(7));
		}catch(Exception ee) {
			System.out.println(ee);
		}*/
		

	}

}
