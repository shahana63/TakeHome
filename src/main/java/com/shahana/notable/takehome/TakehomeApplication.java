package com.shahana.notable.takehome;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.shahana.notable.takehome.services.DoctorService;

@SpringBootApplication
public class TakehomeApplication implements CommandLineRunner{

	@Autowired
	private DoctorService doctorService;
	public static void main(String[] args) 
	{
		SpringApplication.run(TakehomeApplication.class, args);
	}
	
	
	@Override
	public void run(String... args) throws Exception 
	{
		doctorService.createDoctor(1, "Julious", "Hibbert");
		doctorService.createDoctor(2, "Algemop", "Krieger");
		doctorService.createDoctor(3, "Nick", "Riviera");
		
		System.out.println("Doctors created");
	}

}
