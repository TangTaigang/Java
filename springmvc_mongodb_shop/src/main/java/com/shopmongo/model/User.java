package com.shopmongo.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {
	@Id
	private String id;
	private String name;
	private String password;
	private Date activityTime;
	private String activityType;
	private String activityDescription;
	private String accessUrl;

	public User() {}
	
	public User(String id, String name, String password, Date activityTime,
			String activityType, String activityDescription, String accessUrl) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.activityTime = activityTime;
		this.activityType = activityType;
		this.activityDescription = activityDescription;
		this.accessUrl = accessUrl;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getActivityTime() {
		return activityTime;
	}
	public void setActivityTime(Date activityTime) {
		this.activityTime = activityTime;
	}
	public String getActivityType() {
		return activityType;
	}
	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}
	public String getActivityDescription() {
		return activityDescription;
	}
	public void setActivityDescription(String activityDescription) {
		this.activityDescription = activityDescription;
	}
	public String getAccessUrl() {
		return accessUrl;
	}
	public void setAccessUrl(String accessUrl) {
		this.accessUrl = accessUrl;
	}
	
		
}
