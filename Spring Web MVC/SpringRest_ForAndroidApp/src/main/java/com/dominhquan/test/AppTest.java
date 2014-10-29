package com.dominhquan.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dominhquan.model.Item;
import com.dominhquan.service.ItemServiceImpl;

public class AppTest {
	
	
	public static void main(String args[]){
		
		@SuppressWarnings("resource")
		ApplicationContext context=new ClassPathXmlApplicationContext("servlet-context.xml");
		ItemServiceImpl itemServiceImpl= (ItemServiceImpl) context.getBean("itemService");
		
		// Create item
//		for(int i=1;i<10;i++){
//			Item item=new Item();
//			item.setId(i);
//			item.setName("Food-"+i);
//			item.setRestaurant_name("Restaurant-"+i);
//			itemServiceImpl.createItem(item);
//		}
		List<Item> list=itemServiceImpl.getListItem("Restaurant");
		for (Item item : list) {
			System.out.println(item.toString());
		}
	}
}
