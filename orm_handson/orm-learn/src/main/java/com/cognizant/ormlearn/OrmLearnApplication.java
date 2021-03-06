package com.cognizant.ormlearn;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.jdbc.Sql;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;

@SpringBootApplication
@Sql({"/schema.sql", "/data.sql"})
public class OrmLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
	private static CountryService countryService;

	public static void main(String[] args) throws CountryNotFoundException {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		countryService = context.getBean(CountryService.class);
		testGetAllCountries();
		testGetCountry();
		testAddCountry();
		testUpadateCountry();
		testDeleteCountry();
		LOGGER.info("Inside main");
	}

	public static void testGetAllCountries() {
		LOGGER.info("Start");
		List<Country> countries = countryService.getAllCountries();
		LOGGER.debug("countries={}", countries);
		LOGGER.info("End");
	}

	public static void testGetCountry() throws CountryNotFoundException {
		LOGGER.info("Start");
		Country country = countryService.findCountryByCode("IN");
		LOGGER.debug("Country:{}", country);
		LOGGER.info("End");

	}
	
	public static void testAddCountry() throws CountryNotFoundException{
		LOGGER.info("Start");
		Country country1 = new Country();
		country1.setCode("SS");
		country1.setName("South Sudan");
		countryService.addCountry(country1);
		Country country2 = countryService.findCountryByCode("SS");
		LOGGER.debug("Country:{}", country2);
		LOGGER.info("End");
	}
	
	public static void testUpadateCountry() throws CountryNotFoundException {
		LOGGER.info("Start");
		countryService.updateCountry("SS", "Kingdom of South Sudan");
		LOGGER.info("SS updated");
		Country country = countryService.findCountryByCode("SS");
		LOGGER.debug("Country:{}", country);
		LOGGER.info("End");
	}
	
	public static void testDeleteCountry() {
		LOGGER.info("Start");
		countryService.deleteCountry("SS");
		LOGGER.info("SS deleted");
		testGetAllCountries();
		LOGGER.info("End");
	}
}
