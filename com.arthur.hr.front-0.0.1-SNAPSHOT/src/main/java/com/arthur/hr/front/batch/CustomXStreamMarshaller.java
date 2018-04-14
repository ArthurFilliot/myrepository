package com.arthur.hr.front.batch;

import java.io.IOException;
import java.io.Reader;
import java.util.Map;

import javax.xml.transform.Result;

import org.springframework.oxm.XmlMappingException;
import org.springframework.oxm.xstream.XStreamMarshaller;

import com.thoughtworks.xstream.MarshallingStrategy;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.DataHolder;

public class CustomXStreamMarshaller extends XStreamMarshaller {
	
	private Map<Class<?>, String> myImplicitCollections;
	
	@Override
	protected XStream constructXStream() {
		XStream x =  new XStream() {

			@Override
			public void setMarshallingStrategy(MarshallingStrategy marshallingStrategy) {
				// TODO Auto-generated method stub
				super.setMarshallingStrategy(marshallingStrategy);
			}
			
		};
		x.ignoreUnknownElements();
		return x;
	}

	@Override
	protected void marshalStaxResult(Object graph, Result staxResult) throws XmlMappingException {
		// TODO Auto-generated method stub
		super.marshalStaxResult(graph, staxResult);
	}
	
	@Override
	public void setImplicitCollections(Map<Class<?>, String> implicitCollections) {
		super.setImplicitCollections(implicitCollections);
		myImplicitCollections = implicitCollections;
	}

	@Override
	public Object unmarshalReader(Reader reader, DataHolder dataHolder) throws XmlMappingException, IOException {
		Object o = super.unmarshalReader(reader, dataHolder);
		for (Map.Entry<Class<?>, String> implicitCollection : myImplicitCollections.entrySet()) {
			
		}
		return o;
	}

	
	
	
	
	
}