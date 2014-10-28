package entities;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class  LocalPersistenceTest {

	@Test
	public void test() {
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("ejbunitlocal");
		    EntityManager em = factory.createEntityManager();
		    List<Employee> lstE = em.createNamedQuery("Employee.findAll",Employee.class).getResultList();
		    System.out.println(Arrays.deepToString(lstE.toArray()));
		}catch(javax.persistence.PersistenceException e) {
			e.printStackTrace();
			fail("PersistenceException : " + e.getMessage());
		}catch(Exception e) {
			e.printStackTrace();
			fail("Exception : " + e.getMessage());
		}
	}
	
	@Test
	public void jdbcConnection() {
		System.out.println("-------- Oracle JDBC Connection Testing ------");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			fail("Where is your Oracle JDBC Driver?");
			System.out.println("Where is your Oracle JDBC Driver?");
			e.printStackTrace();
			return;
		}
		System.out.println("Oracle JDBC Driver Registered!");
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:orcl", "hr",
					"pwd4dba");
		} catch (SQLException e) {
			fail("Connection Failed! Check output console");
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}
		
		if (connection == null) {
			fail("Failed to make connection!");
			System.out.println("Failed to make connection!");
		}
		System.out.println("You made it, take control your database now!");
	}
}
