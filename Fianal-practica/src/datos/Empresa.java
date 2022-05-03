package datos;

public class Empresa extends Persona{
	private int idEmpresa;
	private String razonSocial;

	public Empresa() {
		super();
	}

	public Empresa(String nroCuenta, String razonSocial) {
		super(nroCuenta);
		this.razonSocial = razonSocial;
	}

	public int getIdEmpresa() {
		return idEmpresa;
	}

	protected void setId(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	
	@Override
	public String toString() {
		return super.toString() + " Empresa [idEmpresa=" + this.getId() + ", nroCuenta=" + this.getNroCuenta() + ", razonSocial=" + razonSocial + "]";
	}

	/*@Override
	public String toString() {
		return "Empresa [id=" + id + ", razonSocial=" + razonSocial + ", getNroCuenta()=" + getNroCuenta()
				+ ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}*/
	
	
	
	
	
	

}
