package org.bojan.main;



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
		
		student.setAddress(address);
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		session.beginTransaction();
		
		session.save(student);
		
		System.out.println("Student ID == " + student.getId());
		
		session.getTransaction().commit();
		
		sessionFactory.close();
		
	}
	
}
