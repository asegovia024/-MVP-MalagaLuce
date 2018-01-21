package com.spring.malagaluce.repositories;

import org.springframework.data.repository.CrudRepository;

import com.spring.malagaluce.models.Team;

public interface TeamRepository extends CrudRepository<Team, String> {
	@Override
	Team findOne(String id);
	
	@Override
	void delete(Team team);

}
