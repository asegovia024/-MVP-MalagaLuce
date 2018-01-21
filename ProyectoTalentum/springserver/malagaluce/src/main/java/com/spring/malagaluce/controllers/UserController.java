package com.spring.malagaluce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.malagaluce.models.User;
import com.spring.malagaluce.repositories.UserRepository;


@RestController
public class UserController {

	@Autowired
	UserRepository userRepository;
	
	
	@RequestMapping(method=RequestMethod.GET, value="/users")
	public Iterable<User> user() {
		
		 return userRepository.findAll();
	}

	@RequestMapping(method=RequestMethod.POST, value="/users")
	public String save(@RequestBody User user) {
		userRepository.save(user);
		return user.getId();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/users/{id}")
	public User show(@PathVariable String id) {
		return userRepository.findOne(id);		
	}
	 @RequestMapping(method=RequestMethod.PUT, value="/users/{id}")
	 public User update(@PathVariable String id, @RequestBody User user) {
		 User us= userRepository.findOne(id);
		 if(user.getMail() != null)
			 us.setMail(user.getMail());
		 if(user.getName() != null)
			 us.setName(user.getName());
		 if(user.getPassword() != null)
			 us.setPassword(user.getPassword());
		 if(user.getPoints() != -1)
			 us.setPoints(user.getPoints());
		 if(user.getJoindate() != null)
			 us.setJoindate(user.getJoindate());
		 if(user.getUsername() != null)
			 us.setUsername(user.getUsername());
		 if(user.isSuperuser())
			 us.setSuperuser(user.isSuperuser());
		 return us;
	 }
	 @RequestMapping(method=RequestMethod.DELETE, value="/users/{id}")
	    public String delete(@PathVariable String id) {
	        User user= userRepository.findOne(id);
	        userRepository.delete(user);

	        return "user deleted";
	    }
}
