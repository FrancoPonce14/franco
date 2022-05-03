package datos;

public class Inspector extends Persona{
	private int idInspector;
	private int legajo;
	public Inspector() {
		super();
	}
	public Inspector(String apellido, String nombres, int dni, int legajo) {
		super(apellido, nombres, dni);
		this.legajo = legajo;
	}
	public int getIdInspector() {
		return idInspector;
	}
	protected void setIdInspector(int idInspector) {
		this.idInspector = idInspector;
	}
	public int getLegajo() {
		return legajo;
	}
	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}
	@Override
	public String toString() {
		return "Inspector [idInspector=" + idInspector + ", legajo=" + legajo + ", idPersona=" + idPersona
				+ ", apellido=" + apellido + ", nombres=" + nombres + ", dni=" + dni + "]";
	}

	
}
