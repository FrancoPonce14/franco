package datos;

public class Casa extends Propiedad{
	private boolean tienePatio;

	public Casa() {
		super();
	}

	public Casa(boolean tienePatio) {
		super();
		this.tienePatio = tienePatio;
	}

	public boolean isTienePatio() {
		return tienePatio;
	}

	public void setTienePatio(boolean tienePatio) {
		this.tienePatio = tienePatio;
	}

	@Override
	public String toString() {
		return "\nCasa [tienePatio=" + tienePatio + ", idPropiedad=" + idPropiedad + ", precioBase=" + precioBase
				+ ", direccion=" + direccion + "]";
	}
	public double precioPorNoche() {
		double n = 0;
		if(this.tienePatio) {
			n = this.precioBase + (this.precioBase * 0.1);
		}else {
			n = this.precioBase;
		}	
		return n;
	}
	

}
