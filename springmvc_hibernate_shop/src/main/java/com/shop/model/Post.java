package com.shop.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Post")
public class Post {
	@Id
	private String id_post;
	private String title;
	private Date published;
	private Set<String> categories;
	private String content;
	private String img_url;
	private ArrayList<String> comment_parent;
	private ArrayList<String> comment_child;
	public String getId_post() {
		return id_post;
	}
	public void setId_post(String id_post) {
		this.id_post = id_post;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
//	public User getUser() {
//		return user;
//	}
//	public void setUser(User user) {
//		this.user = user;
//	}
	public Date getPublished() {
		return published;
	}
	public void setPublished(Date published) {
		this.published = published;
	}
	public Set<String> getCategories() {
		return categories;
	}
	public void setCategories(Set<String> categories) {
		this.categories = categories;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImg_url() {
		return img_url;
	}
	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}
	public ArrayList<String> getComment_parent() {
		return comment_parent;
	}
	public void setComment_parent(ArrayList<String> comment_parent) {
		this.comment_parent = comment_parent;
	}
	public ArrayList<String> getComment_child() {
		return comment_child;
	}
	public void setComment_child(ArrayList<String> comment_child) {
		this.comment_child = comment_child;
	}
	
}
