package com.arthur.hr.front.batch.employees;

import com.arthur.hr.front.batch.AbstractItemProcessor;

public class EmployeeDTOProcessor extends AbstractItemProcessor<EmployeeDTO, EmployeeDTOCSVRecord> {

	@Override
	public EmployeeDTOCSVRecord process(EmployeeDTO item) throws Exception {
		EmployeeDTOCSVRecord record;
		record = new EmployeeDTOCSVRecord();
		record.setWrapped(item);
		return record;
	}
}
