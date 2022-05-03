package dao;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Edificio;

public class EdificioDao {
	private static Session session;
	private Transaction tx;
	
	public void iniciaOperacion() {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	public void manejaExcepcion(HibernateException he) throws HibernateException{
		tx.rollback();
		throw new HibernateException("Error en la capa de acceso de datos --> "+he);
	}
	
	public Edificio traerEdificioConAulas(int id) {
		Edificio e = null;
		try {
			iniciaOperacion();
			e = (Edificio) session.get(Edificio.class, id);
			Hibernate.initialize(e.getAulas());
		}finally {
			session.close();
		}
		return e;
	}

}
