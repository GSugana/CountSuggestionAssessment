package com.suggest.county;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.suggest.county.entity.CountySuggestion;
import com.suggest.county.service.CountySuggestionService;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CountyApplication {

	public static void main(String[] args) {
		SpringApplication.run(CountyApplication.class, args);
	}

	/*
	to load the in-memory H2 database with the json values while loading
	 */
	@Bean
	CommandLineRunner runner(CountySuggestionService countySuggestionService){
		return args -> {
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<CountySuggestion>> typeReference = new TypeReference<>() {};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/data.json");
			try{
			List<CountySuggestion> countySuggestionList = mapper.readValue(inputStream,typeReference);
			countySuggestionService.save(countySuggestionList);
			System.out.println("successfully saved");
			} catch (IOException e){
				System.out.println("issue in saving"+e.getMessage());
			}
		};
	}

}
