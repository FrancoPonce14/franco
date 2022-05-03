package negocio;

import dao.ProductoDao;
import datos.Producto;

public class ProductoHBM {
	ProductoDao dao = new ProductoDao();
	
	public Producto traerProducto(String codigo) {
		return dao.traerProducto(codigo);
	}

}
