package com.soleus.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.soleus.models.RoomRequest;

public class RoomRequestDAO {

	private static SessionFactory sessionFactory;

	static {
		try {

			sessionFactory = new Configuration().configure().buildSessionFactory();
			System.out.println("Conexión establecida");
		} catch (Exception ex) {
			System.out.println("Error iniciando Hibernate");
			System.out.println(ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public void saveRequest(RoomRequest request) {
		Session s = sessionFactory.openSession();
        Transaction t = s.beginTransaction();
        s.save(request);
        t.commit();
        s.close();
	}
}
