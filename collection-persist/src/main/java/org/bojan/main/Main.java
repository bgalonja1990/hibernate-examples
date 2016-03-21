package org.bojan.main;



import java.util.HashSet;
import java.util.Set;

import org.bojan.entity.Address;
import org.bojan.entity.Employee;
import org.bojan.entity.FullTimeEmployee;
import org.bojan.entity.PartTimeEmployee;
import org.bojan.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Main {
	
	public static void main(String args[]){
		

		Address address = new Address();
		address.setCity("City");
		address.setHouseNum("13");
		
		Address address2 = new Address();
		address2.setCity("City2");
		address2.setHouseNum("132");
		
		PartTimeEmployee e1 = new PartTimeEmployee();
		e1.setFirstName("firstName1");
		e1.setLastName("lastName1");
		
		FullTimeEmployee e2 = new FullTimeEmployee();
		e2.setFirstName("firstName2");
		e2.setLastName("lastName2");
		
		e1.getAddresses().add(address);
		e1.getAddresses().add(address);
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		session.beginTransaction();
		
		session.save(e1);
		session.save(e2);

		session.getTransaction().commit();
		
		//sessionFactory.close();
		
		//sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session1 = sessionFactory.getCurrentSession();
		
		session1.beginTransaction();
		
		session1.createCriteria(PartTimeEmployee.class).list();
		session1.getTransaction().commit();
		
		sessionFactory.close();
		
	}
	
}
