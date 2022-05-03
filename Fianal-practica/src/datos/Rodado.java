package datos;

public class Rodado {
	private int id;
	private Persona persona;
	private String dominio;
	private int categoria;
	
	public Rodado() {
		super();
	}

	public Rodado(Persona persona, String dominio, int categoria) {
		super();
		this.persona = persona;
		this.dominio = dominio;
		this.categoria = categoria;
	}

	public int getId() {
		return id;
	}

	protected void setId(int id) {
		this.id = id;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public String getDominio() {
		return dominio;
	}

	public void setDominio(String dominio) {
		this.dominio = dominio;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Rodado [id=" + id + ", persona=" + persona + ", dominio=" + dominio + ", categoria=" + categoria + "]";
	}
	
	

}
