package org.bojan.util;



import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	
	private static SessionFactory buildSessionAnnotationFactory(){
		
		Configuration configuration = new Configuration();
		
		configuration.configure("hibernate-annotation-cfg.xml");
		System.out.println("Configured!");
		
		//***NOTE
		//SessionFactory sessionFactory = new Configuration().configure().build
		//DEPRECATED from Hibernate 4.3.0 - using StandardServiceRegistryBuilder instead
				
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		
		
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		
		return sessionFactory;
	
	}
	
	public static SessionFactory getSessionFactory(){
		
		if (sessionFactory==null){
			sessionFactory = buildSessionAnnotationFactory();
		}
		return sessionFactory;
		
	}
	
}
