package datos;

import java.util.Set;

public class Pedido extends Stock{
	private int idPedido;
	private Set<NotaPedido> notasPedidos;

	public Pedido() {
		super();
	}
	public Pedido(Producto producto) {
		super(producto);
	}
	public Set<NotaPedido> getNotasPedidos() {
		return notasPedidos;
	}
	public void setNotasPedidos(Set<NotaPedido> notasPedidos) {
		this.notasPedidos = notasPedidos;
	}
	public int getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}
    @Override
    public String toString() {
        return "{" +
            " notasPedidos='" + getNotasPedidos() + "'" +
            "}";
    }
   public int calcularCantidadAPedir(){
    	int n = 0;
    	for(NotaPedido nota : notasPedidos) {
    		if(nota.isEntregado()) {
    			n++;
    		}
    	}
    	
    	return n;
    }
	

}
