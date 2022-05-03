package datos;

public class Persona {
	
	private int id;
	private String nroCuenta;
	
	public Persona() {
		super();
	}

	public Persona(String nroCuenta) {
		super();
		this.nroCuenta = nroCuenta;
	}

	public int getId() {
		return id;
	}

	protected void setId(int id) {
		this.id = id;
	}

	public String getNroCuenta() {
		return nroCuenta;
	}

	public void setNroCuenta(String nroCuenta) {
		this.nroCuenta = nroCuenta;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nroCuenta=" + nroCuenta + "]";
	}
	
	
	

}
