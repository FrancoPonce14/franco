package test;

import negocio.ClienteABM;

public class TestCliente {
	public static void main(String[] args) {
		ClienteABM c = new ClienteABM();
		int idCliente1 = 1;
		System.out.println(c+" Traigo el cliente 1 --> "+c.traer(idCliente1));
		int idCliente2 = 2;
		System.out.println(c+" Traigo el cliente 2 --> "+c.traer(idCliente2));
		
		System.out.println("LISTA --> "+c.traer());
	}
}
