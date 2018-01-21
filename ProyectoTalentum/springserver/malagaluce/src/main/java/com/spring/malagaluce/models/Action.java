package com.spring.malagaluce.models;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.drew.lang.GeoLocation;


@Document(collection = "action")
public class Action {
	@Id
	private String id;
	private GeoLocation coords;
	private String firstDate;
	private String lastDate;
	private String firstPic;
	private String lastPic;		
	private boolean Verified;
	private ArrayList<User> users;
	
	public Action() {
		users = new ArrayList<>();
	}

	public Action(String firstDate, String firstPic, boolean verified, ArrayList<User> users) {
		super();
		this.firstDate = firstDate;
		this.firstPic = firstPic;
		Verified = verified;
		this.users = users;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public GeoLocation getCoords() {
		return coords;
	}

	public void setCoords(GeoLocation coords) {
		this.coords = coords;
	}

	public String getFirstDate() {
		return firstDate;
	}

	public void setFirstDate(String firstDate) {
		this.firstDate = firstDate;
	}

	public String getLastDate() {
		return lastDate;
	}

	public void setLastDate(String lastDate) {
		this.lastDate = lastDate;
	}

	public String getFirstPic() {
		return firstPic;
	}

	public void setFirstPic(String firstPic) {
		this.firstPic = firstPic;
	}

	public String getLastPic() {
		return lastPic;
	}

	public void setLastPic(String lastPic) {
		this.lastPic = lastPic;
	}

	public boolean isVerified() {
		return Verified;
	}

	public void setVerified(boolean verified) {
		Verified = verified;
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}
	
	

}
