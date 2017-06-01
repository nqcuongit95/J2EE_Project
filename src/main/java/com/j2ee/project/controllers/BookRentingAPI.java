package com.j2ee.project.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.j2ee.project.entities.search.ApiResult;
import com.j2ee.project.entities.search.BookData;
import com.j2ee.project.services.BookRentingService;

@RestController
@SessionAttributes("rentingList")
public class BookRentingAPI {

	@Autowired
	private BookRentingService bookRentingService;

	@RequestMapping(value = "/book/renting/add/{id}")
	public ApiResult<String> MarkForRenting(Model model, HttpSession session, @PathVariable int id) {

		ApiResult<String> result = new ApiResult<String>();

		if (!model.containsAttribute("rentingList")) {
			List<Integer> listBook = new ArrayList<Integer>();
			listBook.add(id);
			model.addAttribute("rentingList", listBook);

			result.setSuccess("added");
			return result;
		} else {

			List<Integer> listBook = (List<Integer>) session.getAttribute("rentingList");

			if (listBook.contains(id)) {
				listBook.remove(new Integer(id));
				session.setAttribute("rentingList", listBook);
				if (!listBook.isEmpty()) {

					System.out.println("session attribute remove: " + listBook.get(0));
					System.out.println("session attribute remove: " + listBook.get(listBook.size() - 1));
				}
				result.setSuccess("removed");
				return result;
			} else {
				listBook.add(id);
				session.setAttribute("rentingList", listBook);
				if (!listBook.isEmpty()) {

					System.out.println("session attribute add: " + listBook.get(0));
					System.out.println("session attribute add: " + listBook.get(listBook.size() - 1));
				}
				result.setSuccess("added");
				return result;
			}
		}
	}
}
