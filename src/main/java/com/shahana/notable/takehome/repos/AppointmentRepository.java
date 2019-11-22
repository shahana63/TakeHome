package com.shahana.notable.takehome.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.shahana.notable.takehome.domain.Appointment;

@RepositoryRestResource(exported = false)
public interface AppointmentRepository extends JpaRepository<Appointment, Integer>
{
	List<Appointment> findByDoctorId(Integer doctorId);
	Appointment findByDoctorIdAndId(Integer doctorId, Integer appointmentId);
}
