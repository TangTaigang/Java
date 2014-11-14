package com.dominhquan.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

@Document(collection="item")
public class Item {
	@Id
	private String id;
	private String name;
	private String restaurant_name;
	private Date createDate;
	private Date updateDate;
	private Double price;
	private int status;
	private String img_url;
	private String img_ico;
	
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
	
	public String getRestaurant_name() {
		return restaurant_name;
	}
	
	public void setRestaurant_name(String restaurant_name) {
		this.restaurant_name = restaurant_name;
	}
	
	public String getImg_url() {
		return img_url;
	}
	
	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}
	
	public String getImg_ico() {
		return img_ico;
	}
	
	public void setImg_ico(String img_ico) {
		this.img_ico = img_ico;
	}
	
	@JsonSerialize(using=DateSerializer.class)
	public Date getCreateDate() {
		return createDate;
	}
	
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	@JsonSerialize(using=DateSerializer.class)
	public Date getUpdateDate() {
		return updateDate;
	}
	
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public int getStatus() {
		return status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name+ ", restaurant=" + restaurant_name 
				+", img_url="+img_url+",img_icon="+img_ico
				+ ", createDate=" + createDate + ", updateDate="
				+ updateDate + ", price=" + price
				+ ", status=" + status + "]";
	}
	
}
