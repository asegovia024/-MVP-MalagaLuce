package com.spring.malagaluce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.malagaluce.models.Team;
import com.spring.malagaluce.repositories.TeamRepository;

@RestController
@RequestMapping("api/teams")
public class TeamController {

	@Autowired
	TeamRepository teamRepository;
	
	@RequestMapping(method=RequestMethod.GET)
	public Iterable<Team> team() {
		return teamRepository.findAll();
	}
	 
	 @RequestMapping(method=RequestMethod.POST)
	 public String save(@RequestBody Team team) {
		 teamRepository.save(team);
		 return team.getId();
	 }
	 
	 @RequestMapping(method=RequestMethod.GET, value="/{id}")
	public Team show(@PathVariable String id) {
		 return teamRepository.findOne(id);		
	 }
	 
	 @RequestMapping(method=RequestMethod.PUT, value="/{id}")
	 public Team update(@PathVariable String id, @RequestBody Team team) {
		 Team te = teamRepository.findOne(id);
		 if(team.getName() != null)
			 te.setName(team.getName());
		 if(team.getColor() != null)
			 te.setColor(team.getColor());
		 if(team.getEmblem() != null)
			 te.setEmblem(team.getEmblem());
		 return te;
	 }
	 @RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	    public String delete(@PathVariable String id) {
	        Team team = teamRepository.findOne(id);
	        teamRepository.delete(team);

	        return "Team deleted";
	    }
}
