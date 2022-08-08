package com.example.demo;

import com.example.demo.model.Activity;
import com.example.demo.model.Camper;
import com.example.demo.model.SignUp;
import com.example.demo.repository.ActivityRepository;
import com.example.demo.repository.CamperRepository;
import com.example.demo.repository.SignUpRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class AccessCampAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccessCampAppApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return modelMapper;
	}

	@Bean
	@Transactional
	CommandLineRunner runner(ActivityRepository activityRepository, CamperRepository camperRepository,
							 SignUpRepository signupRepository) {
		return (args) -> {
			Activity archery = activityRepository
					.save(new Activity(1, "Archery", 2, LocalDate.now(), LocalDate.now(), new ArrayList<>()));
			Activity swimming = activityRepository
					.save(new Activity(2, "Swimming", 3, LocalDate.now(), LocalDate.now(), new ArrayList<>()));
			Camper caitlin = camperRepository
					.save(new Camper(1, "Caitlin", 8, LocalDate.now(), LocalDate.now(), new ArrayList<>()));
			Camper lizzie = camperRepository
					.save(new Camper(2, "Lizzie", 9, LocalDate.now(), LocalDate.now(), new ArrayList<>()));
			SignUp archerySignup = signupRepository
					.save(new SignUp(1, 9, LocalDate.now(), LocalDate.now(), caitlin,archery));
			SignUp swimmingSignup = signupRepository
					.save(new SignUp(2, 10, LocalDate.now(), LocalDate.now(), caitlin,swimming));
			archery.setSignup(List.of(archerySignup, swimmingSignup));
			caitlin.setSignUps(List.of(archerySignup, swimmingSignup));
		};
	}
}
