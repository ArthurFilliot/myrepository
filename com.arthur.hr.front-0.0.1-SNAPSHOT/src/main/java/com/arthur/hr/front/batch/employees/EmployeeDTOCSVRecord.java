package com.arthur.hr.front.batch.employees;

import com.arthur.hr.front.batch.AbstractWriterRecord;

@SuppressWarnings("serial")
public class EmployeeDTOCSVRecord extends AbstractWriterRecord<EmployeeDTO> {

	@Override
	public String toString() {
		return "\"" + getWrapped().getFirstName() + "\";\"" + getWrapped().getLastName() + "\";\"" + getWrapped().getEmail() + "\"";
	}

}
