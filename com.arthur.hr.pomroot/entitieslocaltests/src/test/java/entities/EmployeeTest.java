package entities;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.BeforeClass;
import org.junit.Test;

public class EmployeeTest {
	
	private static EntityManager em;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("ejbunitlocal");
		    em = factory.createEntityManager(); 
		}catch(javax.persistence.PersistenceException e) {
			e.printStackTrace();
			fail("PersistenceException : " + e.getMessage());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void findAlltest() {
		try {
			List<Employee> lstE = em.createNamedQuery("Employee.findAll",Employee.class).getResultList();
			assertTrue(lstE.size()>0);
		    System.out.println(Arrays.deepToString(lstE.toArray()));
		}catch(Exception e) {
			e.printStackTrace();
			fail("Exception : " + e.getMessage());
		}
	}
	
	@Test
	public void getJobTest() {
		try {
			List<Employee> lstE = em.createNamedQuery("Employee.findAll",Employee.class).getResultList();
			Job job = lstE.get(0).getJob();
			assertNotNull(job);
			System.out.println(job);
		}catch(Exception e) {
			e.printStackTrace();
			fail("Exception : " + e.getMessage());
		}
	}
	
	@Test
	public void findAllWithDataTest() {
		try {
			List<Employee> lstE = em.createNamedQuery("Employee.findAllDatas",Employee.class).getResultList();
			Job job = lstE.get(0).getJob();
			assertTrue(lstE.size()>0);
			assertNotNull(job);
			System.out.println(lstE.get(0) + "(" + job + ")");
		}catch(Exception e) {
			e.printStackTrace();
			fail("Exception : " + e.getMessage());
		}
	}
	
	@Test
	public void saveTest() {
		System.out.println("****");
		Employee e = em.find(Employee.class, 100L);
		e.setFirstname("Adolf");
		em.merge(e);
		assertTrue("Adolf".equals(e.getFirstname()));
		System.out.println("****");
	}

}
