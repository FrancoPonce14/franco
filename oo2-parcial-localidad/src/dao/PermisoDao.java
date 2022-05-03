package dao;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Permiso;

public class PermisoDao {
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
	
	public Permiso traerPermiso(int id) {
		Permiso aux = null;
		try {
			iniciaOperacion();
			aux = session.get(Permiso.class, id);
			//aux = (Permiso) session.createQuery("from Permiso p where idPermiso="+id).uniqueResult();
			Hibernate.initialize(aux.getPersona());
			Hibernate.initialize(aux.getRodado());
		}finally {
			session.close();
		}
		return aux;
	}

}
