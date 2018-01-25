package com.spring.malagaluce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.spring.malagaluce.models.User;
import com.spring.malagaluce.repositories.UserRepository;


public class UserDetailsServiceImplem implements UserDetailsService{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String user) throws UsernameNotFoundException {
		//usar REST para obtener usuario por nombre/email y devolverlo
		
		User user2 = userRepository.findByMail(user);
		
		return user2;
	}

}
