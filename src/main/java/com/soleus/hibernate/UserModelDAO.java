package com.soleus.hibernate;

import java.util.ArrayList;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import com.soleus.models.UserModel;

public class UserModelDAO {

	private UserModel user;
	private static SessionFactory sessionFactory;
	private Transaction transaction;
	private String housekeepingDepartment = "HOUSEKEEPING";
	private String maintenanceDepartment = "MAINTENANCE";
	private String adminDepartment = "ADMIN";
	

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
		} else if (user.getUser().equals(room) && user.getPassword().equals(password)) {
			s.close();
			return true;
		} else
			return false;

	} // end checkUserCredentials

	public boolean checkUserName(String room, String name) {
		Session s = sessionFactory.openSession();
		user = (s.get(UserModel.class, room));
		if (user == null) {
			return false;
		} else if (user.getUser().equals(room) && user.getName().equals(name)) {
			s.close();
			return true;
		} else
			return false;
	} // end updatePassword
	
	public boolean updateUserPassword(String room, String password) {
		Session s = sessionFactory.openSession();
        Transaction t = s.beginTransaction();
        
        user = (s.get(UserModel.class, room));
        if (user.getDepartment().equals(maintenanceDepartment) || 
        		user.getDepartment().equals(housekeepingDepartment) ||
        		user.getDepartment().equals(adminDepartment)) {
        	return false;
        } else {
        	user.setPassword(password);
            s.update(user);
            t.commit();
            s.close();
        	return true;
        }        
	}
	
	public UserModel getUserModel(String room) {
		Session s = sessionFactory.openSession();
		UserModel userLogged = s.get(UserModel.class, room);
		s.close();
		return (userLogged);
	} // end getUserModel

	public ArrayList<UserModel> getUserList() {

		Session s = sessionFactory.openSession();
		Query q;
      	q = s.createQuery("FROM UserModel");
		ArrayList<UserModel> userList = (ArrayList<UserModel>) q.list();
		return userList;
	} // end getUserList

	public void deleteUserModel(UserModel userToDelete) {
		
		Session s = sessionFactory.openSession();
		transaction = s.getTransaction();
        transaction.begin();

		UserModel userData = s.get(UserModel.class, userToDelete.getUser());
		s.delete(userData);
		transaction.commit();
		s.close();
	} // end deleteUserModel
	
	public void saveUser(UserModel userToSave) {
		
		Session s = sessionFactory.openSession();
        Transaction t = s.beginTransaction();
        
        if (exists(userToSave)) {
        	updateUser(userToSave);
        } else {

            s.save(userToSave);
        }
        
        t.commit();
        s.close();
	} // end saveUser
	
	public void updateUser(UserModel userToUpdate) {
		Session s = sessionFactory.openSession();
        Transaction t = s.beginTransaction();
        s.update(userToUpdate);
        t.commit();
        s.close();
	} // end updateUser

	public UserModel getUser(UserModel userToCheck) {
		
		Session s = sessionFactory.openSession();
		UserModel userToSend = s.get(UserModel.class, userToCheck.getUser());
        s.close();
		
		return userToSend;
	}
	

	public boolean exists(UserModel userToSave) {
		Session s = sessionFactory.openSession();
		Query q;
		q = s.createQuery("select 1 from UserModel where user = :key");
        q.setParameter("key", userToSave.getUser() );
        return (q.uniqueResult() != null);
	}
	
	


}


