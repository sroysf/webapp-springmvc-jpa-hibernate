package com.force.samples.controllers;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.force.samples.dao.BookDAO;
import com.force.samples.entity.Book;

@Controller
public class HomeController {
	
	private static Logger log = LoggerFactory.getLogger(HomeController.class);

	@Inject
	private BookDAO bookDAO;
	
	@RequestMapping(method=RequestMethod.GET, value={"/", "/home"}) 
	public String showHomePage (ModelAndView mv) {
		log.info("Hit controller");
		
		return "home";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/listbooks")
	public String listBooks (Model model) {
		List<Book> books = bookDAO.getAllBooks();
		
		model.addAttribute("books", books);
		
		return "listResults";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/getbook")
	public String getBook (String title, Model model) {
		List<Book> books = bookDAO.getBooksByTitle(title);
		
		model.addAttribute("books", books);
		
		return "listResults";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/upload")
	public String uploadFile(String description, @RequestParam(value="myFile")MultipartFile uploadedFile, Model model) {
		
		Long fileSize = uploadedFile.getSize();
		log.info("File size received = " + fileSize);
		log.info("Description = " + description);
		
		model.addAttribute("desc", description);
		model.addAttribute("fileSize", fileSize);
		return "uploadSuccess";
	}
}
