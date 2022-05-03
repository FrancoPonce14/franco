package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Cliente;

public class ClienteDao {
	private static Session session;
	private Transaction tx;
	
	public void iniciaOperacion() {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.getTransaction();
	}
	public void manejaExcepcion(HibernateException he) throws HibernateException{
		tx.rollback();
		throw new HibernateException("Error en la capa de acceso de datos --> "+he);
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
	public Cliente traer(int idCliente) {
		Cliente aux = null;
		try {
			iniciaOperacion();
			aux =  (Cliente) session.get(Cliente.class, idCliente);
		}finally {
			session.close();
		}
		return aux;
	}
	public Cliente traerClientePorDNI(int dni) {
		Cliente aux = null;
		try {
			iniciaOperacion();
			aux = (Cliente) session.createQuery("from Cliente c where c.dni="+dni).uniqueResult();
		}finally {
			session.close();
		}
		return aux;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> traer(){
		List<Cliente> aux = null;
		try {
			iniciaOperacion();
			String hql="from Cliente";
			aux = session.createQuery(hql).list();
		}finally {
			session.close();
		}
		return aux;
	}

}
