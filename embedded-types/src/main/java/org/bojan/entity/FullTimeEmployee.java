package org.bojan.entity;

import javax.persistence.Entity;

@Entity
public class FullTimeEmployee extends Employee{
	
	private float salary;

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}
	
	
	
}
