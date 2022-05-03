package dao;

import java.time.LocalDate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Localidad;
import datos.Lugar;
import datos.Ubicacion;

public class LugarDao {
	private static Session session;
	private Transaction tx;

	public void iniciaOperacion() throws HibernateException{
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	public void manejaExcepcion(HibernateException he) throws HibernateException{
		tx.rollback();
		throw new HibernateException("Error en la capa de acceso de datos --> "+he);
	}
	
	public Ubicacion traerUbicacion(int id) {
		Lugar l = null; 
		Ubicacion u = null;
		try {
			iniciaOperacion();
			l = session.get(Lugar.class, id);
			if(l instanceof Ubicacion) {
				u = (Ubicacion) l;
			}
		}finally {
			session.close();
		}
		
		return u;
	}
	public Localidad traerLocalidad(int id) {
		Lugar l = null; 
		Localidad lo = null;
		try {
			iniciaOperacion();
			l = session.get(Lugar.class, id);
			if(l instanceof Localidad) {
				lo = (Localidad) l;
			}
		}finally {
			session.close();
		}
		
		return lo;
	}
	public boolean ingresoHabilitado(int idPermiso, LocalDate fecha) {
		Lugar l = null;
		try {
			iniciaOperacion();
			l = session.get(Lugar.class, idPermiso);
		}finally{
			session.close();
		}
		return l.ingresoHabilitado(idPermiso, fecha);
	}
    public boolean ingresoHabilitado(int idLugar, int idPermiso, LocalDate fecha) {
    	Lugar objeto = null;		
	try {
		iniciaOperacion();
		objeto = (Lugar) session.get(Lugar.class, idLugar);
	} finally {
		session.close();
	}
	return objeto.ingresoHabilitado(idPermiso, fecha);
}

}
