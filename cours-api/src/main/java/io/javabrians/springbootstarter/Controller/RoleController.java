package io.javabrians.springbootstarter.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrians.springbootstarter.Service.RoleService;
import io.javabrians.springbootstarter.dao.Role;

@RestController
//@Secured(value= {"ROLE_ADMIN"})
public class RoleController {
	@Autowired
	private RoleService roleService;
	

	@RequestMapping("/roles")
	public List<Role>getAllTopics()
	{
		return roleService.getAllRoles();
	}

	@RequestMapping(method=RequestMethod.POST,value="/roles")
	public void addRole(@RequestBody Role role)
	{
		 roleService.addRole(role);
	}

}
