package dao;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Rodado;

public class RodadoDao {
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
	public Rodado traerRodado(String dominio) {
		Rodado aux = null;
		try {
			iniciaOperacion();
			//aux = (Rodado) session.createQuery("from Rodado o where o.dominio =:dominio").setParameter("dominio", dominio).uniqueResult();
			aux = (Rodado) session.createQuery("from Rodado d where d.dominio='"+dominio+"'").uniqueResult();
			Hibernate.initialize(aux.getPersona());
		}finally {
			session.close();
		}
		return aux;
	}
}
