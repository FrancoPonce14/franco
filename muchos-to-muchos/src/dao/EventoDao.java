package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Evento;

public class EventoDao {
	private static Session session;
	private Transaction tx;
	
	public void iniciaOperacion() {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	public void manejaExcepcion(HibernateException he) throws HibernateException{
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso de datos --> "+he);
	}
	
	public int agregar(Evento e) {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(e).toString());
			tx.commit();
		}catch(HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}finally {
			session.close();
		}		
		return id;
	}
	public Evento traer(long idEvento) {
		Evento traer = null;
		try {
			iniciaOperacion();
			traer = session.get(Evento.class, idEvento);
		}catch(HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}finally {
			session.close();
		}
		
		return traer;
	}
	public void actualizar(Evento e) {
		try {
			iniciaOperacion();
			session.update(e);
			tx.commit();
		}catch(HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}finally {
			session.close();
		}
	}
	public void eliminar(Evento e) {
		try {
			iniciaOperacion();
			session.delete(e);
			tx.commit();
		}catch(HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}finally {
			session.close();
		}
	}
	@SuppressWarnings("unchecked")
	public List<Evento> traer(){
		List<Evento> aux = null;
		try {
			iniciaOperacion();
			String hql = "from Evento e order by e.evento asc";
			aux = session.createQuery(hql).list();
		}catch(HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}finally {
			session.close();
		}
		
		return aux;
	}
	public Evento traerEventoYClientes(long idEvento) {
		Evento aux = null;
		try {
			iniciaOperacion();
			String hql = "from evento e where e.idEvento="+idEvento;
			aux = (Evento) session.createQuery(hql).uniqueResult();
			Hibernate.initialize(aux.getClientes());
		}catch(HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}finally	{
			session.close();
		}
		
		return aux;
	}

}
