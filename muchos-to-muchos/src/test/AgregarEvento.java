package test;

import java.time.LocalDate;

import datos.Evento;
import negocio.EventoABM;

public class AgregarEvento {

	public static void main(String[] args) {
		EventoABM evento = new EventoABM();
		Evento e = new Evento("Pool party", LocalDate.of(2022, 3, 30));
		evento.agregar(e);

	}

}
