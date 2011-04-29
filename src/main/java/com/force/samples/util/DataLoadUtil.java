package com.force.samples.util;

import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.force.samples.entity.Author;
import com.force.samples.entity.Book;

/**
 * Use this class to reset the database state for the test entities.
 * Execute from command line using : mvnnt -e exec:java -Dexec.mainClass=com.force.samples.util.DataLoadUtil 
 * 
 */
public class DataLoadUtil {
	
	private static Logger log = null;
	
	public static void main(String[] args) {
		log = LoggerFactory.getLogger(DataLoadUtil.class);
		
		log.info("Resetting database state");
		resetDatabaseState();
	}

	private static void resetDatabaseState() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exampleHibernateJPA");
		
		EntityManager em = emf.createEntityManager();
		
		log.info("Creating and persisting entity...");
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		deleteAllExistingData(em);
		
		populateCannedData(em);
		
		tx.commit();
	}

	private static void populateCannedData(EntityManager em) {
		
		Author author = new Author();
		author.setFirstName("JRR");
		author.setLastName("Tolkein");

		Book hobbit = new Book();
		hobbit.setAuthor(author);
		hobbit.setTitle("The Hobbit");
		hobbit.setPublicationDate(new GregorianCalendar(1937, 11, 1).getTime());
		em.persist(hobbit);
		
		Book fotr = new Book();
		fotr.setAuthor(author);
		fotr.setTitle("Fellowship of the Ring");
		fotr.setPublicationDate(new GregorianCalendar(1954, 06, 24).getTime());
		em.persist(fotr);
		
		Book twoTowers = new Book();
		twoTowers.setAuthor(author);
		twoTowers.setTitle("The Two Towers");
		twoTowers.setPublicationDate(new GregorianCalendar(1954, 10, 11).getTime());
		em.persist(twoTowers);
		
		Book rotk = new Book();
		rotk.setAuthor(author);
		rotk.setTitle("Return of the King");
		rotk.setPublicationDate(new GregorianCalendar(1955, 9, 20).getTime());
		em.persist(rotk);
		
		Author rowling = new Author();
		rowling.setFirstName("J.K");
		rowling.setLastName("Rowling");
		
		Book hpps = new Book();
		hpps.setAuthor(rowling);
		hpps.setTitle("Harry Potter and the Philosophers Stone");
		hpps.setPublicationDate(new GregorianCalendar(1997, 5, 30).getTime());
		em.persist(hpps);
		
		Book hpcs = new Book();
		hpcs.setAuthor(rowling);
		hpcs.setTitle("Harry Potter and the Chamber of Secrets");
		hpcs.setPublicationDate(new GregorianCalendar(1998, 6, 2).getTime());
		em.persist(hpcs);
		
		Book hppa = new Book();
		hppa.setAuthor(rowling);
		hppa.setTitle("Harry Potter and the Prisoner of Azkaban");
		hppa.setPublicationDate(new GregorianCalendar(1999, 6, 8).getTime());
		em.persist(hppa);
	}

	private static void deleteAllExistingData(EntityManager em) {
		log.info("Deleting existing books");
		Query bookQuery = em.createQuery("delete from Book");
		bookQuery.executeUpdate();
		
		Query authorQuery = em.createQuery("delete from Author");
		authorQuery.executeUpdate();
		
		log.info("Deleting existing authors");
	}	
}
