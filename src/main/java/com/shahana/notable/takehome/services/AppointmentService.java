package com.shahana.notable.takehome.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shahana.notable.takehome.domain.Appointment;
import com.shahana.notable.takehome.repos.AppointmentRepository;
import com.shahana.notable.takehome.repos.DoctorRepository;

@Service
public class AppointmentService {

	private AppointmentRepository appointmentRepository;
	private DoctorRepository doctorRepository;
	
	@Autowired
	public AppointmentService(AppointmentRepository appointmentRepository, DoctorRepository doctorRepository)
	{
		this.appointmentRepository = appointmentRepository;
		this.doctorRepository = doctorRepository;
	}
	
	
	public List<Appointment> getAllAppointmentByDoctor(Integer doctorId, Date date) throws Exception
	{
//		Verify the doctor
		List<Appointment> appointments = new ArrayList<>();
		if(!doctorRepository.findById(doctorId).isPresent())
		{
			throw new Exception("Doctor not found. ID:" + doctorId); 
		}
		
		List<Appointment> allAppointments = appointmentRepository.findByDoctorId(doctorId);
		for(Appointment app : allAppointments)
		{
			Date appDate = app.getDate();
			if(appDate.getYear() == date.getYear() &&
					appDate.getMonth() == date.getMonth() &&
					appDate.getDate() == date.getDate())
			{
				appointments.add(app);
			}
		}
		return appointments;
	}
	
	
	
	
	public void addAppointment(Integer doctorId, Date requestedDate, String patientFirstName, String patientLastName, Boolean isNew) throws Exception
	{
		if(requestedDate.getMinutes() % 15 != 0)
		{
			throw new Exception("New appointments can only start at 15 minute intervals. Requested time: " + requestedDate.getMinutes() + " is not valid");
		}
		
		List<Appointment> appointments = getAllAppointmentByDoctor(doctorId, requestedDate);
		
		int sameTimecount = 0;
		for(Appointment apmnt : appointments)
		{
			Date appDate = apmnt.getDate();
			if(appDate.getHours() == requestedDate.getHours() &&
					appDate.getMinutes() == requestedDate.getMinutes())
			{
				sameTimecount++;
			}
		}
		
		if(sameTimecount <= 3)
		{
			System.out.println("Adding, Less than 3 appointments");
			Appointment apt = new Appointment(1, doctorId, patientFirstName, patientLastName, requestedDate, isNew);
			appointmentRepository.save(apt);
		}
		else
		{
			throw new Exception("Already have 3 appointments at this requested time " + requestedDate.getHours() + ":" + requestedDate.getMinutes());
		}
	}
	
	
	
	public void deleteAppointment(Integer doctorId, Integer appointmentId)
	{
		Appointment apt =  appointmentRepository.findByDoctorIdAndId(doctorId, appointmentId);
		appointmentRepository.delete(apt);
	}
	
}
