package com.dominhquan.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.dominhquan.model.Item;

public class ItemServiceImpl implements ItemService{
	
	private static final Logger logger = LoggerFactory.getLogger(ItemServiceImpl.class);
	
	@Autowired
	private MongoTemplate mongoTemplate;
	public ItemServiceImpl (MongoTemplate mongoTemplate){
		this.mongoTemplate=mongoTemplate;
	}
	@Override
	public void createItem(Item item) {
		logger.info("Save item successfully, Details : "+ item);
	}

	@Override
	public Item getItem(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeItem(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateItem() {
		// TODO Auto-generated method stub
		
	}

}
