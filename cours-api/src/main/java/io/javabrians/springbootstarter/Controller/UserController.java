package io.javabrians.springbootstarter.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.javabrians.springbootstarter.Service.UserService;
import io.javabrians.springbootstarter.dao.User;

@RestController
//@Secured(value= {"ROLE_ADMIN"})
public class UserController {
	@Autowired
	private UserService userService;
	

	@RequestMapping("/users")
	public List<User>getAllTopics()
	{		System.out.println("----------------------");

		return userService.getAllUsers();
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/users")
	public void addUser(@RequestBody User user)
	{		System.out.println("****************");
		 userService.addUser(user);
	}
	
	
	@RequestMapping(method=RequestMethod.POST,value="/addRoleToUser")
	public void addRoleToUser(@RequestParam(name="username",defaultValue="") String username,@RequestParam(name="role",defaultValue="") String role)
	{
		userService.addRoleToUser(username, role);
	}

}
