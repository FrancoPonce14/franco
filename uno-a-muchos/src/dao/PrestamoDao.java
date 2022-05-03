package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Cliente;
import datos.Prestamo;

public class PrestamoDao {
	private static Session session;
	private Transaction tx;
	
	public void iniciaOperacion() {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	public void manejaExcepcion(HibernateException he) throws HibernateException{
		tx.rollback();
		throw new HibernateException("ERROR: en la capa de acceso de datos --> ",he);
	}
	public int agregar(Prestamo prestamo) throws HibernateException{
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(prestamo).toString());
			tx.commit();
		}catch(HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}finally {
			session.close();
		}
		return id;
	}
	public Prestamo traer(long idPrestamo) {
		Prestamo p = null;
		try {
			iniciaOperacion();
			String hql = "from Prestamo p inner join fetch p.cliente where p.idPrestamo="+idPrestamo;
			p = (Prestamo) session.createQuery(hql).uniqueResult();
		}catch(HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}finally {
			session.close();
		}
		return p;
	}
	@SuppressWarnings("unchecked")
	public List<Prestamo> traer(Cliente c){
		List<Prestamo> aux = null;
		try {
			iniciaOperacion();
			String hql = "from Prestamo p inner join fetch p.cliente c where c.idCliente="+c.getIdCliente();
			aux = session.createQuery(hql).list();
		}finally {
			session.close();
		}
		return aux;
	}
	public void Actualizar(Prestamo p) throws HibernateException{
		try {
			iniciaOperacion();
			session.update(p);
			tx.commit();
		}catch(HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}finally {
			session.close();
		}
	}
	public void Eliminar(Prestamo p) throws HibernateException{
		try {
			iniciaOperacion();
			session.delete(p);
			tx.commit();
		}catch(HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}finally {
			session.close();
		}
	}

}
