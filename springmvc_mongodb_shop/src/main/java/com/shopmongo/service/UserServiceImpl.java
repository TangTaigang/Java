package com.shopmongo.service;

import java.math.BigInteger;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.shopmongo.model.User;

public class UserServiceImpl implements UserService{
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	private static final String UserCollection="UserCollection";
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Override
	public void createUser(User user) {
		if(!mongoTemplate.collectionExists(User.class)){
			mongoTemplate.createCollection(User.class);
		}
		user.setId(UUID.randomUUID().toString());
		mongoTemplate.insert(user,UserCollection);
		logger.info("Save user successfully, Details : "+user);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeUser(BigInteger id) {
		// TODO Auto-generated method stub
		
	}
	
}
