package com.io.developer.testapp2;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.stream.Stream;

@SpringBootApplication
public class Testapp2Application {

	public static void main(String[] args) {
		SpringApplication.run(Testapp2Application.class, args);
	}

@Bean
	ApplicationRunner init(CarRepository repository) {
		return args -> {
			for (String name : Arrays.asList("Ferrari", "Jaguar", "Porsche", "Lamborghini", "Bugatti",
					"AMC Gremlin", "Triumph Stag", "Ford Pinto", "Yugo GV")) {
				Car car = new Car();
				car.setName(name);
				repository.save(car);
			}
			repository.findAll().forEach(System.out::println);
		};
	}
}
