package com.force.samples.dao;

import java.util.List;

import org.springframework.orm.jpa.support.JpaDaoSupport;

import com.force.samples.entity.Book;

public class BookDAOImpl extends JpaDaoSupport implements BookDAO {

	public List<Book> getAllBooks() {
		return getJpaTemplate().find("select b from Book b");
	}

	public List<Book> getBooksByTitle(String title) {
		return getJpaTemplate().find("select b from Book b where b.title=?1", title);
	}

	public Book getBookById(Long id) {
		return getJpaTemplate().find(Book.class, id);
	}

}
