package org.bojan.util;



import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	
	private static SessionFactory buildSessionAnnotationFactory(){
		Configuration cfg = new Configuration();
		cfg.configure("hibernate-annotation-cfg.xml");
		
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
		SessionFactory sessionFactory = cfg.buildSessionFactory(serviceRegistry);
		return sessionFactory;
		
	
	}
	
	public static SessionFactory getSessionFactory(){
		
		if(sessionFactory == null){
			sessionFactory = buildSessionAnnotationFactory();
		}
		return sessionFactory;
	}
	
}
