package io.javabrians.springbootstarter.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.javabrians.springbootstarter.Repository.RoleRepository;
import io.javabrians.springbootstarter.Repository.UserRepository;
import io.javabrians.springbootstarter.dao.Role;
import io.javabrians.springbootstarter.dao.User;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	public List<User> getAllUsers()
	{
		List<User> users= new ArrayList<>();
		userRepository.findAll().forEach(users::add);
			return users;
	}

	
	public void addUser(User user)
	{
		userRepository.save(user);
	}
	
	public User addRoleToUser(String username, String role)
	{
		User u= userRepository.findById(username).get();
		Role r=roleRepository.findById(role).get();
		u.getRoles().add(r);
		userRepository.save(u);
		return u;
	}
	
}
