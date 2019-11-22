package com.shahana.notable.takehome.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.shahana.notable.takehome.domain.Appointment;
import com.shahana.notable.takehome.domain.Doctor;
import com.shahana.notable.takehome.services.AppointmentService;
import com.shahana.notable.takehome.services.DoctorService;

@RestController
@RequestMapping (path = "/doctors")
public class DoctorController 
{
	DoctorService doctorService;
	AppointmentService appointmentService;
	
	
	protected DoctorController()
	{
		
	}
	
	@Autowired
	public DoctorController(DoctorService doctorService, AppointmentService appointmentService)
	{
		this.doctorService = doctorService;
		this.appointmentService = appointmentService;
	}
	
	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseStatus(code=HttpStatus.CREATED)
	public ResponseEntity<Doctor> createDoctor(@RequestBody Doctor doctor) throws Exception
	{
		System.out.print("Posting Doctor");

		if(doctor != null)
		{
			doctorService.createDoctor(doctor.getId(), doctor.getFirstName(), doctor.getLastName());
			 return ResponseEntity.status(HttpStatus.CREATED).build();
		}
		else
		{
			throw new Exception("Doctor is null");
		}
	}
	
	
	/**
	 * Get a list of all doctors
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(code = HttpStatus.OK)
	public List<Doctor> getAllDoctors() throws Exception 
	{
		return doctorService.getAllDoctors();
	}
	
	
	/**
	 * Add a new appointment to a doctor's calendar
	 * New appointments can only start at 15 minute intervals. 
	 * A doctor can have multiple appointments with the same time, but no more than 3.
	 * @param doctorid
	 * @param apmnt
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.POST, path="/{doctorid}", consumes = "application/json", produces = "application/json")
	@ResponseStatus(code=HttpStatus.CREATED)
	public ResponseEntity<Doctor> createAppointment(@PathVariable(value="doctorid") Integer doctorid, @RequestBody Appointment apmnt) throws Exception
	{
		System.out.print("Creating Appointment");

		if(apmnt != null)
		{
			appointmentService.addAppointment(doctorid, apmnt.getDate(), apmnt.getPatientFirstName(), apmnt.getPatientLastName(), apmnt.getIsNewPatient());
			 return ResponseEntity.status(HttpStatus.CREATED).build();
		}
		else
		{
			throw new Exception("Appointment is null");
		}
	}
	
	
	
	
	/**
	 * Get a list of all appointments for a particular doctor and particular day
	 * @param doctorid
	 * @param date
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.GET, path="/{doctorid}/{date}/appointments")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Appointment> getAllAppointmentsByDoctor(@PathVariable(value="doctorid") Integer doctorid, 
			@PathVariable(value="date") String date) throws Exception
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date requestDate = sdf.parse(date) ;
		return appointmentService.getAllAppointmentByDoctor(doctorid, requestDate);
	}

	
	/**
	 * Delete an existing appointment from a doctor's calendar
	 * @param doctorid
	 * @param apmntId
	 */
	 @RequestMapping(method = RequestMethod.DELETE, path = "/{doctorid}/{apmntId}")
	 public void delete(@PathVariable(value = "doctorid") int doctorid, @PathVariable(value = "apmntId") int apmntId) 
	 {
		 appointmentService.deleteAppointment(doctorid, apmntId);
	 }
	

}
