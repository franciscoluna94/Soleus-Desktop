package com.soleus.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.soleus.models.UserModel;


public class UserModelDAO {
	
	private UserModel user;
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

	public boolean checkUserCredentials(String room, String password) {
		
		Session s = sessionFactory.openSession();
		user = (s.get(UserModel.class, room));
		if (user == null) {
			return false;
		} else if (user.getUser().equals(room) && user.getPassword().equals(password)){
			s.close();
			return true;
		} else
			return false;

	} // end checkUserCredentials
	
    public UserModel getUserModel(String room){
        Session s = sessionFactory.openSession();
        UserModel userLogged = s.get(UserModel.class, room);
        s.close();
        return(userLogged);
    } // getUserModel

}
