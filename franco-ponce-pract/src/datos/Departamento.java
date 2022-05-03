package datos;

public class Departamento extends Propiedad{
	private int cantidadAmbientes;
	private int nroPiso;
	private boolean tieneAscensor;
	public Departamento() {
		super();
	}
	public Departamento(int cantidadAmbientes, int nroPiso, boolean tieneAscensor) {
		super();
		this.cantidadAmbientes = cantidadAmbientes;
		this.nroPiso = nroPiso;
		this.tieneAscensor = tieneAscensor;
	}
	public int getCantidadAmbientes() {
		return cantidadAmbientes;
	}
	public void setCantidadAmbientes(int cantidadAmbientes) {
		this.cantidadAmbientes = cantidadAmbientes;
	}
	public int getNroPiso() {
		return nroPiso;
	}
	public void setNroPiso(int nroPiso) {
		this.nroPiso = nroPiso;
	}
	public boolean isTieneAscensor() {
		return tieneAscensor;
	}
	public void setTieneAscensor(boolean tieneAscensor) {
		this.tieneAscensor = tieneAscensor;
	}
	@Override
	public String toString() {
		return "\nDepartamento [cantidadAmbientes=" + cantidadAmbientes + ", nroPiso=" + nroPiso + ", tieneAscensor="
				+ tieneAscensor + ", idPropiedad=" + idPropiedad + ", precioBase=" + precioBase + ", direccion="
				+ direccion + "]";
	}
	public double precioPorNoche() {
		double n = 0;
		n = this.precioBase+(this.cantidadAmbientes*100);
		return n;
	}
	

}
