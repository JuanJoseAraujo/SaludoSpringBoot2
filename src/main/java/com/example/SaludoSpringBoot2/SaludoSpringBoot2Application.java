package com.example.SaludoSpringBoot2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SaludoSpringBoot2Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SaludoSpringBoot2Application.class, args);

		LaptopRepository repositorio = context.getBean(LaptopRepository.class);

		Laptop laptop = new Laptop(null, 14.5f, 4000, "AMD");
		Laptop laptop1 = new Laptop(null, 13f, 2000, "INTEL");

		repositorio.save(laptop);
		repositorio.save(laptop1);

	}


}
