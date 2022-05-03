package dao;


import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Espacio;

public class EspacioDao {
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
	@SuppressWarnings("unchecked")
	public List<Espacio> traer() {
		List<Espacio> e = null;
		try {
			iniciaOperacion();
			e = session.createQuery("from Espacio").list();
			for(Espacio ef : e) {
				Hibernate.initialize(ef.getAula());
				Hibernate.initialize(ef.getAula().getEdificio());
			}
		}finally {
			session.close();
		}
		
		return e;
	}
	public int agregar(Espacio espacio) {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(espacio).toString());
			tx.commit();
		}catch(HibernateException he) {
			throw he;
		}finally {
			session.close();
		}
		
		return id;
	}
	
	
	
	
	
	
}
