package com.j2ee.project.services.implement;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.j2ee.project.entities.search.ApiResult;
import com.j2ee.project.services.BookRentingService;

@Transactional
public class BookRentingServiceImpl implements BookRentingService {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public ApiResult<String> MarkBookForRenting(int id) {
		
		
		
		return null;
	}

}
