package dao;

import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Propiedad;

public class PropiedadDao {
	private static Session session;
	private Transaction tx;
	
	public void iniciaOperacion() {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	public void manejaExcepcion(HibernateException he) throws HibernateException{
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso de datos");
	}
	
	@SuppressWarnings("unchecked")
	public List<Propiedad> traerPropiedad(){
		List<Propiedad> aux = null;
		try {
			iniciaOperacion();
			aux = session.createQuery("from Propiedad").list();
		}finally {
			session.close();
		}
		
		return aux;
	}

	@SuppressWarnings("unchecked")
	public List<Propiedad> traerPropiedad(boolean tieneAscensor){
		List<Propiedad> aux = null;
		try {
			iniciaOperacion();
			aux = session.createQuery("From Departamento d where tieneAscensor="+tieneAscensor).list();
		}finally {
			session.close();
		}
		return aux;
	}

}
