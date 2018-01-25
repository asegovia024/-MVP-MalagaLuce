package com.spring.malagaluce.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public class UserDetailsServiceImplem implements UserDetailsService{
	


	@Override
	public UserDetails loadUserByUsername(String user) throws UsernameNotFoundException {
		//usar REST para obtener usuario por nombre/email y devolverlo
		return null;
	}

}
