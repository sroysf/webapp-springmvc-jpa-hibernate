package com.force.samples.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceUtil {
	
	private static EntityManagerFactory em = null;
	
	public static synchronized EntityManager getEntityManager() {
		if (em == null) {
			em = Persistence.createEntityManagerFactory("exampleHibernateJPA");
		}
		
		return em.createEntityManager();
	}
}
