package com.shopmongo.service;

import java.math.BigInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.shopmongo.model.User;

public class UserServiceImpl implements UserService{
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	public void createUser(User user) {
		if(!mongoTemplate.collectionExists(User.class)){
			mongoTemplate.createCollection(User.class);
		}
		mongoTemplate.insert(user);
		logger.info("Save user successfully, Details : "+user);
	}
	
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

	public void removeUser(BigInteger id) {
		// TODO Auto-generated method stub
		
	}
	
}
