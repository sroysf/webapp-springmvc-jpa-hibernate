package com.force.samples.dao;

import java.util.List;

import com.force.samples.entity.Book;

public interface BookDAO {
	
	List<Book> getAllBooks();
	
	List<Book> getBooksByTitle(String title);
	
	Book getBookById(Long id);
}
