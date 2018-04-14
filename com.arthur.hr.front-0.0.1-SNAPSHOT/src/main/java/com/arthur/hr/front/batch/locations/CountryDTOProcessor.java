package com.arthur.hr.front.batch.locations;

import java.util.Map;

import org.springframework.batch.item.ItemProcessor;

public class CountryDTOProcessor implements ItemProcessor<CountryDTO, CountryDTO> {

	CountryByRegionIndexBuilder countriesByRegion;

	public CountryByRegionIndexBuilder getCountriesByRegion() {
		return countriesByRegion;
	}

	public void setCountriesByRegion(CountryByRegionIndexBuilder countriesByRegion) {
		this.countriesByRegion = countriesByRegion;
	}

	@Override
	public CountryDTO process(CountryDTO item) throws Exception {
		Map<CountryDTO, RegionDTO> index  =countriesByRegion.getInvertedIndex();
		RegionDTO region = index.get(item);
		item.setRegionId(region.getId());
		return item;
	}

}
