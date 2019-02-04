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
public class DataJpaApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	EventRepository eventRepository;
	
	@Test
		public  void testDataJpaSave() {
			
			eventRepository.save( new Event( "Our very first event!", new Date() ) );
			eventRepository.save( new Event( "A follow up event", new Date() ) );
			
			for ( Event event : (List<Event>) eventRepository.findAll() ) {
				System.out.println( "Event (" + event.getDate() + ") : " + event.getTitle() );
			}

			
		}
}

