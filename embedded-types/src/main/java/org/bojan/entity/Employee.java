package org.bojan.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Employee implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	protected long id;
	
	
	@AttributeOverrides({
		@AttributeOverride(name="street", column=@Column(name="HOME_STREET")),
		@AttributeOverride(name="houseNum", column=@Column(name="HOME_HOUSE_NUM")),
		@AttributeOverride(name="city", column=@Column(name="HOME_CITY"))
	})
	@Embedded
	private Address homeAdress;
	
	@Embedded
	private Address officeAddress;
	
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

	public Address getHomeAdress() {
		return homeAdress;
	}

	public void setHomeAdress(Address homeAdress) {
		this.homeAdress = homeAdress;
	}

	public Address getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}
	
	
}
