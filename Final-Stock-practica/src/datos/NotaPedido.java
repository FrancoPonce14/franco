package datos;

import java.time.LocalDate;

public class NotaPedido {
	private int idNotaPedido;
	private LocalDate fecha;
	private int cantidad;
	private Cliente cliente;
	private boolean entregado;
	public NotaPedido() {
		super();
	}
	public NotaPedido(LocalDate fecha, int cantidad, Cliente cliente, boolean entregado) {
		super();
		this.fecha = fecha;
		this.cantidad = cantidad;
		this.cliente = cliente;
		this.entregado = entregado;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public boolean isEntregado() {
		return entregado;
	}
	public void setEntregado(boolean entregado) {
		this.entregado = entregado;
	}
	public int getIdNotaPedido() {
		return idNotaPedido;
	}
	protected void setIdNotaPedido(int idNotaPedido) {
		this.idNotaPedido = idNotaPedido;
	}
	@Override
	public String toString() {
		return "NotaPedido [idNotaPedido=" + idNotaPedido + ", fecha=" + fecha + ", cantidad=" + cantidad + ", cliente="
				+ cliente + ", entregado=" + entregado + "]";
	}
	
	
	
}
