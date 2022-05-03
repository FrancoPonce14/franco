package test;


import negocio.ProductoHBM;
import negocio.StockABM;

public class Test {

	public static void main(String[] args) {
		ProductoHBM producto = new ProductoHBM();
		StockABM stock = new StockABM();
		
		
		System.out.println(producto.traerProducto("003"));
		System.out.println(stock.traerAlmacen(producto.traerProducto("003")));
		System.out.println(stock.traerAlmacen(producto.traerProducto("003")).cantProductosExistentes());
		System.out.println(stock.traerPedido(producto.traerProducto("003")));
		System.out.println(stock.calcularCantidadAPedir(producto.traerProducto("003")));
		
	}

}
