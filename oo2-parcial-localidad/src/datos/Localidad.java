package datos;

import java.time.LocalDate;

import negocio.PermisoABM;

public class Localidad extends Lugar{
	
	private String codPostal;
	private boolean cumplirCuarentena;
	
	public Localidad() {}

	public Localidad(String lugar, String codPostal, boolean cumplirCuarentena) {
		super(lugar);
		this.codPostal = codPostal;
		this.cumplirCuarentena = cumplirCuarentena;
	}

	public String getCodPostal() {
		return codPostal;
	}

	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}

	public boolean isCumplirCuarentena() {
		return cumplirCuarentena;
	}

	public void setCumplirCuarentena(boolean cumplirCuarentena) {
		this.cumplirCuarentena = cumplirCuarentena;
	}

	@Override
	public String toString() {
		return "Localidad [codPostal=" + codPostal + ", cumplirCuarentena=" + cumplirCuarentena + ", idLugar=" + idLugar
				+ ", lugar=" + lugar + "]";
	}

	@Override
	public boolean ingresoHabilitado(int idPermiso, LocalDate dia) {
		PermisoABM permiso = new PermisoABM();
		Permiso p = permiso.traerPermiso(idPermiso);
        LocalDate fechaVto = LocalDate
                .of(p.getFecha().getYear(), p.getFecha().getMonth(), p.getFecha().getDayOfMonth())
                .plusDays(p.getCantDias());
		
		return  (dia.equals(p.getFecha()) || dia.isAfter(p.getFecha())) &&
                (dia.equals(fechaVto) || dia.isBefore(fechaVto));
	}
	
	
	

}
