package com.spring.malagaluce.models;

import java.util.Collection;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Document(collection = "user")
public class User implements UserDetails{
	
	@Id
	private String id;
	private String name;
	private String mail;
	private String password;
	private boolean superuser;
	private int points;
	private String joindate;
	private String username;
	
	//UserDetails
	private List<GrantedAuthority> grantedAuthorities;
	private boolean nonLocked =true;
	private boolean nonExpired =true;//TODO:Cambiar esto

	public User() {
		
	}
	
	public User(String name, String mail, String password, boolean superuser, String username) {
		this.name = name;
		this.mail = mail;
		this.password = password;
		this.superuser = superuser;
		this.username = username;
		this.points = -1;
		this.superuser = false;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isSuperuser() {
		return superuser;
	}

	public void setSuperuser(boolean superuser) {
		this.superuser = superuser;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public String getJoindate() {
		return joindate;
	}

	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	//------------UserDetails--------
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return grantedAuthorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		return nonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return nonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	

}
