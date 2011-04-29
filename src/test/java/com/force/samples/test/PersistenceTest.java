package com.force.samples.test;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.force.samples.entity.Author;
import com.force.samples.entity.Book;


public class PersistenceTest {

	private static Logger log = null;
	
	@BeforeClass
	public static void testClassSetup() {
		log = LoggerFactory.getLogger(PersistenceTest.class);
		
		log.warn("Be sure to create the schema before running these tests!");
	}

	@Test
	public void testDatabaseSaveAndRetrieve() {
		log.info("Running testDatabaseSaveAndRetrieve");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exampleHibernateJPA");
		
		EntityManager em = emf.createEntityManager();
		
		log.info("Creating and persisting entity...");
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Author author = new Author();
		author.setFirstName("JRR");
		author.setLastName("Tolkein");

		Book book = new Book();
		book.setAuthor(author);
		book.setTitle("Fellowship of the Ring");
		book.setPublicationDate(new GregorianCalendar(1954, 06, 24).getTime());
		
		em.persist(book);
		
		tx.commit();
		
		// Now read it back and verify
		log.info("Reading back from database and verifying...");
		EntityTransaction readTx = em.getTransaction();
		readTx.begin();
		
		Book fellowship = em.find(Book.class, book.getId());
		Assert.assertNotNull(fellowship);
		Assert.assertEquals("Fellowship of the Ring", fellowship.getTitle());
		Assert.assertEquals("JRR", fellowship.getAuthor().getFirstName());
		Assert.assertEquals("Tolkein", fellowship.getAuthor().getLastName());
		
		readTx.commit();
		
		// Cleanup the entities
		log.info("Cleaning up created entity...");
		EntityTransaction delTx = em.getTransaction();
		delTx.begin();
		
		em.remove(fellowship);
		em.remove(fellowship.getAuthor());
		
		delTx.commit();
	}
}
