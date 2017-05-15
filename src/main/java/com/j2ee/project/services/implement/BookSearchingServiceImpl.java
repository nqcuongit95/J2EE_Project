package com.j2ee.project.services.implement;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.query.Query;
import com.j2ee.project.entities.Sach;
import com.j2ee.project.services.BookSearchingService;

@Transactional
public class BookSearchingServiceImpl implements BookSearchingService {

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
	      this.sessionFactory = sessionFactory;
	  }
	
	public List<Sach> FindBookByTitle(String title) {
		
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Sach where ten = :title");
		query.setParameter("title", title);
		
		List<Sach> results = query.getResultList();
		
		return results;
	}

}
