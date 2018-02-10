package io.javabrians.springbootstarter.dao;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name="users")
public class User{
	@Id
	private String name;
	private String password;
	private Boolean actived;
	@ManyToMany
	@JoinTable(name="USERS_ROLES")
	private Collection<Role> roles;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPaswword() {
		return password;
	}

	public void setPaswword(String paswword) {
		this.password = paswword;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}


	public Boolean getActived() {
		return actived;
	}

	public void setActived(Boolean actived) {
		this.actived = actived;
	}

	public User(String name, String paswword, Boolean actived, Collection<Role> roles) {
		super();
		this.name = name;
		this.password = paswword;
		this.actived = actived;
		this.roles = roles;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
