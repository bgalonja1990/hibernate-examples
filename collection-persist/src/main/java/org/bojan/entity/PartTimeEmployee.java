package org.bojan.entity;

import javax.persistence.Entity;

@Entity
public class PartTimeEmployee extends Employee{
	
	private float wagePerHour;

	public float getWagePerHour() {
		return wagePerHour;
	}

	public void setWagePerHour(float wagePerHour) {
		this.wagePerHour = wagePerHour;
	}
	
	
	
}
