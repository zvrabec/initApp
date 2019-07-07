package com.initapp.activitiesApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InitAppApplication implements CommandLineRunner{
	
	@Autowired    
	private ActivityRepository activityRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(InitAppApplication.class, args);
		
	}
	@Override
	public void run(String... args) throws Exception{
		activityRepo.save(new Activity("aktivnost 1", "kategorija 1", "podkategorija 1"));
		activityRepo.save(new Activity("aktivnost 2", "kategorija 2", "podkategorija 2"));
		activityRepo.save(new Activity("aktivnost 3", "kategorija 3", "podkategorija 3"));
		activityRepo.save(new Activity("aktivnost 4", "kategorija 4", "podkategorija 4"));
		activityRepo.save(new Activity("aktivnost 5", "kategorija 5", "podkategorija 5"));
		activityRepo.save(new Activity("aktivnost 6", "kategorija 6", "podkategorija 6"));
	}

}
