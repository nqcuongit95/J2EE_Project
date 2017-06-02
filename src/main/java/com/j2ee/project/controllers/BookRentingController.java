package com.j2ee.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.j2ee.project.entities.Chitietthongtinmuonsach;
import com.j2ee.project.entities.Thongtinmuonsach;
import com.j2ee.project.entities.renting.RentingData;
import com.j2ee.project.services.BookRentingService;

@Controller
public class BookRentingController {

	@Autowired
	private BookRentingService bookRentingService;

	@RequestMapping(value = "/bookrenting", method = RequestMethod.GET)
	public String BookRenting(Model model,Integer offset, Integer maxResults) {
		List<Thongtinmuonsach> data = bookRentingService.getAllRenting(offset,maxResults);
		model.addAttribute("count", bookRentingService.count());
	    model.addAttribute("offset", offset);
		model.addAttribute("data", data);

		return "bookRenting";
	}

	@RequestMapping(value = "/bookrenting/{id}", method = RequestMethod.GET)
	public String DetailsBookRenting(@PathVariable("id") int id, Model model) {
		
		List<Chitietthongtinmuonsach> details = bookRentingService.getDetailsByInfoID(id);
		Thongtinmuonsach info = bookRentingService.getInfoByID(id);
		model.addAttribute("details", details);
		model.addAttribute("info", info);
		
		List<RentingData> data = bookRentingService.getBookBorrowed(id);

		model.addAttribute("data", data);
		return "bookRentingDetails";
	}
	@RequestMapping(value = "/returnbookrenting", method = RequestMethod.POST)
	public String ReturnBook(@PathVariable int id){
		bookRentingService.returnBook(id);
		return "success";
	}
}
