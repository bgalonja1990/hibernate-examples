package org.bojan.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="STUDENT")
public class Student extends Person{
	
	
	@OneToMany(mappedBy="student")
	@Cascade(value=CascadeType.ALL)
	private Set<Address> addresses = new HashSet<Address>();

	public Set<Address> getAddress() {
		return addresses;
	}

	public void setAddress(Set<Address> address) {
		this.addresses = address;
	}
	
	
	
	
}
