package com.shahana.notable.takehome.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shahana.notable.takehome.domain.Doctor;
import com.shahana.notable.takehome.repos.DoctorRepository;

@Service
public class DoctorService {
	
private DoctorRepository doctorRepository;
	
	@Autowired
	public DoctorService(DoctorRepository doctorRepository)
	{
		this.doctorRepository = doctorRepository;
	}
	
	public Doctor createDoctor(Integer id, String firstName, String lastName)
	{
		if(doctorRepository.existsById(id))
		{
			System.out.println("Doctor id:" + id + " already exists. Cannot add");
			return null;
		}
		else
		{
			Doctor d = new Doctor(id, firstName, lastName);
			doctorRepository.save(d);
			System.out.println(d.toString());
			return d;
		}
	}

	
	public List<Doctor> getAllDoctors() throws Exception
	{
		List<Doctor> doctors = doctorRepository.findAll();
		if(doctors == null)
		{
			throw new Exception("Doctor Not found");
		}
		return doctors;
	}
	

}
