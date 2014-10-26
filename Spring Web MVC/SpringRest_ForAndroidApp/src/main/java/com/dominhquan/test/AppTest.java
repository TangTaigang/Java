package com.dominhquan.test;

import org.springframework.web.client.RestTemplate;

import com.dominhquan.model.Item;

public class AppTest {
	
	public static final String Server_Uri="http://localhost:8080/app";
	
	public static void main(String args[]){
		  RestTemplate restTemplate=new RestTemplate();
		  Item item=restTemplate.getForObject(Server_Uri+"/rest/item/1",Item.class);
		  System.out.println(item.getId()+","+item.getName());
	}
}
