package com.shahana.notable.takehome.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Appointment implements Serializable
{
	@Id
	@GeneratedValue
	Integer id;
	
	@Column(length = 20)
	String patientFirstName;
	
	@Column(length = 20)
	String patientLastName;
	
	@Column
	Date date;
	
	@Column
	Boolean isNewPatient;
	
	@Column
	Integer doctorId;
	 
	
	protected Appointment()
	{
		
	}
	
	public Appointment(Integer id, Integer doctorId,  String patientFirstName, String patientLastName, Date date, Boolean isNewPatient)
	{
		this.id = id;
		this.doctorId = doctorId;
		this.patientFirstName = patientFirstName;
		this.patientLastName = patientLastName;
		this.date = date;
		this.isNewPatient = isNewPatient;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

	public String getPatientFirstName() {
		return patientFirstName;
	}

	public void setPatientFirstName(String patientFirstName) {
		this.patientFirstName = patientFirstName;
	}

	public String getPatientLastName() {
		return patientLastName;
	}

	public void setPatientLastName(String patientLastName) {
		this.patientLastName = patientLastName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Boolean getIsNewPatient() {
		return isNewPatient;
	}

	public void setIsNewPatient(Boolean isNewPatient) {
		this.isNewPatient = isNewPatient;
	}
	
	
	@Override
	public String toString()
	{
		return "Appointment {" + " id:" + id + " Patient First Name:" + patientFirstName + " Patient Last Name:" + patientLastName + 
				" isNewPatient:" + isNewPatient + " Date:" + date + "}";
	}
	

}
