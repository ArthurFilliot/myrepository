package com.arthur.hr.front.batch.locations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;

public class CountryByRegionIndexBuilder {
	
		private Multimap<RegionDTO, CountryDTO> index;
		private Map<CountryDTO, RegionDTO> invertedIndex = new HashMap<CountryDTO, RegionDTO>();

	    public Multimap<RegionDTO, CountryDTO> getIndex() {
	    	if (index==null && invertedIndex.size()>0) {
	    		index = Multimaps.invertFrom(Multimaps.forMap(invertedIndex), ArrayListMultimap.create());
	    	}
			return index;
		}

	    public Map<CountryDTO, RegionDTO> getInvertedIndex() {
			return invertedIndex;
		}

		//TODO:factorize in a AbstractIndexBuilder class
		public void  build(String fileName) {
	        RegionDTO currentRegion=null;
	        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
	        try {
	            XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream(fileName));
	            while(xmlEventReader.hasNext()){
	               XMLEvent xmlEvent = xmlEventReader.nextEvent();
	               if (xmlEvent.isStartElement()){
	                   StartElement startElement = xmlEvent.asStartElement();
	                   if(startElement.getName().getLocalPart().equals("REGION")) {
	                       Attribute idAttr = startElement.getAttributeByName(new QName("id"));
	                       if(idAttr != null){
	                    	   currentRegion = new RegionDTO();
	                    	   currentRegion.setId(Integer.parseInt(idAttr.getValue()));
	                       }
	                   }
	                   else if(startElement.getName().getLocalPart().equals("COUNTRY")){
	                	   Attribute idAttr = startElement.getAttributeByName(new QName("id"));
	                	   if(currentRegion!=null && idAttr != null){
	                    	   CountryDTO currentCountry = new CountryDTO();
	                    	   currentCountry.setId(idAttr.getValue());
	                    	   invertedIndex.put(currentCountry, currentRegion);
	                       }
//	                       Integer.parseInt(xmlEvent.asCharacters().getData());
	                   }
	               }
	            }
	        } catch (FileNotFoundException | XMLStreamException e) {
	            e.printStackTrace();
	        }
	    }
}
