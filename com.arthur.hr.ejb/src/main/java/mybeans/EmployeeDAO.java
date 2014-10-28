package mybeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
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
    

	public List<Employee> getAll() {
		return em.createNamedQuery("Employee.findAllDatas",Employee.class).getResultList();
	}
	
	public Employee get(Long id) {
		System.out.println(("*********start dao.get***********"));
		if (id==null) return null;
		if (em==null) {
			System.out.println(("*********em is NULL***********"));
			return null;
		}
		System.out.println(("*********em is NOT NULL***********")); 
		System.out.println(("********* isOpen:" + em.isOpen() + "***********"));
		Employee e = em.find(Employee.class, id);
		System.out.println(("*********employee is "+ e + "***********"));
		em.detach(e);
		return e;
	}

	public void save(Employee e) {
		if (e==null) return;
		em.merge(e);
	}

}
