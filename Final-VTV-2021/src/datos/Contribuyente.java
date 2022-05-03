package datos;

public class Contribuyente extends Persona{
	private int idContribuyente;
	private boolean esExcento;
	public Contribuyente() {
		super();
	}
	public Contribuyente(String apellido, String nombres, int dni, boolean esExcento) {
		super(apellido, nombres, dni);
		this.esExcento = esExcento;
	}
	public int getIdContribuyente() {
		return idContribuyente;
	}
	protected void setIdContribuyente(int idContribuyente) {
		this.idContribuyente = idContribuyente;
	}
	public boolean isEsExcento() {
		return esExcento;
	}
	public void setEsExcento(boolean esExcento) {
		this.esExcento = esExcento;
	}
	@Override
	public String toString() {
		return "Contribuyente [idContribuyente=" + idContribuyente + ", esExcento=" + esExcento + ", idPersona="
				+ idPersona + ", apellido=" + apellido + ", nombres=" + nombres + ", dni=" + dni + "]";
	}
	
	

}
