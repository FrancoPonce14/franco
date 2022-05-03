package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Producto;

public class ProductoDao {
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
	public Producto traerProducto(String codigo) {
		Producto p =null;
		try {
			iniciaOperacion();
			p = (Producto)session.createQuery("from Producto p where p.codigo='"+codigo+"'").uniqueResult();
		}finally {
			session.close();
		}
		return p;
	}

}
