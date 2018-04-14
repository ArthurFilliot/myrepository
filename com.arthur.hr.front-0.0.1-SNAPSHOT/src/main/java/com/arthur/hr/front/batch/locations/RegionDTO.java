package com.arthur.hr.front.batch.locations;

import java.util.ArrayList;

public class RegionDTO {

		private Integer id;
		
		private String name;
		
		private ArrayList<CountryDTO> countries;
		
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public ArrayList<CountryDTO> getCountries() {
			return countries;
		}
		public void setCountries(ArrayList<CountryDTO> countries) {
			this.countries = countries;
		}
		@Override
		public String toString() {
			return "RegionDTO [id=" + id + ", name=" + name + "]";
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			RegionDTO other = (RegionDTO) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			return true;
		}
		
}
