package mybeans.interfaces;

import java.util.List;
import javax.ejb.Local;
import entities.Employee;

@Local
public interface EmployeeDAOLocal {
	List<Employee> getAll();
	Employee get(Long id);
	void save(Employee e);
}
