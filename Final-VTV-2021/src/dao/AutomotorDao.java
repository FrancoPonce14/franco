package dao;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Automotor;

public class AutomotorDao {
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
	public Automotor traerAutomotor (String dominio) {
		Automotor a = null;
		try {
			iniciaOperacion();
			a = (Automotor) session.createQuery("from Automotor a where dominio='"+dominio+"'").uniqueResult();
			Hibernate.initialize(a.getContribuyente());
		}finally {
			session.close();
		}
		return a;
	}

}
