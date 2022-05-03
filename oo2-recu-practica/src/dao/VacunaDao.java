package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Vacuna;

public class VacunaDao {
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
	public List<Vacuna> traerVacuna(){
		List<Vacuna> aux = null;
		try {
			iniciaOperacion();
			aux = session.createQuery("from Vacuna v").list();
		}finally {
			session.close();
		}
		return aux;
	}
	public Vacuna traerVacuna (long codigo) throws HibernateException{
		Vacuna objeto = null;
		try {
			iniciaOperacion();
			String hql = "from Vacuna v where v.codigo="+codigo;
			objeto = (Vacuna) session.createQuery(hql).uniqueResult();  
		}finally {
			session.close();
		}
		return objeto;

	}
	public Vacuna traerVacuna(int id) {
		Vacuna aux = null;
		try {
			iniciaOperacion();
			aux = session.get(Vacuna.class, id);
		}finally {
			session.close();
		}
		return aux;
	}

}
