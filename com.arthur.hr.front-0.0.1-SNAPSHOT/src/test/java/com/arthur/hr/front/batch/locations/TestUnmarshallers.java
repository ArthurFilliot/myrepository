package com.arthur.hr.front.batch.locations;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.oxm.xstream.XStreamMarshaller;

public class TestUnmarshallers {
		
	private LocationsDTO process(String marshaller) {
		try {
			String[] springConfig  =  { "context_front_jobs.xml" };  
			ApplicationContext context = new ClassPathXmlApplicationContext(springConfig);
			XStreamMarshaller stream = (XStreamMarshaller) context.getBean(marshaller); 
			Reader r = new InputStreamReader(new FileInputStream(new File("inputfiles/locations/datas.xml").getAbsolutePath()), "UTF-16");
			return (LocationsDTO)stream.getXStream().fromXML(r);
		} catch (UnsupportedEncodingException | FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Test
	public void testUnmarshallRegions()  {
			LocationsDTO result = process("regionsUnmarshaller");
			assertEquals(3,result.getRegions().size());
			assertEquals("Americas", result.getRegions().get(0).getName());
	}
	
	@Test
	public void testUnmarshallCountries()  {
			LocationsDTO result = process("countriesUnmarshaller");
			assertEquals(3,result.getRegions().size());
			assertEquals(4,result.getRegions().get(0).getCountries().size());
			CountryDTO country = result.getRegions().get(0).getCountries().get(0);
			assertEquals("Brazil", country.getName());
			assertEquals("BR", country.getId());
	}
	
	@Test
	public void testUnmarshallLocations()  {
			LocationsDTO result = process("locationsUnmarshaller");
			assertEquals(3,result.getRegions().size());
			assertEquals(4,result.getRegions().get(0).getCountries().size());
			assertEquals(1,result.getRegions().get(0).getCountries().get(0).getLocations().size());
			LocationDTO loc = result.getRegions().get(0).getCountries().get(0).getLocations().get(0);
			assertEquals(2800,loc.getId());
			assertEquals("Sao Paulo",loc.getCity());
			assertEquals("Sao Paulo",loc.getStateprovince());
			assertEquals("01307-002",loc.getPostalcode());
			assertEquals("Rua Frei Caneca 1360 ",loc.getStreetaddress());
	}

}


