package com.j2ee.project.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.j2ee.project.services.BookSearchingService;

@Controller
@SessionAttributes("rentingList")
public class SearchController {

	@Autowired
	private BookSearchingService bookSerachingService;

	@RequestMapping("/search")
	public String Search(Model model, SessionStatus status) {	
				
		status.setComplete();		
		
		return "searchPage";
	}
}