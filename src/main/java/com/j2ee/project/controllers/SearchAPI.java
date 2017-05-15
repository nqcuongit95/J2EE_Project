
package com.j2ee.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
		List<Sach> listBook = bookSerachingService.FindBookByTitle(model.getTitle());

		results.setResults(listBook);
		if (listBook.isEmpty()) {
			results.setMsg("don't have any books data");
		}
		results.setMsg("have book data");

		return results;
	}

}
