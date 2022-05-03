package datos;

public class Cliente {
	private int idCliente;
	private String Apellido;
	private String nombre;
	private String email;
	public Cliente() {
		super();
	}
	public Cliente(String apellido, String nombre, String email) {
		super();
		Apellido = apellido;
		this.nombre = nombre;
		this.email = email;
	}
	public int getIdCliente() {
		return idCliente;
	}
	protected void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", Apellido=" + Apellido + ", nombre=" + nombre + ", email=" + email
				+ "]";
	}
	
}
