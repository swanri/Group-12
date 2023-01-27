package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "work_details")

public class WorkDetails {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private long id;
	
	
	@Column(name = "empid")
	private long empid;

	@Column(name = "qualification")
	private String qualification;
	

	
	@Column(name = "work_experience")
	private String workexperience;
	
	
	@Column(name = "office_location")
	private String officelocation;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}
	
	public long getEmpid() {
		return empid;
	}


	public void setEmpid(long empid) {
		this.empid = empid;
	}

	public String getQualification() {
		return qualification;
	}


	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	
	

	


	public String getWorkexperience() {
		return workexperience;
	}


	public void setWorkexperience(String workexperience) {
		this.workexperience = workexperience;
	}


	public String getOfficelocation() {
		return officelocation;
	}


	public void setOfficelocation(String officelocation) {
		this.officelocation = officelocation;
	}
}	
	
	
	
	
	
