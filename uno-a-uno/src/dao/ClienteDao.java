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
		tx = session.beginTransaction();
	}
	public void manejaExcepcion(HibernateException he) throws HibernateException{
		tx.rollback();
		throw new HibernateException("ERROR en la capa de datos, "+he);
	}
	
	public int agregar(Cliente objeto) {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(objeto).toString());
			tx.commit();
		}catch(HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}finally {
			session.close();
		}
		return id;
	}
	public void actualizar(Cliente objeto) throws HibernateException {
		try {
			iniciaOperacion();
			session.update(objeto);
			tx.commit();
		}catch(HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}finally {
			session.close();
		}
	}
	public void eliminar(Cliente objeto) throws HibernateException {
		try {
			iniciaOperacion();
			session.delete(objeto);
			tx.commit();
		}catch(HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}finally {
			session.close();
		}
	}
	public Cliente traer(long idCliente) throws HibernateException {
		Cliente c = null;
		try {
			iniciaOperacion();
			c = (Cliente) session.get(Cliente.class, idCliente);
		}finally {
			session.close();
		}
		return c;
	}
	public Cliente traer(int dni) throws HibernateException {
		Cliente c = null;
		try {
			iniciaOperacion();
			String hql = "from Cliente c where c.dni="+dni;
			c = (Cliente) session.createQuery(hql).uniqueResult();
		}finally {
			session.close();
		}
		return c;
	}

	@SuppressWarnings("unchecked")
	public List<Cliente> traer() throws HibernateException {
		List<Cliente> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Cliente c order by c.apellido asc c.nombre asc").list();
		} finally {
			session.close();
		}
		return lista;
	}
	public Cliente traerClienteYContacto(long idCliente) throws HibernateException {
		Cliente c = null;
		try {
			iniciaOperacion();
			String hql = "from Cliente c inner join fetch c.contacto where c.idCliente="+idCliente;
			c = (Cliente) session.createQuery(hql).uniqueResult();
		}finally {
			session.close();
		}
		return c;
	}

}
