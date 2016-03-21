package org.bojan.main;



import java.util.HashSet;
import java.util.Set;

import org.bojan.entity.Address;
import org.bojan.entity.Student;
import org.bojan.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Main {
	
	public static void main(String args[]){
		
		Student student = new Student();
		student.setFirstName("Bojan");
		student.setLastName("Galonja");
		
		
		Address address = new Address();
		address.setCity("City");
		address.setHouseNum("13");
		address.setStudent(student);
		
		Address address2 = new Address();
		address2.setCity("City");
		address2.setHouseNum("234");
		address2.setStudent(student);
		
		Set<Address> addresses = new HashSet<Address>();
		addresses.add(address);
		addresses.add(address2);
		
		student.setAddress(addresses);
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		session.beginTransaction();
		
		session.save(student);
		
		System.out.println("Student ID == " + student.getId());
		
		session.getTransaction().commit();
		
		sessionFactory.close();
		
	}
	
}
