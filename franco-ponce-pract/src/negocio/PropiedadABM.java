package negocio;


import java.util.List;

import dao.PropiedadDao;
import datos.Propiedad;

public class PropiedadABM {
	PropiedadDao dao = new PropiedadDao();
	
	public List<Propiedad> traerPropiedad(){
		return dao.traerPropiedad();
	}
	
	public List<Propiedad> traerPropiedad(boolean tieneAscensor){
		return dao.traerPropiedad(tieneAscensor);
	}


}
