package datos;

public class Producto {
	private int idProducto;
	private String codigo;
	private String producto;
	private double precio;
	public Producto() {
		super();
	}
	public Producto(String codigo, String producto, double precio) {
		super();
		this.codigo = codigo;
		this.producto = producto;
		this.precio = precio;
	}
	public int getIdProducto() {
		return idProducto;
	}
	protected void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", codigo=" + codigo + ", producto=" + producto + ", precio="
				+ precio + "]";
	}
	
	
	

}
