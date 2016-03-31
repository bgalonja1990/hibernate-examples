package org.bojan.main;



import org.bojan.entity.Address;
import org.bojan.entity.Student;
import org.bojan.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import net.sf.ehcache.search.expression.Criteria;

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
		address2.setHouseNum("14");
		address2.setStudent(student);
		Address address3 = new Address();
		address3.setCity("City");
		address3.setHouseNum("15");
		address3.setStudent(student);
		
		student.getAddresses().add(address);
		student.getAddresses().add(address2);
		student.getAddresses().add(address3);
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		session.beginTransaction();
		
		session.save(student);
		
		System.out.println("Student ID == " + student.getId());
		
		session.getTransaction().commit();
		
		Session session2 = sessionFactory.openSession();
		session2.beginTransaction();
		Student s = (Student)session2.load(Student.class, 1);
		System.out.println("Loaded student of id: " +s.getId() );
		Student s2 = (Student)session2.load(Student.class, 1);
		System.out.println("Loaded student of id: " +s2.getId() );
		session2.getTransaction().commit();
		
		Session session3 = sessionFactory.openSession();
		session3.beginTransaction();
		session3.createCriteria(Address.class).add(Restrictions.eq("student", s)).setCacheable(true).list();
		session3.getTransaction().commit();
		
		Session session4 = sessionFactory.openSession();
		session4.beginTransaction();
		session4.createCriteria(Address.class).add(Restrictions.eq("student", s)).list();
		session4.getTransaction().commit();
		
		sessionFactory.close();
		
	}
	
}
