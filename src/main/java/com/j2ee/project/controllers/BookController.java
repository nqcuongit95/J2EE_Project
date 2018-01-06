package com.j2ee.project.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import com.j2ee.project.entities.Sach;
import com.j2ee.project.services.ISachService;

@Controller
public class BookController {
	@Autowired
	private ISachService sachService;

	@Autowired
	ServletContext context;

	@Transactional
	@RequestMapping(value = { "/book", "/book/index" }, method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("bookIndex");

		List<Sach> listSach = this.sachService.getAllSach();

		modelAndView.addObject("listSach", listSach);

		return modelAndView;
	}

	@Transactional
	@RequestMapping(value = { "/book/create" }, method = RequestMethod.GET)
	public ModelAndView create(Sach sach) {
		ModelAndView modelAndView = new ModelAndView("bookCreate");

		Date date = new Date();

		sach.setNgayTao(date);

		if (sach.getSoBan() == null) {
			sach.setSoBan(0);
		}

		if (sach.getGiaMuon() == null) {
			sach.setGiaMuon(new BigDecimal("0"));
		}

		modelAndView.addObject("sach", sach);

		return modelAndView;
	}

	@Transactional
	@RequestMapping(value = { "/book/createConfirm" }, method = RequestMethod.POST)
	public ModelAndView createConfirm(@ModelAttribute("sach") Sach sach) {
		ModelAndView modelAndView = null;

		sach.setNgayTao(new Date());

		if (sach.getSoBan() == null) {
			sach.setSoBan(0);
		}

		if (true) {
			this.sachService.createSach(sach);

			modelAndView = new ModelAndView("redirect:/book/index");
		} else {
			modelAndView = this.create(sach);

			// modelAndView.setViewName("redirect:/Index");
		}

		return modelAndView;
	}

	@Transactional
	@RequestMapping(value = { "/book/update" }, method = RequestMethod.GET)
	public ModelAndView update(@RequestParam("id") Integer id) {
		ModelAndView modelAndView = new ModelAndView("bookUpdate");

		Sach sach = this.sachService.getSachById(id);

		if (sach.getSoBan() == null) {
			sach.setSoBan(0);
		}

		if (sach.getGiaMuon() == null) {
			sach.setGiaMuon(new BigDecimal("0"));
		}

		modelAndView.addObject("sach", sach);

		return modelAndView;
	}

	@Transactional
	@RequestMapping(value = { "/book/updateConfirm" }, method = RequestMethod.POST)
	public ModelAndView updateConfirm(@ModelAttribute("sach") Sach sach) {
		ModelAndView modelAndView = null;

		if (sach.getSoBan() == null) {
			sach.setSoBan(0);
		}

		if (sach.getGiaMuon() == null) {
			sach.setGiaMuon(new BigDecimal("0"));
		}

		if (true) {
			this.sachService.updateSach(sach);

			modelAndView = new ModelAndView("redirect:/book/index");
		} else {
			modelAndView = this.create(sach);

			// modelAndView.setViewName("redirect:/Index");
		}

		return modelAndView;
	}

	@Transactional
	@RequestMapping(value = { "/book/details" }, method = RequestMethod.GET)
	public ModelAndView details(@RequestParam("id") Integer id) {
		ModelAndView modelAndView = new ModelAndView("bookDetails");

		Sach sach = this.sachService.getSachById(id);

		modelAndView.addObject("sach", sach);

		return modelAndView;
	}

	@Transactional
	@RequestMapping(value = { "/book/delete" }, method = RequestMethod.GET)
	public ModelAndView delete(@RequestParam("id") Integer id) {
		ModelAndView modelAndView = new ModelAndView("bookDelete");

		Sach sach = this.sachService.getSachById(id);

		if (sach.getSoBan() == null) {
			sach.setSoBan(0);
		}

		if (sach.getGiaMuon() == null) {
			sach.setGiaMuon(new BigDecimal("0"));
		}

		modelAndView.addObject("sach", sach);

		return modelAndView;
	}

	@Transactional
	@RequestMapping(value = { "/book/deleteConfirm" }, method = RequestMethod.POST)
	public ModelAndView deleteConfirm(@ModelAttribute("id") Integer id) {
		ModelAndView modelAndView = null;

		if (true) {

			this.sachService.deleteSach(id);

			modelAndView = new ModelAndView("redirect:/book/index");
		} else {
		}

		return modelAndView;
	}

	@RequestMapping(value = "/book/uploadImage", method = RequestMethod.POST)
	public ModelAndView uploadImage(@RequestParam("id") Integer id, @RequestParam("file") MultipartFile file) {
		ModelAndView modelAndView = new ModelAndView("redirect:/bookDetails");

		Sach sach = this.sachService.getSachById(id);

		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath = context.getRealPath("");

				String name = UUID.randomUUID().toString();

				String filePath = File.separator + "resources" + File.separator + "upload" + File.separator + name;

				// Create the file on server
				File serverFile = new File(rootPath + filePath);

				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));

				stream.write(bytes);
				stream.close();

				sach.setImageUrl(filePath);

				this.sachService.updateSach(sach);
			} catch (Exception e) {
			}
		} else {
		}
		
		modelAndView.addObject("sach", sach);

		modelAndView.setView(new RedirectView("/book/details?id=" + sach.getId(), true));

		return modelAndView;
	}
}
