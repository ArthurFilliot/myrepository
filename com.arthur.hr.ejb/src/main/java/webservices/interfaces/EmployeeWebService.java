package webservices.interfaces;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import entities.Employee;

@WebService
@SOAPBinding(style=Style.DOCUMENT,use=Use.LITERAL)
public interface EmployeeWebService {
	void helloWorld(); 
	Employee get(); 
}
 