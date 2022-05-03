package negocio;

import dao.StockDao;
import datos.Almacen;
import datos.Pedido;
import datos.Producto;

public class StockABM {
	StockDao dao = new StockDao();
	public Almacen traerAlmacen(Producto pe) {
		return dao.traerAlmacen(pe);
	}
	public Pedido traerPedido(Producto producto){
		return dao.traerPedido(producto);
	}
	public int calcularCantidadAPedir(Producto producto) {
		return dao.calcularCantidadAPedir(producto);
	}

}
