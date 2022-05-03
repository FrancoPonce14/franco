package dao;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Almacen;
import datos.Pedido;
import datos.Producto;

public class StockDao {
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
	
	public Almacen traerAlmacen(Producto pe) {
		Almacen a = null;
		try {
			iniciaOperacion();
			String hql="from Almacen s inner join fetch s.producto p where p.idProducto="+pe.getIdProducto();
			a = (Almacen) session.createQuery(hql).uniqueResult();	
			Hibernate.initialize(a.getLotes());
		}finally {
			session.close();
		}
		return a;
		
	}
	public Pedido traerPedido(Producto producto){
		Pedido p = null;
		try {
			iniciaOperacion();
			String hql="from Pedido s inner join fetch s.producto p where p.idProducto="+producto.getIdProducto();
			p = (Pedido) session.createQuery(hql).uniqueResult();	
			Hibernate.initialize(p.getNotasPedidos());
		}finally {
			session.close();
		}
		return p;
	}
	public int calcularCantidadAPedir(Producto producto) {
		int n = 0;
		Pedido p = traerPedido(producto);
		n = p.calcularCantidadAPedir();
		return n;
	}
}
