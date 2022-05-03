package datos;

public abstract class Propiedad {
	protected int idPropiedad;
	protected double precioBase;
	protected String direccion;
	public Propiedad() {
		super();
	}
	public Propiedad(double precioBase, String direccion) {
		super();
		this.precioBase = precioBase;
		this.direccion = direccion;
	}
	public int getIdPropiedad() {
		return idPropiedad;
	}
	protected void setIdPropiedad(int idPropiedad) {
		this.idPropiedad = idPropiedad;
	}
	public double getPrecioBase() {
		return precioBase;
	}
	public void setPrecioBase(double precioBase) {
		this.precioBase = precioBase;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	@Override
	public String toString() {
		return "\nPropiedad [idPropiedad=" + idPropiedad + ", precioBase=" + precioBase + ", direccion=" + direccion
				+ "]";
	}
	public abstract double precioPorNoche();

}
