package dao;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Aula;

public class AulaDao {
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
	public Aula traer(int id) {
		Aula a = null;
		try {
			iniciaOperacion();
			a = (Aula) session.get(Aula.class, id);
			Hibernate.initialize(a.getEdificio());
		}finally {
			session.close();
		}
		return a;
	}

}
