package com.soleus.hibernate;


import java.util.ArrayList;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.soleus.models.RoomRequest;
import com.soleus.models.UserModel;


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
	
	public ArrayList<RoomRequest> getRequestList(UserModel user) {
		
		Session s = sessionFactory.openSession();
    	Query q = s.createQuery("FROM RoomRequest WHERE requestDepartment=:userDepartment");
    	q.setParameter("userDepartment", user.getDepartment());
        ArrayList<RoomRequest> requestList = (ArrayList<RoomRequest>) q.list();        
        return requestList;
	} // end getRequestList
}
