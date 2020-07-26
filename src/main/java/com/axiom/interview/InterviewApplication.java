package com.axiom.interview;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.axiom.interview.service.MobileService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

import com.axiom.interview.domain.Mobile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
@Slf4j
public class InterviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(InterviewApplication.class, args);
	}
	
	@Bean
	CommandLineRunner runner(MobileService mobileService) {
		return args -> {
			// read json and write to db
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Mobile>> typeReference = new TypeReference<List<Mobile>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/static/mobiles.json");
			try {
				List<Mobile> mobiles = mapper.readValue(inputStream,typeReference);
				mobileService.save(mobiles);
				log.info("Users Saved!");
			} catch (IOException e){
				log.error("Unable to save users: ", e);
			}
		};
	}

}
