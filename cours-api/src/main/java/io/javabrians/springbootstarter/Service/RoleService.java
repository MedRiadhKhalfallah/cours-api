package io.javabrians.springbootstarter.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.javabrians.springbootstarter.Repository.RoleRepository;
import io.javabrians.springbootstarter.dao.Role;

@Service
public class RoleService {
	
	@Autowired
	private RoleRepository roleRepository;
	
	public List<Role> getAllRoles()
	{
		List<Role> roles= new ArrayList<>();
		roleRepository.findAll().forEach(roles::add);
			return roles;
	}

	
	public void addRole(Role role)
	{
		roleRepository.save(role);
	}
	
}
