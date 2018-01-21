package com.spring.malagaluce.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "team")
public class Team {
	@Id
	private String id;
	private String name;
	private String color;
	private String emblem;
	
	public Team() {
		
	}
//https://www.djamware.com/post/5a44631080aca7059c142971/spring-boot-mongodb-slack-bot-example
	public Team(String name, String color, String emblem) {
		super();
		this.name = name;
		this.color = color;
		this.emblem = emblem;
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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getEmblem() {
		return emblem;
	}

	public void setEmblem(String emblem) {
		this.emblem = emblem;
	}
	
	
}
