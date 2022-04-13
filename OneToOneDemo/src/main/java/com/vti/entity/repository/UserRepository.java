package com.vti.entity.repository;

import org.hibernate.Session;

import com.vti.entity.User;
import com.vti.utils.HibernateUtils;

public class UserRepository {

	private HibernateUtils hibernateUtils;
	
	public UserRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}
	
	public User getById(Integer userId) {
		Session session = null;

		try {
			session = hibernateUtils.openSession();
			User user = session.get(User.class, userId);

			return user;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public User create(User user) {
		Session session = null;

		try {
			session = hibernateUtils.openSession();
			session.beginTransaction();

			session.save(user);
			
			session.getTransaction().commit();
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
}
