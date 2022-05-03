package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Dosis;
import datos.Persona;

public class DosisDao {
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
	@SuppressWarnings("unchecked")
	public List<Dosis> traerDosis(Persona persona){
		List<Dosis> aux = null;
		try {
			iniciaOperacion();
			String hql = "from Dosis d inner join fetch d.persona p where p.idPersona="+persona.getIdPersona();
			//String hql = "from Dosis d";
			aux = session.createQuery(hql).list();
			for(Dosis d : aux) {
				Hibernate.initialize(d.getPersona());
				Hibernate.initialize(d.getVacuna());
			}
		}finally {
			session.close();
		}
		
		return aux;
	}
	@SuppressWarnings("unchecked")
	public List<Dosis> traerDosis(){
		List<Dosis> aux = null;
		try {
			iniciaOperacion();
			aux = session.createQuery("from Dosis d").list();
			for(Dosis d : aux) {
				Hibernate.initialize(d.getPersona());
				Hibernate.initialize(d.getVacuna());
			}
			
			
		}finally {
			session.close();
		}
		return aux;
	}
}
