package com.arthur.hr.front.batch;

import java.io.Serializable;

public abstract class AbstractWriterRecord<T extends Serializable> {

	private T wrapped;

	public T getWrapped() {
		return wrapped;
	}

	public void setWrapped(T wrapped) {
		this.wrapped = wrapped;
	}

}
