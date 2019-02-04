package com.hibernate.tutorial.annotations;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	private static SessionFactory sessionFactory = buildSessionFactoryWithVerionFive();
	  
	/**
	 * <version>4.3.11.Final</version>
	 * <Ravi:> This method works with version 4.
	 * In version 4, there is not MetadataSources
	 */
	   private static SessionFactory buildSessionFactoryWithVerionFour()
	   {
	      try
	      {
	         if (sessionFactory == null)
	         {
	            Configuration configuration = new Configuration().configure(HibernateUtil.class.getResource("/hibernate.cfg.xml"));
	            StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
	            serviceRegistryBuilder.applySettings(configuration.getProperties());
	            ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
	            
	            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	         }
	         return sessionFactory;
	      } catch (Throwable ex)
	      {
	         System.err.println("Initial SessionFactory creation failed." + ex);
	         throw new ExceptionInInitializerError(ex);
	      }
	   }
	   
	   /**
		 * <version>5.4.0.Final</version>
		 * <Ravi:> This method works with version 5 and above.
		 *  In version 4, there is not MetadataSources
		 */
	   private static SessionFactory buildSessionFactoryWithVerionFive()
	   {
				// A SessionFactory is set up once for an application!
				final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
						.configure("/hibernate.cfg.xml") // configures settings from hibernate.cfg.xml
						.build();
				try {
					sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
				}
				catch (Exception e) {
					// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
					// so destroy it manually.
					StandardServiceRegistryBuilder.destroy( registry );
					throw new ExceptionInInitializerError(e);
				}
				return sessionFactory;
	   }
	  
	   public static SessionFactory getSessionFactory()
	   {
	      return sessionFactory;
	   }
	  
	   public static void shutdown()
	   {
	      getSessionFactory().close();
	   }
	   
}
