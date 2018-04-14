package com.arthur.hr.front.batch.locations;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.common.collect.Lists;

public class TestSQLWriters {

	private static ApplicationContext context;
	
	@BeforeClass
	public static void init() {
		String[] springConfig  =  { "context_front_jobs.xml" };  
		context = new ClassPathXmlApplicationContext(springConfig);
	}
	
	@Test
	public void testRegionsWriter() throws Exception {
		JdbcBatchItemWriter writer = (JdbcBatchItemWriter)context.getBean("regionlItemSqlWriter");
		RegionDTO region = new RegionDTO();
		region.setId(35);
		region.setName("Encelade");
		writer.write(Lists.newArrayList(region));
	}
	
	@Test
	public void testCountryWriter() throws Exception {
		JdbcBatchItemWriter writer = (JdbcBatchItemWriter)context.getBean("countrylItemSqlWriter");
		CountryDTO country = new CountryDTO();
		country.setId("XX");
		country.setName("Pfff");
		country.setRegionId(35);
		writer.write(Lists.newArrayList(country));
	}
	
	@Test
	public void testLocationsWriter() throws Exception {
		JdbcBatchItemWriter writer = (JdbcBatchItemWriter)context.getBean("locationlItemSqlWriter");
		LocationDTO location = new LocationDTO();
		location.setId(35);
		location.setPostalcode("35896");
		location.setCity("Blabla");
		location.setStateprovince("Bloblo");
		location.setStreetaddress("toto");
		location.setCountryId("XX");
		writer.write(Lists.newArrayList(location));
	}

}
