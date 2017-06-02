package com.j2ee.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.j2ee.project.entities.Thongtinmuonsach;
import com.j2ee.project.entities.renting.NotifyData;
import com.j2ee.project.services.BookRentingService;

@RestController
public class BookReturnAPI {
	@Autowired
	private BookRentingService bookRentingService;
	@RequestMapping(value = "/book/return/{id}")
	public NotifyData ProcessOrder(@PathVariable int id) {
			
		NotifyData result = bookRentingService.returnBook(id);	
		System.out.println(result.getHeader());
		
		return 	result;
	}
	
	@RequestMapping(value = "/book/search",method=RequestMethod.POST)
	public Thongtinmuonsach Search(@RequestBody Thongtinmuonsach search) {
		Thongtinmuonsach result = bookRentingService.getInfoByIdOrPhone(search.getId().toString());			
		return 	result;
	}
}
