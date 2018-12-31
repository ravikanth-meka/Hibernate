package com.hibernate.tutorial.jpa;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import junit.framework.TestCase;

public class EntityManagerTest extends TestCase {
		private EntityManagerFactory entityManagerFactory;

		@Override
		protected void setUp() throws Exception {
			// like discussed with regards to SessionFactory, an EntityManagerFactory is set up once for an application
			// 		IMPORTANT: notice how the name here matches the name we gave the persistence-unit in persistence.xml!
			entityManagerFactory = Persistence.createEntityManagerFactory( "com.hibernate.tutorial.jpa" );
		}

		@Override
		protected void tearDown() throws Exception {
			entityManagerFactory.close();
		}

		public void testBasicUsage() {
			// create a couple of events...
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			entityManager.getTransaction().begin();
			entityManager.persist( new Event( "Our very first event!", new Date() ) );
			entityManager.persist( new Event( "A follow up event", new Date() ) );
			entityManager.getTransaction().commit();
			entityManager.close();

			// now lets pull events from the database and list them
			entityManager = entityManagerFactory.createEntityManager();
			entityManager.getTransaction().begin();
	        List<Event> result = entityManager.createQuery( "from Event", Event.class ).getResultList();
			for ( Event event : result ) {
				System.out.println( "Event (" + event.getDate() + ") : " + event.getTitle() );
			}
	        entityManager.getTransaction().commit();
	        entityManager.close();
		}
	}
