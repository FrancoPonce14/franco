package datos;

import java.time.LocalDate;

import negocio.PermisoABM;

public class Ubicacion extends Lugar{
	
	private double longitud;
	private double latitud;
	
	public Ubicacion() {}

	public Ubicacion(String lugar, double longitud, double latitud) {
		super(lugar);
		this.longitud = longitud;
		this.latitud = latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	@Override
	public String toString() {
		return "Ubicacion [longitud=" + longitud + ", latitud=" + latitud + ", idLugar=" + idLugar + ", lugar=" + lugar
				+ "]";
	}

	@Override
	public boolean ingresoHabilitado(int idPermiso, LocalDate dia) {
		PermisoABM permiso = new PermisoABM();
		Permiso p = permiso.traerPermiso(idPermiso);
		return dia.isEqual(p.getFecha());
	}	

}
