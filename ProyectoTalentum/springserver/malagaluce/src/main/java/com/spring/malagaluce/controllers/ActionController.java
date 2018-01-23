package com.spring.malagaluce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.malagaluce.models.Action;
import com.spring.malagaluce.repositories.ActionRepository;

@RestController
@RequestMapping("api/actions")
public class ActionController {

	@Autowired
	ActionRepository actionRepository;
	
	@RequestMapping(method=RequestMethod.GET)
	public Iterable<Action> action() {
		return actionRepository.findAll();
	}
	
	 @RequestMapping(method=RequestMethod.POST)
	 public String save(@RequestBody Action action) {
		 actionRepository.save(action);
		 return action.getId();
	 }
	 
	 @RequestMapping(method=RequestMethod.GET, value="/{id}")
	public Action show(@PathVariable String id) {
		 return actionRepository.findOne(id);		
	 }
	 
	 @RequestMapping(method=RequestMethod.PUT, value="/{id}")
	 public Action update(@PathVariable String id, @RequestBody Action action) {
		 Action ac = actionRepository.findOne(id);
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
		return ac;
	 }
	 @RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	    public String delete(@PathVariable String id) {
	        Action action = actionRepository.findOne(id);
	        actionRepository.delete(action);

	        return "Action deleted";
	    }
}
