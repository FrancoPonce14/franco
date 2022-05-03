package dao;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Persona;

public class PersonaDao {
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
	
	public Persona traerPersona(long documento) {
		Persona aux = null;
		try {
			iniciaOperacion();
			aux = (Persona) session.createQuery("from Persona p where p.documento="+documento).uniqueResult();
		}finally {
			session.close();
		}
		return aux;
	}
}
