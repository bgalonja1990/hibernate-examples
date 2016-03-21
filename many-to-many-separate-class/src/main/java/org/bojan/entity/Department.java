package org.bojan.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Department {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String name;
	
	@OneToMany(mappedBy="department")
	@Cascade(CascadeType.ALL)
	private Set<EmployeeDepartment> employeeDepartments = new HashSet<EmployeeDepartment>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<EmployeeDepartment> getEmployeeDepartments() {
		return employeeDepartments;
	}

	public void setEmployeeDepartments(Set<EmployeeDepartment> employeeDepartments) {
		this.employeeDepartments = employeeDepartments;
	}
	
	
	
}
