package mybeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import mybeans.interfaces.EmployeeDAORemote;
import entities.Employee;

@Stateless(mappedName="EmployeeDAO")
@Remote(EmployeeDAORemote.class)
@PersistenceContext(unitName="ejbunit", name="persistence/em")
public class EmployeeDAO implements Serializable {

	private static final long serialVersionUID = -8972182730422563365L;
	
	@PersistenceContext(unitName="ejbunit")
	EntityManager em;
	
    public EmployeeDAO() {
    }
    
    private EntityManager getEm() {
//    	InitialContext ic;
//		try {
////			ic = new InitialContext();
////			EntityManager em =(EntityManager) ic.lookup("java:comp/env/persistence/em");
////			System.out.println(("*********Entity Manager retrievied***********"));
//			return em;
//		} catch (NamingException e) {
//			System.out.println(("*********Entity Manager not found***********"));
//			e.printStackTrace();
//		}
    	return em;
    }

	public List<Employee> getAll() {
		return getEm().createNamedQuery("Employee.findAllDatas",Employee.class).getResultList();
	}
	
	public Employee get(Long id) {
		System.out.println(("*********start dao.get***********"));
		if (id==null) return null;
		if (getEm()==null) {
			System.out.println(("*********em is NULL***********"));
			return null;
		}
		System.out.println(("*********em is NOT NULL***********")); 
		System.out.println(("********* isOpen:" + getEm().isOpen() + "***********"));
		Employee e = getEm().find(Employee.class, id);
		System.out.println(("*********employee is "+ e + "***********"));
		getEm().detach(e);
		return e;
	}

	public void save(Employee e) {
		if (e==null) return;
		getEm().merge(e);
	}

}
