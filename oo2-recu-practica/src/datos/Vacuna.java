package datos;

import java.time.LocalDate;
import java.time.Period;

public class Vacuna {
	private int idVacuna;
	private long codigo;
	private String nombre;
	private LocalDate fechaElaboracion;
	
	public Vacuna() {}

	public Vacuna(long codigo, String nombre, LocalDate fechaElaboracion) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.fechaElaboracion = fechaElaboracion;
	}

	public int getIdVacuna() {
		return idVacuna;
	}

	protected void setIdVacuna(int idVacuna) {
		this.idVacuna = idVacuna;
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFechaElaboracion() {
		return fechaElaboracion;
	}

	public void setFechaElaboracion(LocalDate fechaElaboracion) {
		this.fechaElaboracion = fechaElaboracion;
	}

	@Override
	public String toString() {
		return "Vacuna [idVacuna=" + idVacuna + ", codigo=" + codigo + ", laboratorio=" + nombre
				+ ", fechaElaboracion=" + fechaElaboracion + "]";
	}
	public int calcularMesesDesdeElaboracion(LocalDate hoy) {
		Period periodo = Period.between(fechaElaboracion, hoy);
		return periodo.getMonths();
	}
	
	
}
