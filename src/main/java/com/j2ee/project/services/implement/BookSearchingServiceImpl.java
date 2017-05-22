package com.j2ee.project.services.implement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.transaction.annotation.Transactional;
import org.hibernate.query.Query;
import com.j2ee.project.entities.Sach;
import com.j2ee.project.entities.search.BookData;
import com.j2ee.project.entities.search.SearchingBookQuery;
import com.j2ee.project.services.BookSearchingService;
import com.mysql.fabric.xmlrpc.base.Array;

@Transactional
public class BookSearchingServiceImpl implements BookSearchingService {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<BookData> FindBook(SearchingBookQuery criteria) {

		Session session = this.sessionFactory.getCurrentSession();
		EntityManager em = session.getEntityManagerFactory().createEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Sach> cq = cb.createQuery(Sach.class);
		Root<Sach> sachRoot = cq.from(Sach.class);

		List<Predicate> predicates = new ArrayList<Predicate>();

		String keyword = criteria.getKeyword();
		if (keyword != null || !keyword.isEmpty()) {
			Predicate pKeyword;
			Predicate p1 = cb.like(sachRoot.<String>get("ten"), "%" + keyword + "%");
			Predicate p2 = cb.like(sachRoot.<String>get("tomTat"), "%" + keyword + "%");
			pKeyword = cb.or(p1, p2);

			predicates.add(pKeyword);
		}

		List<String> categories = criteria.getCategories();
		if (categories != null && !categories.isEmpty()) {
			Predicate pCategory;
			Expression<String> exp = sachRoot.<String>get("theLoai");
			pCategory = exp.in(categories);
			predicates.add(pCategory);
		}

		List<String> authors = criteria.getAuthors();
		if (authors != null && !authors.isEmpty()) {
			Predicate pAuthor;
			Expression<String> exp = sachRoot.<String>get("theLoai");
			pAuthor = exp.in(authors);
			predicates.add(pAuthor);
		}

		cq.select(sachRoot).where(cb.and(predicates.toArray(new Predicate[] {})));
		TypedQuery<Sach> q = em.createQuery(cq);

		List<Sach> books = q.getResultList();

		List<BookData> result = new ArrayList<BookData>();

		for (Sach sach : books) {

			BookData bookData = new BookData();
			List<String> auths = Arrays.asList(sach.getTacGia().split(","));
			List<String> categ = Arrays.asList(sach.getTheLoai().split(","));

			bookData.setTitle(sach.getTen());
			bookData.setAuthors(auths);
			bookData.setCategories(categ);
			bookData.setDescription(sach.getTomTat());
			bookData.setImageUrl(sach.getImageUrl());
			bookData.setISBN(sach.getIsbn());

			result.add(bookData);
		}

		return result;
	}

}
