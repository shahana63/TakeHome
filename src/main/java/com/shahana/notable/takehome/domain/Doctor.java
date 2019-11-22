package com.shahana.notable.takehome.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Doctor implements Serializable {

	@Id
	@GeneratedValue
	Integer id;
	
	@Column(length = 20)
	String firstName;
	
	@Column(length = 20)
	String lastName;
	
	protected Doctor()
	{
		
	}
	
	public Doctor(Integer id, String firstName, String lastName)
	{
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
	
	
	@Override
	public String toString()
	{
		return "Doctor{" + " id:" + id + " First Name:" + firstName + " Last Name:" + lastName + " }" ;
	}
	
	
}
