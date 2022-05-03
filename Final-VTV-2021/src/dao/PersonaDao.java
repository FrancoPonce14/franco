package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Contribuyente;
import datos.Inspector;

public class PersonaDao {
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
	
	public Contribuyente traerContribuyente (int idPersona) {
		Contribuyente c = null;
		try {
			iniciaOperacion();
			c = (Contribuyente) session.createQuery("from Contribuyente c where idContribuyente="+idPersona).uniqueResult();
		}finally {
			session.close();
		}
		
		return c;
	}
	public Inspector traerInspector (int idPersona) {
		Inspector i = null;
		try {
			iniciaOperacion();
			i = (Inspector) session.createQuery("from Inspector i where idInspector="+idPersona).uniqueResult();
		}finally {
			session.close();
		}
		return i;
	}

}
