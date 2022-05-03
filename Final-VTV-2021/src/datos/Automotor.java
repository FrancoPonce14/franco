package datos;

public class Automotor {
	private int idAutomotor;
	private String dominio;
	private int modelo;
	private String marca;
	private Contribuyente contribuyente;
	
	public Automotor() {}
	
	public Automotor( String dominio, int modelo, String marca, Contribuyente contribuyente) {
		super();
		this.dominio = dominio;
		this.modelo = modelo;
		this.marca = marca;
		this.contribuyente = contribuyente;
		
	}
	
	public Automotor( String dominio, int modelo, String marca) {
		super();
		
		this.dominio = dominio;
		this.modelo = modelo;
		this.marca = marca;
	}

	public int getIdAutomotor() {
		return idAutomotor;
	}

	protected void setIdAutomotor(int idAutomotor) {
		this.idAutomotor = idAutomotor;
	}

	public String getDominio() {
		return dominio;
	}

	public void setDominio(String dominio) {
		this.dominio = dominio;
	}

	public int getModelo() {
		return modelo;
	}

	public void setModelo(int modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Contribuyente getContribuyente() {
		return contribuyente;
	}

	public void setContribuyente(Contribuyente contribuyente) {
		this.contribuyente = contribuyente;
	}

	@Override
	public String toString() {
		return "Automotor [idAutomotor=" + idAutomotor + ", dominio=" + dominio + ", modelo=" + modelo + ", marca="
				+ marca + ", contribuyente=" + contribuyente + "]";
	}
	
	

}
