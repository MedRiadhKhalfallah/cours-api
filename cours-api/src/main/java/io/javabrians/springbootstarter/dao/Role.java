package io.javabrians.springbootstarter.dao;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Role {
	@Id
	private String role;
	private String desciption;
	
	public Role(String role, String desciption) {
		super();
		this.role = role;
		this.desciption = desciption;
	}
	public Role() {

	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getDesciption() {
		return desciption;
	}
	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}

	

}
