package datos;

import java.time.LocalDate;

public class Lote {
	private int idLote;
	private LocalDate fecha;
	private int cantInicial;
	private int cantExistente;
	public Lote() {
		super();
	}
	public Lote(LocalDate fecha, int cantInicial, int cantExistente) {
		super();
		this.fecha = fecha;
		this.cantInicial = cantInicial;
		this.cantExistente = cantExistente;
	}
	public int getIdLote() {
		return idLote;
	}
	protected void setIdLote(int idLote) {
		this.idLote = idLote;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public int getCantInicial() {
		return cantInicial;
	}
	public void setCantInicial(int cantInicial) {
		this.cantInicial = cantInicial;
	}
	public int getCantExistente() {
		return cantExistente;
	}
	public void setCantExistente(int cantExistente) {
		this.cantExistente = cantExistente;
	}
	@Override
	public String toString() {
		return "Lote [idLote=" + idLote + ", fecha=" + fecha + ", cantInicial=" + cantInicial + ", cantExistente="
				+ cantExistente + "]";
	}

}
