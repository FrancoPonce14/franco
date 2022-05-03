package test;

import java.time.LocalDate;

import datos.Cliente;
import negocio.ClienteABM;

public class AgregarCliente {

	public static void main(String[] args) {
		ClienteABM cliente = new ClienteABM();
		Cliente c = new Cliente("Ponce", "Franco", 42778410, LocalDate.of(2000, 7, 14));
		cliente.agregar(c);

	}

}
