package org.bojan.entity;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="EMPLOYEE_DEPT")
public class EmployeeDepartment {
	
	@Id
	private long row_id;
	
	@Temporal(TemporalType.DATE)
	private Date date_joined;
	
	@ManyToOne
	@JoinColumn(name="EMP_ID")
	private Employee employee;
	
	@ManyToOne
	@JoinColumn(name="DEP_ID")
	private Department department;

	public long getRow_id() {
		return row_id;
	}

	public void setRow_id(long row_id) {
		this.row_id = row_id;
	}

	public Date getDate_joined() {
		return date_joined;
	}

	public void setDate_joined(Date date_joined) {
		this.date_joined = date_joined;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	
}
