package com.arthur.hr.front.batch.locations;

import java.util.Map;

import org.springframework.batch.item.ItemProcessor;

public class LocationDTOProcessor implements ItemProcessor<LocationDTO, LocationDTO> {

	LocationByCountryIndexBuilder locationsByCountry;
	
	public LocationByCountryIndexBuilder getLocationsByCountry() {
		return locationsByCountry;
	}

	public void setLocationsByCountry(LocationByCountryIndexBuilder locationsByCountry) {
		this.locationsByCountry = locationsByCountry;
	}

	@Override
	public LocationDTO process(LocationDTO item) throws Exception {
		Map<LocationDTO, CountryDTO> index = locationsByCountry.getInvertedIndex();
		CountryDTO country = index.get(item);
		item.setCountryId(country.getId());
		return item;
	}

}
