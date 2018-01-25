package com.spring.malagaluce.repositories;

import org.springframework.data.repository.CrudRepository;

import com.spring.malagaluce.models.User;

public interface UserRepository extends CrudRepository<User, String> {
	@Override
	User findOne(String id);
	
	@Override
	void delete(User user);
	
	User findByMail(String mail);
	//We only add `findOne` and `delete` method to the interface 
	//because the rest method already handled by `CrudRepository` of Spring Data MongoDB.

}
