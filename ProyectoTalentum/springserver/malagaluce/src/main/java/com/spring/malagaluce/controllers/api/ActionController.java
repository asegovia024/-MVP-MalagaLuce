package com.spring.malagaluce.controllers.api;

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

import com.spring.malagaluce.models.Action;
import com.spring.malagaluce.models.User;
import com.spring.malagaluce.repositories.ActionRepository;
import com.spring.malagaluce.util.CustomErrorType;

@RestController
@RequestMapping("api/actions")
public class ActionController {

	public static final Logger logger = LoggerFactory.getLogger(ActionController.class);
	
	@Autowired
	ActionRepository actionRepository;
	
	// -------------------Retrieve All Actions---------------------------------------------
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Iterable<Action>> action() {
		Iterable<Action> action = actionRepository.findAll();	
		if(!action.iterator().hasNext()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Iterable<Action>>(action, HttpStatus.OK);
	}
	
	// -------------------Create an Action------------------------------------------	
	
	 @RequestMapping(method=RequestMethod.POST)
	 public  ResponseEntity<?> save(@RequestBody Action action) {
		 
		 logger.info("Creating Action : {}", action);
		 if(actionRepository.exists(action.getId())) {
			 logger.error("Unable to create. An Action with id {} already exist", action.getId()); //hacer archivo de configuración con textos
	         return new ResponseEntity<CustomErrorType>(new CustomErrorType("Unable to create. A Action with name " + 
			 action.getId() + " already exist."),HttpStatus.CONFLICT);
		}		 
		actionRepository.save(action);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	 }
	// -------------------Retrieve Single Action------------------------------------------	 
	 @RequestMapping(method=RequestMethod.GET, value="/{id}") ///{city}/{id}
	public ResponseEntity<?> show(@PathVariable String id) {
		 logger.info("Fetching Action with id {}", id);
		 Action action = actionRepository.findOne(id);
		 if(action == null) {
			 logger.error("Action with id {} not found.", id);
	            return new ResponseEntity<CustomErrorType>(new CustomErrorType("Action with id " + id 
	                    + " not found"), HttpStatus.NOT_FOUND);
		 }
		 return new ResponseEntity<Action>(action, HttpStatus.OK);	
	 }
	 
	// ------------------- Update a Action ------------------------------------------------
	 @RequestMapping(method=RequestMethod.PUT, value="/{id}")
	 public ResponseEntity<?> update(@PathVariable String id, @RequestBody Action action) {
		 logger.info("Updating Action with id {}", id);
		 Action ac = actionRepository.findOne(id);
		 if(ac == null) {
			 logger.error("Unable to update. Action with id {} not found.", id);
	            return new ResponseEntity<CustomErrorType>(new CustomErrorType("Unable to upate. Action with id " + id + " not found."),
	                    HttpStatus.NOT_FOUND);
		 }
		 if(action.getId() != null)
			 ac.setId(action.getId());
		 if(action.getCoords() != null)
			 ac.setCoords(action.getCoords());
		 if(action.getFirstDate() != null)
			 ac.setFirstDate(action.getFirstDate());
		 if(action.getFirstPic() != null)
			 ac.setFirstPic(action.getFirstPic());
		 if(action.getLastDate() != null)
			 ac.setLastDate(action.getLastDate());
		 if(action.getLastPic() != null)
			 ac.setLastPic(action.getLastPic());
		 actionRepository.save(ac);
			return new ResponseEntity<Action>(ac, HttpStatus.OK);
	 }
	 
	// ------------------- Delete a Action-----------------------------------------
	 
	 @RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	    public ResponseEntity<?> delete(@PathVariable String id) {
		 logger.info("Fetching & Deleting Action with id {}", id);
	        Action action = actionRepository.findOne(id);
	        if(action == null) {
	        	logger.error("Unable to delete. Action with id {} not found.", id);
	            return new ResponseEntity<CustomErrorType>(new CustomErrorType("Unable to delete. Action with id " + id + " not found."),
	                    HttpStatus.NOT_FOUND);
	        }
	        actionRepository.delete(action);

	        return new ResponseEntity<Action>(HttpStatus.NO_CONTENT);
	    }
}
