package com.force.samples.controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.force.samples.entity.Book;
import com.force.samples.util.PersistenceUtil;

@Controller
@RequestMapping(value="/rest")
public class RestController {
	
	private static Logger log = LoggerFactory.getLogger(RestController.class);

	@RequestMapping(method=RequestMethod.GET, value="/book/{bookId}")
	public @ResponseBody Book getBook (@PathVariable(value="bookId") long bookId, Model model) {
		
		log.info("Searching for book with id = " + bookId);
		
		EntityManager em = PersistenceUtil.getEntityManager();
		Query query = em.createQuery("select b from Book b where b.id = ?1").setParameter(1, bookId);
		List<Book> books = query.getResultList();
		
		log.info("Query results = " + books);
		
		if (books.size() > 0) {
			return books.get(0);
		} else {
			return null;
		}
	}
}
