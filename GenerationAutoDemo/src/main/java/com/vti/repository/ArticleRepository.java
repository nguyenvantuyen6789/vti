package com.vti.repository;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.Article;
import com.vti.utils.HibernateUtils;

public class ArticleRepository {

	private HibernateUtils hibernateUtils;
	
	public ArticleRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}
	
	@SuppressWarnings("unchecked")
	public List<Article> getAll() {
		Session session = null;

		try {
			session = hibernateUtils.openSession();

			Query<Article> query = session.createQuery("FROM Article");

			return query.list();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void create(Article article) {
		Session session = null;

		try {
			session = hibernateUtils.openSession();
			session.beginTransaction();

			session.save(article);
			
			session.getTransaction().commit();
			System.out.println("Save successful");
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
}
