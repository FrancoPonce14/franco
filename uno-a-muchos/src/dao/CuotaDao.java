package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


import datos.Cuota;
import datos.Prestamo;

public class CuotaDao {
	//private static CuotaDao instancia;
	private static Session session;
	private Transaction tx;
	
	public void iniciaOperacion() {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	public void manejaExcepcion(HibernateException he) throws HibernateException{
		tx.rollback();
		throw new HibernateException("Error en la capa de datos --> "+he);
	}
	/*public static CuotaDao getInstancia() {
		if(instancia == null) {
			instancia = new CuotaDao();
		}
		return instancia;
	}*/
	
	public int agregar(Cuota cuota) throws HibernateException{
		int id=0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(cuota).toString());
			tx.commit();
		}catch(HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}finally {
			session.close();
		}
		return id;
	}
	public Cuota traer(long idCuota) {
		Cuota aux = null;
		try {
			iniciaOperacion();
			String hql = "from Couta c inner join fetch c.prestamo where c.idCuota="+idCuota;
			aux = (Cuota) session.createQuery(hql).uniqueResult();
		}finally {
			session.close();
		}
		return aux;
	}
	@SuppressWarnings("unchecked")
	public List<Cuota> traer(Prestamo p){
		List<Cuota> aux = null;
		try {
			iniciaOperacion();
			String hql = "from Cuota c inner join fetch c.prestamo p where p.idPrestamo="+p.getIdPrestamo();
			aux = session.createQuery(hql).list();
		}finally {
			session.close();
		}
		return aux;
	}
	public void Actualizar(Cuota c) throws HibernateException{
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
	public void Eliminar(Cuota c) throws HibernateException{
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

}
