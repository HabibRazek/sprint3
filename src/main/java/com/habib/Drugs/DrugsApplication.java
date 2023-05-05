package com.habib.Drugs;

import com.habib.Drugs.Service.DrugService;
import com.habib.Drugs.entities.Drug;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DrugsApplication  {
	@Autowired
	DrugService drugService;
	public static void main(String[] args) {
		SpringApplication.run(DrugsApplication.class, args);
	}
	//@Override
	//public void run(String... args) throws Exception {
		//drugService.saveDrug(new Drug());
		//drugService.saveDrug(new Drug());
		//drugService.saveDrug(new Drug());

	}



