package com.j2ee.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;

import com.j2ee.project.services.BookSearchingService;

@Controller
public class SearchController {

	@Autowired
	private BookSearchingService bookSerachingService;

	@RequestMapping("/search")
	public String Search(Model model) {
		return "searchPage";
	}
}
