package webservices;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import mybeans.interfaces.EmployeeDAORemote;
import webservices.interfaces.EmployeeWebService;
import entities.Employee;

@Stateless
@WebService(endpointInterface="webservices.interfaces.EmployeeWebService")
@Remote(EmployeeWebService.class)
public class EmployeeService implements Serializable {

	private static final long serialVersionUID = 4515069634617419366L;
	
	@EJB
	EmployeeDAORemote dao;
	
	@PersistenceContext
	EntityManager em;
	
	@WebMethod(operationName="helloworld")
	public void helloWorld() {
		System.out.println("*********helloworld*************");
	}
	
	@WebMethod(operationName="get")
	public Employee get() {
		System.out.println(("*********start***********"));
		if (dao==null) {
			System.out.println(("*********cannot get dao***********"));
			return null;
		}
		System.out.println(("*********dao is not null***********"));
//		Employee e = dao.get(Long.valueOf(100L)); 
		System.out.println(("*********try to get em***********"));
		if (em==null) {
			System.out.println(("*********em is null***********"));
			return null;
		}
		System.out.println(("*********em is not null***********"));
		em.isOpen();
//		System.out.println(("*********em is accessible***********"));
//		System.out.println(("*********employee is " + e +" ***********"));
		return dao.get(100L);
	}

}
