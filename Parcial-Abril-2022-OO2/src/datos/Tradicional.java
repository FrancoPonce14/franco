package datos;

public class Tradicional extends Aula{
	private int cantBancos;
	private char pizarron;
	private boolean tieneProyector;
	
	public Tradicional() {}

	public Tradicional(int cantBancos, char pizarron, boolean tieneProyector) {
		super();
		this.cantBancos = cantBancos;
		this.pizarron = pizarron;
		this.tieneProyector = tieneProyector;
	}

	public int getCantBancos() {
		return cantBancos;
	}

	public void setCantBancos(int cantBancos) {
		this.cantBancos = cantBancos;
	}

	public char getPizarron() {
		return pizarron;
	}

	public void setPizarron(char pizarron) {
		this.pizarron = pizarron;
	}

	public boolean isTieneProyector() {
		return tieneProyector;
	}

	public void setTieneProyector(boolean tieneProyector) {
		this.tieneProyector = tieneProyector;
	}

	@Override
	public String toString() {
		return "Tradicional [cantBancos=" + cantBancos + ", pizarron=" + pizarron + ", tieneProyector=" + tieneProyector
				+ ", id=" + id + ", numero=" + numero + ", edificio=" + edificio + "]";
	}
	

}
