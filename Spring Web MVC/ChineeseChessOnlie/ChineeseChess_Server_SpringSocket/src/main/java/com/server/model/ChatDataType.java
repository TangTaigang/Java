package com.server.model;

import java.util.Date;

public class ChatDataType {
	private int id;
	private String userSend;
	private String userReceive;
	private int type;
	private Date time;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserSend() {
		return userSend;
	}
	public void setUserSend(String userSend) {
		this.userSend = userSend;
	}
	public String getUserReceive() {
		return userReceive;
	}
	public void setUserReceive(String userReceive) {
		this.userReceive = userReceive;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
}
