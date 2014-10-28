package mybeans.interfaces;

import java.util.List;

import entities.Employee;

public interface EmployeeDAORemote {
	List<Employee> getAll();
	Employee get(Long id);
	void save(Employee e);
}
