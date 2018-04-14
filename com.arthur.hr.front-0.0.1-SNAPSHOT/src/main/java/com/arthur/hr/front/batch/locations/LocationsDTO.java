package com.arthur.hr.front.batch.locations;

import java.util.ArrayList;

public class LocationsDTO {

	private ArrayList<RegionDTO> regions;
	
	private ArrayList<CountryDTO> countries;
	
	private ArrayList<LocationDTO> locations;

	public ArrayList<RegionDTO> getRegions() {
		return regions;
	}
	
	public ArrayList<CountryDTO> getCountries() {
		return countries;
	}
	
	public void setCountries(ArrayList<CountryDTO> countries) {
		this.countries = countries;
	}
	
	public ArrayList<LocationDTO> getLocations() {
		return locations;
	}

	public void setLocations(ArrayList<LocationDTO> locations) {
		this.locations = locations;
	}

	public void setRegions(ArrayList<RegionDTO> regions) {
		this.regions = regions;
	}

	@Override
	public String toString() {
		String s=null;
		if (regions!=null) {
			s="LocationsDTO [regions=" + regions + "]";
		}
		if (countries!=null) {
			s="LocationsDTO [countries=" + countries + "]";
		}
		if (locations!=null) {
			s="LocationsDTO [locations=" + locations + "]";
		}
		return s;
	}
	
}
