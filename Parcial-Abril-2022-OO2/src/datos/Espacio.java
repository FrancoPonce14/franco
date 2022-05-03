package datos;

import java.time.LocalDate;

public class Espacio {
	private int id;
	private LocalDate fecha;
	private char turno;
	private Aula aula;
	private boolean libre;
	
	public Espacio() {}

	public Espacio(LocalDate fecha, char turno, Aula aula, boolean libre) {
		super();
		this.fecha = fecha;
		this.turno = turno;
		this.aula = aula;
		this.libre = libre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public char getTurno() {
		return turno;
	}

	public void setTurno(char turno) {
		this.turno = turno;
	}

	public Aula getAula() {
		return aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}

	public boolean isLibre() {
		return libre;
	}

	public void setLibre(boolean libre) {
		this.libre = libre;
	}

	@Override
	public String toString() {
		return "Espacio [id=" + id + ", fecha=" + fecha + ", turno=" + turno + ", aula=" + aula
				+ ", libre=" + libre + "]";
	}
	

}
