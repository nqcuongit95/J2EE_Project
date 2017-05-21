package com.j2ee.project.services;

import java.util.List;

import com.j2ee.project.entities.Sach;
import com.j2ee.project.entities.search.BookData;
import com.j2ee.project.entities.search.SearchingBookQuery;

public interface BookSearchingService {
	List<Sach> FindBookByTitle(String title);
	List<BookData> FindBook(SearchingBookQuery criteria);
}
