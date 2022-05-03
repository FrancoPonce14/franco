package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Automotor;
import datos.Inspeccion;

public class InspeccionDao {
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
	public Inspeccion traerInspeccion (int idInspeccion) {
		Inspeccion i = null;
		try {
			iniciaOperacion();
			i = (Inspeccion) session.createQuery("from Inspeccion i where idInspeccion="+idInspeccion).uniqueResult();
			Hibernate.initialize(i.getAutomotor());
			Hibernate.initialize(i.getInspector());
		}finally {
			session.close();
		}
		
		return i;
	}
	@SuppressWarnings("unchecked")
	public List<Inspeccion> traerInspeccion (Automotor automotor){
		List<Inspeccion> i = null;
		try {
			iniciaOperacion();
			i =  session.createQuery("from Inspeccion i inner join fetch i.automotor a where a.idAutomotor="+automotor.getIdAutomotor()).list();
			for(Inspeccion t: i) {
				 Hibernate.initialize(t.getAutomotor());
			     Hibernate.initialize(t.getInspector());
			}
		}finally {
			session.close();
		}
		return i;
	}
}
