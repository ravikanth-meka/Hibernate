package com.example.demo;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.entities.Event;
import com.example.repo.EventRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HibernateSpringDataJpaApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	LocalContainerEntityManagerFactoryBean courseEntityManagerFactory;
	
	
	@Autowired
	EventRepository eventRepository;
	
	@Test
		public  void testDataJpaSave() {
		EntityManagerFactory emf = courseEntityManagerFactory.getObject();
		 EntityManager em = emf.createEntityManager();
		 //em.getTransaction().begin();
		Session session = (Session) em.getDelegate();
		
		
		
		
		
		
	      
	      
	      
		
		
		//EventRepository repo = context.getBean(EventRepository.class);
			// create a couple of events...
//			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			eventRepository.save( new Event( "Our very first event!", new Date() ) );
			eventRepository.save( new Event( "A follow up event", new Date() ) );
			
			em.persist( new Event( "Our very first event... EM!", new Date() ) );
			em.persist( new Event( "A follow up event...  EM", new Date() ) );
			
			
			session.getSessionFactory().getStatistics().logSummary();
			
			session.getTransaction().commit();
			//session.close();

			// now lets pull events from the database and list them
//			session = HibernateUtil.getSessionFactory().openSession();
	        session.beginTransaction();
			for ( Event event : (List<Event>) eventRepository.findAll() ) {
				System.out.println( "Event (" + event.getDate() + ") : " + event.getTitle() );
			}
			session.getSessionFactory().getStatistics().logSummary();
			
			for ( Event event : (List<Event>) eventRepository.findAll() ) {
				System.out.println( "Event (" + event.getDate() + ") : " + event.getTitle() );
			}
			
			 List result = session.createQuery( "from Event" ).list();
				for ( Event event : (List<Event>) result ) {
					System.out.println( "Event (" + event.getDate() + ") : " + event.getTitle() );
				}
				
			session.getSessionFactory().getStatistics().logSummary();
	        session.getTransaction().commit();
	        session.close();
		}
}

