package com.shahana.notable.takehome.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.shahana.notable.takehome.domain.Doctor;

@RepositoryRestResource(exported = false)
public interface DoctorRepository extends JpaRepository<Doctor, Integer>
{

}
