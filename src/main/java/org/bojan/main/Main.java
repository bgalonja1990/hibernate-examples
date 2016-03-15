package org.bojan.main;

import javax.transaction.Transaction;

import org.bojan.entity.Professor;
import org.bojan.entity.Subject;
import org.bojan.util.HibernateUtil;
import org.hibernate.SessionFactory;

public class Main {
	
	public static void main(String args[]){
		
		Subject subject1 = new Subject();
		subject1.setName("Physics 1");
		Subject subject2 = new Subject();
		subject2.setName("Physics 2");
		
		Professor prof = new Professor();
		prof.setFirstName("First");
		prof.setLastName("Last");
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		sessionFactory.getCurrentSession().beginTransaction();
		subject1.setProfessor(prof);
		subject2.setProfessor(prof);
		
		sessionFactory.getCurrentSession().save(subject1);
		sessionFactory.getCurrentSession().save(subject2);
		sessionFactory.getCurrentSession().save(prof);
		
		prof.getSubjects().add(subject1);
		prof.getSubjects().add(subject2);
		
		for(Subject sub : prof.getSubjects()){
			System.out.println(sub.getName());
		}
		System.out.println("Printed all");
		
		sessionFactory.getCurrentSession().getTransaction().commit();
		
		
		sessionFactory.close();
		
	}
	
}
