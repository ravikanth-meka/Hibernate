package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.DataJPATest;

@SpringBootApplication
public class HibernateSpringDataJpaApplication {

/*	@Autowired
	DataJPATest dataJPATest;
*/	
	public static void main(String[] args) {
		SpringApplication.run(HibernateSpringDataJpaApplication.class, args);
		
	//	dataJPATest.testDataJpaSave();
	}

}

