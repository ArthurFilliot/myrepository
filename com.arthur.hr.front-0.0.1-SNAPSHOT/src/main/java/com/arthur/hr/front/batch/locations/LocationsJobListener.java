package com.arthur.hr.front.batch.locations;

import java.io.File;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class LocationsJobListener implements JobExecutionListener {

	CountryByRegionIndexBuilder countriesByRegion;
	LocationByCountryIndexBuilder locationsByCountry;
	
	public CountryByRegionIndexBuilder getCountriesByRegion() {
		return countriesByRegion;
	}

	public void setCountriesByRegion(CountryByRegionIndexBuilder countriesByRegion) {
		this.countriesByRegion = countriesByRegion;
	}

	public LocationByCountryIndexBuilder getLocationsByCountry() {
		return locationsByCountry;
	}

	public void setLocationsByCountry(LocationByCountryIndexBuilder locationsByCountry) {
		this.locationsByCountry = locationsByCountry;
	}

	@Override
	public void beforeJob(JobExecution arg0) {
		countriesByRegion.build(new File("inputfiles/locations/datas.xml").getAbsolutePath());
		locationsByCountry.build(new File("inputfiles/locations/datas.xml").getAbsolutePath());
	}

	@Override
	public void afterJob(JobExecution arg0) {
		// TODO Auto-generated method stub
	}

}
