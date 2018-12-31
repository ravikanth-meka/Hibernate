package com.hibernate.tutorial.annotations;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;


public class AnnotationsTest {


		public static void main(String args[]) {
			// create a couple of events...
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save( new Event( "Our very first event!", new Date() ) );
			session.save( new Event( "A follow up event", new Date() ) );
			session.getTransaction().commit();
			session.close();

			// now lets pull events from the database and list them
			session = HibernateUtil.getSessionFactory().openSession();
	        session.beginTransaction();
	        List result = session.createQuery( "from Event" ).list();
			for ( Event event : (List<Event>) result ) {
				System.out.println( "Event (" + event.getDate() + ") : " + event.getTitle() );
			}
	        session.getTransaction().commit();
	        session.close();
		}
	}
