package test;

import datos.Cliente;
import datos.Evento;
import negocio.ClienteABM;
import negocio.EventoABM;

public class agregar {

	public static void main(String[] args){
		
			ClienteABM cliente = new ClienteABM();
			EventoABM evento = new EventoABM();
			//ADD
			/*try {
				cliente.agregarEventoACliente(evento.traer(2), cliente.traer(3));
			}catch(Exception e) {
				System.out.println(e);
			}*/
			//DELETE
			try {
				cliente.eliminarEventoACliente(evento.traer(2), cliente.traer(3));
			}catch(Exception e) {
				System.out.println(e);
			}
			
			
			//Cliente c = cliente.traer(1);
			//System.out.println(c+" Traigo el cliente --> "+c.getIdCliente());
			//Evento e = evento.traer(1);
			//System.out.println(e+" Traigo el Evento --> "+e.getIdEvento());
			//cliente.agregarEventoACliente(e, c.getIdCliente());
	}

}
