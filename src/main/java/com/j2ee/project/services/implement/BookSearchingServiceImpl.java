package com.j2ee.project.services.implement;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.query.Query;
import com.j2ee.project.entities.Sach;
import com.j2ee.project.entities.search.BookData;
import com.j2ee.project.entities.search.SearchingBookQuery;
import com.j2ee.project.entities.Chitietsach;
import com.j2ee.project.services.BookSearchingService;

import antlr.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

@Transactional
public class BookSearchingServiceImpl implements BookSearchingService {

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
	      this.sessionFactory = sessionFactory;
	  }
	
	public List<Sach> FindBookByTitle(String title) {
		
		Session session = this.sessionFactory.getCurrentSession();
	
		CriteriaBuilder cb = session.getCriteriaBuilder();
		
		CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
		
		Root<Sach> book = cq.from(Sach.class);
		//Join<Sach, Chitietsach> bookDetail = book.join(arg0)
		
	}

	public List<BookData> FindBook(SearchingBookQuery criteria) {
		
		Session session = this.sessionFactory.getCurrentSession();
		
		String query = "select book, book_detail from Sach book, Chitietsach book_detail"
					   + "where book.id = book_detail.maSach";
		
		
		String keyword = criteria.getKeyword();
		
		if (keyword != null || !keyword.isEmpty()) {
			query += "and book.ten like '%" + keyword +"%'";
			query += "or book.tomTat like '%" + keyword +"%'";
		}
		
		List<String> categories = criteria.getCategories();
		
		if (!categories.isEmpty()) {
			
			for (String str : categories) {
				query += "and book_details.giaTri =";
			}			
			
		}

		
		return null;
	}

}
