package datos;

import java.time.LocalDate;
import java.time.LocalTime;

public class Dosis {
	private int idDosis;
	private String vacunatorio;
	private LocalDate fecha;
	private LocalTime hora;
	private Persona persona;
	private Vacuna vacuna;
	
	public Dosis() {}

	public Dosis(String vacunatorio, LocalDate fecha, LocalTime hora, Persona persona, Vacuna vacuna) {
		super();
		this.vacunatorio = vacunatorio;
		this.fecha = fecha;
		this.hora = hora;
		this.persona = persona;
		this.vacuna = vacuna;
	}

	public int getIdDosis() {
		return idDosis;
	}

	protected void setIdDosis(int idDosis) {
		this.idDosis = idDosis;
	}

	public String getVacunatorio() {
		return vacunatorio;
	}

	public void setVacunatorio(String vacunatorio) {
		this.vacunatorio = vacunatorio;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Vacuna getVacuna() {
		return vacuna;
	}

	public void setVacuna(Vacuna vacuna) {
		this.vacuna = vacuna;
	}

	@Override
	public String toString() {
		return "\nDosis [idDosis=" + idDosis + ", vacunatorio=" + vacunatorio + ", fecha=" + fecha + ", hora=" + hora
				+ ", persona=" + persona + ", vacuna=" + vacuna + "]";
	}
	
	
}
