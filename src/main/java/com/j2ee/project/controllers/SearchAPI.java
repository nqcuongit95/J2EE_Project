
package com.j2ee.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.j2ee.project.entities.search.ApiResult;
import com.j2ee.project.entities.search.BookData;
import com.j2ee.project.entities.search.DropdownData;
import com.j2ee.project.entities.search.SearchingBookQuery;
import com.j2ee.project.entities.search.SearchingBookResults;
import com.j2ee.project.services.BookSearchingService;
import com.j2ee.project.entities.Sach;

@RestController
public class SearchAPI {

	@Autowired
	private BookSearchingService bookSerachingService;

	@RequestMapping("/search/findBook")
	public SearchingBookResults FindBook(@RequestBody SearchingBookQuery model) {

		SearchingBookResults results = new SearchingBookResults();
		List<BookData> listBook = bookSerachingService.FindBook(model);

		results.setResults(listBook);
		if (listBook.isEmpty()) {
			results.setMsg("don't have any books data");
			return results;
		}
		
		results.setMsg("have book data");
		return results;
	}
	
	@RequestMapping(value="/search/findAuthor", params = "query")
	public ApiResult<DropdownData> FindAuthor(@RequestParam(value="query")String _query){
				
		ApiResult<DropdownData> result = bookSerachingService.FindAuthor(_query);
		
		return result;
	}
	
	@RequestMapping(value="/search/findCategory", params = "query")
	public ApiResult<DropdownData> FindCategory(@RequestParam(value="query")String _query){
				
		ApiResult<DropdownData> result = bookSerachingService.FindCategory(_query);
		
		return result;
	}
	
	@RequestMapping(value="/search/allAuthor")
	public ApiResult<DropdownData> FindAuthor(){
		
		System.out.println("run fdafdsaf");
		ApiResult<DropdownData> result = bookSerachingService.GetAllAuthor();
		
		return result;
	}

}
