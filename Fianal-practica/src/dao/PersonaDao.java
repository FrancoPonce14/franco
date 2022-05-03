package dao;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Abonado;
import datos.Empresa;

public class PersonaDao {
	private static Session session;
	private Transaction tx;
	
	public void iniciaOperacion() {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	public void manejaExcepcion(HibernateException he) throws HibernateException{
		tx.rollback();
		throw new HibernateException("Error en la capa de acceso de datos --> "+he);
	}
	
	@SuppressWarnings("unchecked")
	public List<Empresa> traerEmpresa(){
		List<Empresa> aux = null;
		try {
			iniciaOperacion();
			aux = session.createQuery("from Empresa").list();
		}finally {
			session.close();
		}
		return aux;
	}
	@SuppressWarnings("unchecked")
	public List<Abonado> traerAbonado(){
		List<Abonado> aux = null;
		try {
			iniciaOperacion();
			aux = session.createQuery("from Abonado").list();
		}finally {
			session.close();
		}
		return aux;
	}
	public Abonado traerAbonado(long dni) {
		Abonado a = null;
		try {
			iniciaOperacion();
			a = (Abonado) session.createQuery("from Abonado c where c.dni="+dni).uniqueResult();
		}finally {
			session.close();
		}
		return a;
	}

}
