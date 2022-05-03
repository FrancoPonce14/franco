package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Cliente;
import datos.Evento;


public class ClienteDao {
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
	public Cliente traer(long idCliente) {
		Cliente traer = null;
		try {
			iniciaOperacion();
			traer = session.get(Cliente.class, idCliente);
		}catch(HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}finally {
			session.close();
		}
		
		return traer;
		
	}
	public int agregar(Cliente c) {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(c).toString());
			tx.commit();
		}catch(HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}finally {
			session.close();
		}
		
		return id;
	}
	public void actualizar(Cliente c) {
		try {
			iniciaOperacion();
			session.update(c);
			tx.commit();
		}catch(HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}finally {
			session.close();
		}
	}
	public void eliminar(Cliente c) {
		try {
			iniciaOperacion();
			session.delete(c);
			tx.commit();
		}catch(HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}finally {
			session.close();
		}
	}
	@SuppressWarnings("unchecked")
	public List<Cliente> traer(){
		List<Cliente> aux = null;
		try {
			iniciaOperacion();
			String hql = "from Cliente c order by c.apellido asc, c.nombre asc";
			aux = session.createQuery(hql).list();
		}catch(HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}finally {
			session.close();
		}
		
		return aux;
	}
	public Cliente traerClienteyEventos(long idCliente) {
		Cliente aux = null;
		try {
			iniciaOperacion();
			String hql = "from Cliente c where c.idCliente="+idCliente;
			aux = (Cliente) session.createQuery(hql).uniqueResult();
			Hibernate.initialize(aux.getEventos());
		}catch(HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}finally	{
			session.close();
		}
		
		return aux;
	}
	public boolean agregarEvento(Evento e, Cliente c) {
		Cliente cliente = this.traerClienteyEventos(c.getIdCliente());
		cliente.agregar(e);
		actualizar(cliente);
		return true;
	}
	public boolean eliminarEvento(Evento e, Cliente c) {
		Cliente cliente = this.traerClienteyEventos(c.getIdCliente());
		for(Evento e1 : cliente.getEventos()) {
			if(e1.getIdEvento() == e.getIdEvento() ) {
				cliente.eliminar(e);
			}
		}
		actualizar(cliente);
		return true;
	}


}
