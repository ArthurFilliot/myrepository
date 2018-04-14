package com.arthur.hr.front.batch.locations;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIndexBuilders {

	private static ApplicationContext context;
	
	@BeforeClass
	public static void init() {
		String[] springConfig  =  { "context_front_jobs.xml" };  
		context = new ClassPathXmlApplicationContext(springConfig);
	}
	
	@Test
	public void testCountryByRegionIndexBuilder() {
		CountryByRegionIndexBuilder index = (CountryByRegionIndexBuilder)context.getBean("countryByRegion");
		index.build(new File("inputfiles/locations/datas.xml").getAbsolutePath());
		RegionDTO region = new RegionDTO();
		region.setId(2);
		CountryDTO country = new CountryDTO(); 
		country.setId("CA");
		assertEquals(region, index.getInvertedIndex().get(country));
		assertEquals(4, index.getIndex().get(region).size());
	}
	
	@Test
	public void testLocationByCountryIndexBuilder() {
		LocationByCountryIndexBuilder index = (LocationByCountryIndexBuilder)context.getBean("locationByCountry");
		index.build(new File("inputfiles/locations/datas.xml").getAbsolutePath());
		CountryDTO country = new CountryDTO(); 
		country.setId("CA");
		assertEquals(2, index.getIndex().get(country).size());
	}

}
