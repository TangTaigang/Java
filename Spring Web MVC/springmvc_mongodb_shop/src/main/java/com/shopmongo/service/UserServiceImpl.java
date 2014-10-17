package com.shopmongo.service;

import java.math.BigInteger;




import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.shopmongo.model.User;

public class UserServiceImpl implements UserService{
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
//	public void setMongoTemplate(MongoTemplate mongoTemplate) {
//		this.mongoTemplate = mongoTemplate;
//	}
	
	private Query query;
	
	public UserServiceImpl(MongoTemplate mongoTemplate){
		this.mongoTemplate=mongoTemplate;
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
	
	public Boolean checkLoggin(String name,String pass){
		Boolean check=false;
		query=new Query(Criteria.where("name").is(name).and("password").is(pass)); 
		if(mongoTemplate.findOne(query,User.class)!=null){
			check=true;
		}
		return check;
	}
	
	public User getUserInfo(String data){   // id or name
		query=new Query(Criteria.where("name").is(data)); 
		return (User) mongoTemplate.findOne(query,User.class);
	}
	
	public List<User> searchUserByCondition(String data_search){
		query=new Query(Criteria.where("name").regex(data_search)); 
		return mongoTemplate.find(query, User.class);
	}
}
