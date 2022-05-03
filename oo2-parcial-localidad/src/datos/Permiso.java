package datos;

import java.time.LocalDate;
import java.util.Set;

public class Permiso {
	
	private int idPermiso;
	private Persona persona;
	private LocalDate fecha;
	private int cantDias;
	private Rodado rodado;
	private Set<Lugar> desdeHasta;
	
	public Permiso() {}

	public Permiso(int idPermiso, Persona persona, LocalDate fecha, int cantDias, Rodado rodado) {
		super();
		this.idPermiso = idPermiso;
		this.persona = persona;
		this.fecha = fecha;
		this.cantDias = cantDias;
		this.rodado = rodado;
	}

	public int getIdPermiso() {
		return idPermiso;
	}

	public void setIdPermiso(int idPersona) {
		this.idPermiso = idPersona;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public int getCantDias() {
		return cantDias;
	}

	public void setCantDias(int cantDias) {
		this.cantDias = cantDias;
	}

	public Rodado getRodado() {
		return rodado;
	}

	public void setRodado(Rodado rodado) {
		this.rodado = rodado;
	}

	@Override
	public String toString() {
		return "Permiso [idPermiso=" + idPermiso + ", persona=" + persona + ", fecha=" + fecha + ", cantDias="
				+ cantDias + ", rodado=" + rodado + "]";
	}

	public Set<Lugar> getDesdeHasta() {
		return desdeHasta;
	}

	public void setDesdeHasta(Set<Lugar> desdeHasta) {
		this.desdeHasta = desdeHasta;
	}
	
	
	
	
	
	

}
