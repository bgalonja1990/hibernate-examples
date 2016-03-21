package org.bojan.main;



import java.util.Date;

import org.bojan.entity.Department;
import org.bojan.entity.Employee;
import org.bojan.entity.EmployeeDepartment;
import org.bojan.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Main {
	
	public static void main(String args[]){

		Employee emp1 = new Employee();
		emp1.setFirstName("firstName");
		emp1.setLastName("lastName");
		
		Department dept1 = new Department();
		dept1.setName("Accounting");
		
		EmployeeDepartment empDept1 = new EmployeeDepartment();
		empDept1.setEmployee(emp1);
		empDept1.setDepartment(dept1);
		empDept1.setDate_joined(new Date());
		
		emp1.getEmployeeDepartments().add(empDept1);
		dept1.getEmployeeDepartments().add(empDept1);
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		session.beginTransaction();
	
		session.save(emp1);
		session.save(dept1);
		
		session.getTransaction().commit();
		
		sessionFactory.close();
		
		
		
	}
	
}
