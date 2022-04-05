package com.vti;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.vti.entity.Department;

public class App 
{
    public static void main( String[] args ) {
//        new App().save();
//        new App().getAll();
        
    	// delete
//    	Session session = null;
//        
//        try {
//        	
//			session = buildSessionFactory().openSession();
//			session.beginTransaction();
//			
//			Department obj = session.get(Department.class, 2);
//			
//			session.delete(obj);
//			session.getTransaction().commit();
//			
//			System.out.println("Xoá thành công");
//		} finally {
//			if (session != null) {
//				session.close();
//			}
//		}
        

    	// trong db, viec cap nhat (them, sua, xoa, khong co select), phai dung transaction
    	
    	//delete 1 dong (id = 5, name "MKT"), thanh cong
//    	/ update 1 dong (id = 6, name = "Ban giam doc"), loi, fail
    	// update
    	Session session = null;
        
        try {
			session = buildSessionFactory().openSession();
			session.beginTransaction();
			//
			//
			Department obj = session.get(Department.class, 1);
			obj.setName("Sale 4");
			
			session.getTransaction().commit();
			
			System.out.println("Update thành công");
		} finally {
			if (session != null) {
				session.close();
			}
		}
    }
    
    private void getById() {

    	Session session = null;
        
        try {
			session = buildSessionFactory().openSession();
			
			Department obj = session.get(Department.class, 1);
			
			System.out.println(obj.getName());
			
		} finally {
			if (session != null) {
				session.close();
			}
		}
    }
    
    private void getByName() {

        // get by name
    	Session session = null;
        
        try {
			session = buildSessionFactory().openSession();
			
			Query<Department> query = session.createQuery("From Department Where name = :name");
			
			query.setParameter("name", "f");
			List<Department> departments = query.getResultList();
			
			System.out.println(departments.get(0).getId());
			System.out.println(departments.get(0).getName());
			
		} finally {
			if (session != null) {
				session.close();
			}
		}
    }
    
    private void getAll() {

    	Session session = null;
        
        try {
			session = buildSessionFactory().openSession();
			
//			import org.hibernate.Query; HQL Hibernate Query Language
			Query<Department> query = session.createQuery("From Department");
			
			List<Department> departments = query.list();
			System.out.println(departments.size());
			
			for (int i = 0; i < departments.size(); i++) {
				System.out.println(departments.get(i).getName());
			}
			
		} finally {
			if (session != null) {
				session.close();
			}
		}
    }
    private void save() {
    	Session session = null;
        
        try {
			session = buildSessionFactory().openSession();
			
			Department department = new Department();
			department.setName("Sale");

			session.save(department);
			System.out.println("Save successful");
			
		} finally {
			if (session != null) {
				session.close();
			}
		}
    }
    
    private static SessionFactory buildSessionFactory() {
    	Configuration configuration = new Configuration();
    	configuration.configure("hibernate.cfg.xml");
		
    	configuration.addAnnotatedClass(Department.class);
    	
    	ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
    			.applySettings(configuration.getProperties()).build();
    	
    	return configuration.buildSessionFactory(serviceRegistry);
	}
    
}
