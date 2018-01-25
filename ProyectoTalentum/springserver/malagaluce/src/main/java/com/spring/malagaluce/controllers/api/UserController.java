package com.spring.malagaluce.controllers.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.malagaluce.models.User;
import com.spring.malagaluce.repositories.UserRepository;
import com.spring.malagaluce.util.CustomErrorType;

@RestController
@RequestMapping("api/user")
public class UserController {

	 public static final Logger logger = LoggerFactory.getLogger(UserController.class);
	 
	
	@Autowired
	UserRepository userRepository;
	
	// -------------------Retrieve All Users---------------------------------------------
	 
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Iterable<User>> user() {
	        Iterable<User> users = userRepository.findAll();	        
	        if (!users.iterator().hasNext()) {
	            return new ResponseEntity(HttpStatus.NO_CONTENT);
	            // You many decide to return HttpStatus.NOT_FOUND
	        }
	        return new ResponseEntity<Iterable<User>>(users, HttpStatus.OK);
	}

	 // -------------------Create a User-------------------------------------------
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<?> save(@RequestBody User user) {
		logger.info("Creating User : {}", user);
		
		if(userRepository.exists(user.getId())) {
			logger.error("Unable to create. A User with name {} already exist", user.getName()); //hacer archivo de configuración con textos
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("Unable to create. A User with name " + 
            user.getName() + " already exist."),HttpStatus.CONFLICT);
		}
		userRepository.save(user);
		
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}
	
	// -------------------Retrieve Single User------------------------------------------	 
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public ResponseEntity<?> show(@PathVariable String id) {
		logger.info("Fetching User with id {}", id);
        User user = userRepository.findOne(id);
        if (user == null) {
            logger.error("User with id {} not found.", id);
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("User with id " + id 
                    + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	// ------------------- Update a User ------------------------------------------------
	 
	@RequestMapping(method=RequestMethod.PUT, value="/{id}")
	 public ResponseEntity<?> update(@PathVariable String id, @RequestBody User user) {
		 logger.info("Updating User with id {}", id);
		 User us = userRepository.findOne(id);
		 if(us == null) {
			 logger.error("Unable to update. User with id {} not found.", id);
	            return new ResponseEntity<CustomErrorType>(new CustomErrorType("Unable to upate. User with id " + id + " not found."),
	                    HttpStatus.NOT_FOUND);
		 }
		
		us.setMail(user.getMail());
		us.setName(user.getName());
		us.setPassword(user.getPassword());
		us.setPoints(user.getPoints());
		us.setJoindate(user.getJoindate());
		us.setUsername(user.getUsername());
		us.setSuperuser(user.isSuperuser());
		userRepository.save(us);
		return new ResponseEntity<User>(us, HttpStatus.OK);
	 }
	 
	// ------------------- Delete a User-----------------------------------------
	 
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	    public ResponseEntity<?> delete(@PathVariable String id) {
		 	logger.info("Fetching & Deleting User with id {}", id);
	        User user= userRepository.findOne(id);
	        if(user == null) {
	        	logger.error("Unable to delete. User with id {} not found.", id);
	            return new ResponseEntity<CustomErrorType>(new CustomErrorType("Unable to delete. User with id " + id + " not found."),
	                    HttpStatus.NOT_FOUND);
	        }
	        userRepository.delete(user);

	        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	    }
}
