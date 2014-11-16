package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the JOB_HISTORY database table.
 * 
 */
@Entity
@Table(name="JOB_HISTORY")
@NamedQuery(name="JobHistory.findAll", query="SELECT j FROM JobHistory j")
public class JobHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private JobHistoryPK id;

	@Column(name="DEPARTMENT_ID")
	private java.math.BigDecimal departmentId;

	@Temporal(TemporalType.DATE)
	@Column(name="END_DATE")
	private Date endDate;

	@Column(name="JOB_ID")
	private String jobId;

	public JobHistory() {
	}

	public JobHistoryPK getId() {
		return this.id;
	}

	public void setId(JobHistoryPK id) {
		this.id = id;
	}

	public java.math.BigDecimal getDepartmentId() {
		return this.departmentId;
	}

	public void setDepartmentId(java.math.BigDecimal departmentId) {
		this.departmentId = departmentId;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getJobId() {
		return this.jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

}