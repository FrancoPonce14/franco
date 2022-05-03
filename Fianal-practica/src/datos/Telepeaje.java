package datos;

import java.time.LocalDate;
import java.time.LocalTime;

import funciones.Funciones;

public class Telepeaje {
	private int id;
	private LocalDate fecha;
	private LocalTime hora;
	private double precio;
	private Rodado rodado;
	
	public Telepeaje(){}

	public Telepeaje(LocalDate fecha, LocalTime hora, double precio, Rodado rodado) {
		super();
		this.fecha = fecha;
		this.hora = hora;
		this.precio = precio;
		this.rodado = rodado;
	}

	public int getId() {
		return id;
	}

	protected void setId(int id) {
		this.id = id;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Rodado getRodado() {
		return rodado;
	}

	public void setRodado(Rodado rodado) {
		this.rodado = rodado;
	}

	@Override
	public String toString() {
		return "Telepeaje [id=" + id + ", fecha=" + fecha + ", hora=" + hora + ", precio=" + precio + ", rodado="
				+ rodado + "]";
	}
	
	public double calcularRecargo(double porcentajeRecargo) {
		double total = 0;

		if(Funciones.esDiaHabil(fecha) && hora.getHour() >= 7 && hora.getHour() <= 11 ||  hora.getHour() >= 17 && hora.getHour() <= 19) {
			total = (precio * porcentajeRecargo)/100;
			
		}
		
		return total;
	}
	
	

}
