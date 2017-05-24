package com.j2ee.project.services;

import java.util.List;

import com.j2ee.project.entities.Sach;
import com.j2ee.project.entities.search.ApiResult;
import com.j2ee.project.entities.search.BookData;
import com.j2ee.project.entities.search.DropdownData;
import com.j2ee.project.entities.search.SearchingBookQuery;

public interface BookSearchingService {
	
	List<BookData> FindBook(SearchingBookQuery criteria);
	List<String> FindAllBookCategory();
	ApiResult<DropdownData> FindAuthor(String query);
	ApiResult<DropdownData> FindCategory(String query);
	ApiResult<DropdownData> GetAllAuthor();
	
}