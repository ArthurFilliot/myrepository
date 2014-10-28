package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * Entity implementation class for Entity: Employee
 *
 */
@Entity
@Table(name="EMPLOYEES")
@DynamicUpdate(value=true)
@NamedQueries({
	@NamedQuery(name="Employee.findAll",query="SELECT e FROM Employee e"),
	@NamedQuery(name="Employee.findAllDatas",query="SELECT e FROM Employee e LEFT JOIN e.job j")
})
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="EMPLOYEE_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="FIRST_NAME")
	private String firstname;
	
	@Column(name="LAST_NAME")
	private String lastname;
	
	@Column(name="EMAIL")
	private String email;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="JOB_ID",nullable=true)
	@Fetch(FetchMode.JOIN)
	private Job job;
	
	public Employee() {
	}
	
	public Long getId() {
		return this.id;
	}

	public void setId(Long Id) {
		this.id = Id;
	}
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	@Override
	public String toString() {
		return firstname + " " + lastname;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
}
