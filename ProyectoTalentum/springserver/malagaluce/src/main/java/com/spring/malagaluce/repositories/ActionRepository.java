package com.spring.malagaluce.repositories;

import org.springframework.data.repository.CrudRepository;

import com.spring.malagaluce.models.Action;

public interface ActionRepository extends CrudRepository<Action, String> {
	@Override
	Action findOne(String id);
	
	@Override
	void delete(Action action);

}