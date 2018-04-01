package com.arthur.hr.front.batch;

import java.io.Serializable;

import org.springframework.batch.item.ItemProcessor;

public abstract class AbstractItemProcessor<E extends Serializable,T extends AbstractWriterRecord<? extends Serializable>> implements ItemProcessor<E,T> {	 
	
		   @SuppressWarnings("unchecked")
		   @Override 
		   public T process(E item) throws Exception { 
		      System.out.println("Processing..." + item); 
		      return (T)item; 
		   } 
}
