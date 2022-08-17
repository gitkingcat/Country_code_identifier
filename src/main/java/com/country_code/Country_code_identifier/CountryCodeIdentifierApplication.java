package com.country_code.Country_code_identifier;

import com.country_code.Country_code_identifier.Repository.CountryCodeRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class CountryCodeIdentifierApplication {

	public static void main(String[] args) {
		SpringApplication.run(CountryCodeIdentifierApplication.class, args);
		CountryCodeRepo.initialize();
	}

}
