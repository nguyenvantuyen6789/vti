package com.vti.entity.repository;

import org.hibernate.Session;

import com.vti.entity.Address;
import com.vti.utils.HibernateUtils;

public class AddressRepository {

	private HibernateUtils hibernateUtils;
	
	public AddressRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}
	
	public Address getById(Integer addressId) {
		Session session = null;
		
		try {
			session = hibernateUtils.openSession();
			
			Address address = session.get(Address.class, addressId);
			
			return address;
		} catch (Exception e) {
			e.printStackTrace();
			
			return null;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public Address create(Address address) {
		Session session = null;

		try {
			session = hibernateUtils.openSession();
			session.beginTransaction();

			session.save(address);
			
			session.getTransaction().commit();
			
			return address;
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
