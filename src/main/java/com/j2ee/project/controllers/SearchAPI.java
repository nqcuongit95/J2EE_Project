
package com.j2ee.project.controllers;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.j2ee.project.entities.search.ApiResult;
import com.j2ee.project.entities.search.BookData;
import com.j2ee.project.entities.search.DropdownData;
import com.j2ee.project.entities.search.SearchingBookQuery;
import com.j2ee.project.entities.search.SearchingBookResults;
import com.j2ee.project.services.BookRentingService;
import com.j2ee.project.services.BookSearchingService;
import com.j2ee.project.entities.Sach;

@RestController
@SessionAttributes("rentingList")
public class SearchAPI {

	@Autowired
	private BookSearchingService bookSerachingService;

	@RequestMapping("/search/findBook")
	public SearchingBookResults FindBook(@RequestBody SearchingBookQuery model, HttpSession session) {

		SearchingBookResults results = new SearchingBookResults();
		List<BookData> listBook = bookSerachingService.FindBook(model);

		results.setResults(listBook);
		if (listBook.isEmpty()) {
			results.setMsg("don't have any books data");
			return results;
		}

		List<Integer> listRentingBook = (List<Integer>) session.getAttribute("rentingList");

		if (listRentingBook != null && !listRentingBook.isEmpty()) {
			for (int i = 0; i < listBook.size(); i++) {

				if (listRentingBook.contains(new Integer(listBook.get(i).getId()))) {
					listBook.get(i).setAdded("true");
				} else {
					listBook.get(i).setAdded("false");
				}

			}
		}
		results.setMsg("have book data");
		return results;
	}

	@RequestMapping(value = "/search/findAuthor", params = "query")
	public ApiResult<DropdownData> FindAuthor(@RequestParam(value = "query") String _query) {

		ApiResult<DropdownData> result = bookSerachingService.FindAuthor(_query);

		return result;
	}

	@RequestMapping(value = "/search/findCategory", params = "query")
	public ApiResult<DropdownData> FindCategory(@RequestParam(value = "query") String _query) {

		ApiResult<DropdownData> result = bookSerachingService.FindCategory(_query);

		return result;
	}

	@RequestMapping(value = "/search/allAuthor")
	public ApiResult<DropdownData> FindAuthor() {

		ApiResult<DropdownData> result = bookSerachingService.GetAllAuthor();

		return result;
	}

	@RequestMapping(value = "/book/details/{id}")
	public BookData BookDetails(@PathVariable int id) {

		BookData book = bookSerachingService.GetBookDetails(id);

		return book;
	}

}
