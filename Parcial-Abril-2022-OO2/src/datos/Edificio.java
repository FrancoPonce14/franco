package datos;

import java.util.Set;

public class Edificio {
	private int id;
	private String edificio;
	private Set<Aula> aulas;
	
	public Edificio() {}

	public Edificio(String edificio) {
		super();
		this.edificio = edificio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEdificio() {
		return edificio;
	}

	public void setEdificio(String edificio) {
		this.edificio = edificio;
	}

	public Set<Aula> getAulas() {
		return aulas;
	}

	public void setAulas(Set<Aula> aulas) {
		this.aulas = aulas;
	}


	public String toString2() {
		return "Edificio [id=" + id + ", edificio=" + edificio + ", aulas=" + aulas + "]";
	}
	@Override
	public String toString() {
		return "Edificio [id=" + id + ", edificio=" + edificio + "]";
	}
	

	
	
}
