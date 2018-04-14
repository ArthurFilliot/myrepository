package com.arthur.hr.front.batch.locations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.File;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.xml.StaxEventItemReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class TestStaxReaders {

	private static ApplicationContext context;
	
	@BeforeClass
	public static void init() {
		String[] springConfig  =  { "context_front_jobs.xml" };  
		context = new ClassPathXmlApplicationContext(springConfig);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testRegionsReader() throws UnexpectedInputException, ParseException, Exception {		
		StaxEventItemReader<RegionDTO> reader =(StaxEventItemReader<RegionDTO>) context.getBean("regionsXmlItemReader");
		reader.setResource(new FileSystemResource(new File("inputfiles/locations/datas.xml")));
		reader.afterPropertiesSet();
		reader.open(new ExecutionContext());
		RegionDTO o = reader.read();
		assertEquals("Americas", o.getName());
		assertNull( o.getCountries());
		o = reader.read();
		assertEquals("Asia", o.getName());
		reader.close();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testCountriesReader() throws UnexpectedInputException, ParseException, Exception {		
		StaxEventItemReader<CountryDTO> reader =(StaxEventItemReader<CountryDTO>) context.getBean("countriesXmlItemReader");
		reader.setResource(new FileSystemResource(new File("inputfiles/locations/datas.xml")));
		reader.afterPropertiesSet();
		reader.open(new ExecutionContext());
		CountryDTO o = reader.read();
		assertEquals("Brazil", o.getName());
		assertNull( o.getLocations());
		o = reader.read();
		assertEquals("Canada", o.getName());
		reader.close();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testLocationsReader() throws UnexpectedInputException, ParseException, Exception {		
		StaxEventItemReader<LocationDTO> reader =(StaxEventItemReader<LocationDTO>) context.getBean("locationsXmlItemReader");
		reader.setResource(new FileSystemResource(new File("inputfiles/locations/datas.xml")));
		reader.afterPropertiesSet();
		reader.open(new ExecutionContext());
		LocationDTO o = reader.read();
		assertEquals("Sao Paulo", o.getCity());
		o = reader.read();
		assertEquals("Toronto", o.getCity());
		reader.close();
	}

}
