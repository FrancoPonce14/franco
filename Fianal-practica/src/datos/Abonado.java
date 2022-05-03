package datos;

public class Abonado extends Persona {
	private int idAbonado;
	private String apellido;
	private String nombres;
	private long dni;
	
	public Abonado() {
		super();
	}
	public Abonado(String nroCuenta, String apellido, String nombres, long dni) {
		super(nroCuenta);
		this.apellido = apellido;
		this.nombres = nombres;
		this.dni = dni;
	}
	public int getIdAbonado() {
		return idAbonado;
	}
	protected void setIdAbonado(int idAbonado) {
		this.idAbonado = idAbonado;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public long getDni() {
		return dni;
	}
	public void setDni(long dni) {
		this.dni = dni;
	}
	
	@Override
	public String toString() {
		return super.toString() +" Abonado [idAbonado=" + this.getId() + ", apellido=" + apellido + ", nombres=" + nombres + ", dni=" + dni
				+ "]";
	}
	/*@Override
	public String toString() {
		return "Abonado [id=" + id + ", apellido=" + apellido + ", nombres=" + nombres + ", dni=" + dni
				+ ", getNroCuenta()=" + getNroCuenta() + ", toString()=" + super.toString() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + "]";
	}*/
	
	

}
