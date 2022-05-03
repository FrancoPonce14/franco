package dao;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Rodado;
import datos.Telepeaje;

public class TelepeajeDao {
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
	public List<Telepeaje> traerTelepeaje(Rodado rodado){
		List<Telepeaje> aux = null;
		try {
			iniciaOperacion();
			String hql = "from Telepeaje t inner join fetch t.rodado r where r.id="+rodado.getId();
			aux = session.createQuery(hql).list();
			for(Telepeaje t : aux) {
				Hibernate.initialize(t.getRodado().getPersona());
			}
		}finally {
			session.close();
		}
		
		return aux;
	}
	@SuppressWarnings("unchecked")
	public List<Telepeaje> traerTelepeaje(String dominio){
		List<Telepeaje> aux = null;
		try {
			iniciaOperacion();
			aux = session.createQuery("from Telepeaje t inner join fetch t.rodado r where r.dominio=:dominio").setParameter("dominio", dominio).list();
			for(Telepeaje t : aux) {
				Hibernate.initialize(t.getRodado().getPersona());
			}
		}finally {
			session.close();
		}
		return aux;
	}

	@SuppressWarnings("unchecked")
	public double cerrarCaja(LocalDate fecha) {
		double t = 0;
		List<Telepeaje> traerPorFecha = null;
		try {
			iniciaOperacion();
			traerPorFecha =  session.createQuery("from Telepeaje t where t.fecha =: fecha").setParameter("fecha", fecha).list();
			for(Telepeaje tt : traerPorFecha) {
				//Hibernate.initialize(tt.getRodado());
				//Hibernate.initialize(tt.getRodado().getPersona());
				t = t + tt.getPrecio();
			}
		}finally {
			session.close();
		}
		return t;
	}
}
