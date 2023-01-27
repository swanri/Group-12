package net.javaguides.springboot.dto;

public class UserRegistrationDto {
	private String firstName;
	private String lastName;
	private String employeeid;
	private String password;
	
	public UserRegistrationDto(){
		
	}
	
	public UserRegistrationDto(String firstName, String lastName, String employeeid, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.employeeid = employeeid;
		this.password = password;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public String getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public CharSequence getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	//public String getEmployeeid() {
		// TODO Auto-generated method stub
		//return null;
	//}
}
