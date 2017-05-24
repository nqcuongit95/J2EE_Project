package com.j2ee.project.services.implement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import org.hibernate.annotations.Where;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.query.Query;
import com.j2ee.project.entities.Sach;
import com.j2ee.project.entities.search.ApiResult;
import com.j2ee.project.entities.search.BookData;
import com.j2ee.project.entities.search.DropdownData;
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
		if (!keyword.isEmpty()) {
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
			Expression<String> exp = sachRoot.<String>get("tacGia");
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

	public List<String> FindAllBookCategory() {

		Session session = this.sessionFactory.getCurrentSession();
		EntityManager em = session.getEntityManagerFactory().createEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<String> cq = cb.createQuery(String.class);
		Root<Sach> sachRoot = cq.from(Sach.class);
		cq.select(sachRoot.<String>get("theLoai")).distinct(true);

		TypedQuery<String> q = em.createQuery(cq);
		List<String> listCategory = q.getResultList();
		List<String> result = new ArrayList<String>();

		for (String str : listCategory) {

			List<String> category = Arrays.asList(str.split(","));
			result.addAll(category);
		}

		Set<String> hs = new HashSet<String>();
		hs.addAll(result);
		result.clear();
		result.addAll(hs);

		for (int i = 0; i < result.size(); i++) {
			result.set(i, result.get(i).trim());
		}

		return result;
	}

	public ApiResult<DropdownData> FindAuthor(String query) {	

		Session session = this.sessionFactory.getCurrentSession();
		EntityManager em = session.getEntityManagerFactory().createEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<String> cq = cb.createQuery(String.class);
		Root<Sach> sachRoot = cq.from(Sach.class);

		Predicate pAuthor = cb.like(sachRoot.<String>get("tacGia"), "%" + query + "%");
		cq.select(sachRoot.<String>get("tacGia")).where(pAuthor).distinct(true);

		TypedQuery<String> q = em.createQuery(cq);
		List<String> authors = q.getResultList();

		if (authors != null && !authors.isEmpty()) {
			ApiResult<DropdownData> result = new ApiResult<DropdownData>();

			result.setSuccess("true");

			List<DropdownData> listAuthor = new ArrayList<DropdownData>();

			for (String str : authors) {
				DropdownData author = new DropdownData(str, str, str);
				listAuthor.add(author);
			}
			result.setResults(listAuthor);

			return result;

		} else {

			ApiResult<DropdownData> result = new ApiResult<DropdownData>();

			result.setSuccess("false");
			return result;
		}

	}

	public ApiResult<DropdownData> GetAllAuthor() {
		
		Session session = this.sessionFactory.getCurrentSession();
		EntityManager em = session.getEntityManagerFactory().createEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<String> cq = cb.createQuery(String.class);
		Root<Sach> sachRoot = cq.from(Sach.class);
		
		cq.select(sachRoot.<String>get("tacGia")).distinct(true);

		TypedQuery<String> q = em.createQuery(cq);
		List<String> authors = q.getResultList();

		if (authors != null && !authors.isEmpty()) {
			ApiResult<DropdownData> result = new ApiResult<DropdownData>();

			result.setSuccess("true");

			List<DropdownData> listAuthor = new ArrayList<DropdownData>();

			for (String str : authors) {
				DropdownData author = new DropdownData(str, str, str);
				listAuthor.add(author);
			}
			result.setResults(listAuthor);

			return result;

		} else {

			ApiResult<DropdownData> result = new ApiResult<DropdownData>();

			result.setSuccess("false");
			return result;
		}				
	}

	public ApiResult<DropdownData> FindCategory(String query) {
		
		Session session = this.sessionFactory.getCurrentSession();
		EntityManager em = session.getEntityManagerFactory().createEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<String> cq = cb.createQuery(String.class);
		Root<Sach> sachRoot = cq.from(Sach.class);
		
		Predicate pCategory = cb.like(sachRoot.<String>get("theLoai"), "%" + query + "%");
		cq.select(sachRoot.<String>get("theLoai")).where(pCategory).distinct(true);
		
		TypedQuery<String> q = em.createQuery(cq);
		List<String> category = q.getResultList();

		if (category != null && !category.isEmpty()) {
			ApiResult<DropdownData> result = new ApiResult<DropdownData>();

			result.setSuccess("true");

			List<DropdownData> listCate = new ArrayList<DropdownData>();

			for (String str : category) {
				DropdownData cate = new DropdownData(str, str, str);
				listCate.add(cate);
			}
			result.setResults(listCate);

			return result;

		} else {

			ApiResult<DropdownData> result = new ApiResult<DropdownData>();

			result.setSuccess("false");
			return result;
		}
	}

}
