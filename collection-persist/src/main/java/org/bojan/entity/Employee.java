package org.bojan.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Employee implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	protected long id;
	
	@ElementCollection
	@JoinTable(name="EMPLOYEE_ADDRESS", 
			joinColumns=@JoinColumn(name="employee_id"))
	@GenericGenerator(name="hilo-gen", strategy="hilo")
	@CollectionId(columns={@Column(name="ADDRESS_ID")}, generator="hilo-gen", type=@Type(type="long"))
	Collection<Address> addresses = new ArrayList<Address>();
	
	protected String firstName;
	
	protected String lastName;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Collection<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Collection<Address> addresses) {
		this.addresses = addresses;
	}


	
}
