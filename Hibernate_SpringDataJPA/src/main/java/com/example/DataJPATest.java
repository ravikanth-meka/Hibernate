package com.example;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.entities.Event;
import com.example.repo.EventRepository;

@Component
public class DataJPATest {


	@Autowired
	EventRepository eventRepository;
	

		public  void testDataJpaSave() {
		//EventRepository repo = context.getBean(EventRepository.class);
			// create a couple of events...
//			Session session = HibernateUtil.getSessionFactory().openSession();
//			session.beginTransaction();
			eventRepository.save( new Event( "Our very first event!", new Date() ) );
			eventRepository.save( new Event( "A follow up event", new Date() ) );
//			session.getTransaction().commit();
//			session.close();

			// now lets pull events from the database and list them
//			session = HibernateUtil.getSessionFactory().openSession();
//	        session.beginTransaction();
			for ( Event event : (List<Event>) eventRepository.findAll() ) {
				System.out.println( "Event (" + event.getDate() + ") : " + event.getTitle() );
			}
			
			for ( Event event : (List<Event>) eventRepository.findAll() ) {
				System.out.println( "Event (" + event.getDate() + ") : " + event.getTitle() );
			}
//	        session.getTransaction().commit();
//	        session.close();
		}
	}
