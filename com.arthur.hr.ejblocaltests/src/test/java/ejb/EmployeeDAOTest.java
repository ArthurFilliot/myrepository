package ejb;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import mybeans.interfaces.EmployeeDAOLocal;
import mybeans.interfaces.EmployeeDAORemote;

import org.junit.BeforeClass;
import org.junit.Test;

import entities.Employee;

public class EmployeeDAOTest {

	private static Context ctx;
	private static EmployeeDAORemote employeeDAO;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Properties p = new Properties();
		p.put(Context.INITIAL_CONTEXT_FACTORY,
				"org.apache.openejb.core.LocalInitialContextFactory");
		// p.put("hrdatasource", "new://Resource?type=DataSource");
		// p.put("hrdatasource.JdbcDriver", "oracle.jdbc.OracleDriver");
		// p.put("hrdatasource.JdbcUrl",
		// "jdbc:oracle:thin:@127.0.0.1:1521:orcl");
		// p.put("hrdatasource.UserName", "hr");
		// p.put("hrdatasource.Password", "pwd4dba");
		// p.put("hrdatasource.JtaManaged", "true");

		ctx = new InitialContext(p);

		employeeDAO = (EmployeeDAORemote) ctx.lookup("EmployeeDAO");
	}

	@Test()
	public void testGetAll() {
		List<Employee> lst = employeeDAO.getAll();
		assertTrue(lst.size() > 0);
	}
	
	@Test()
	public void testGet() {
		Employee e = employeeDAO.get(Long.valueOf(100L));
		assertNotNull(e);
	}
	
	@Test()
	public void testSave() {
		System.out.println("*****");
		Employee e = employeeDAO.get(Long.valueOf(100L));
		e.setFirstname("Stephenson");
		employeeDAO.save(e);
//		e = employeeDAO.get(Long.valueOf(100L));
		e = employeeDAO.get(100L);
		assertTrue("Stephenson".equals(e.getFirstname()));
		System.out.println("*****");
	}
	

}
