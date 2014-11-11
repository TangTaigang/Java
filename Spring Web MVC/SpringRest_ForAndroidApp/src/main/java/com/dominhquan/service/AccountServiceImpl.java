package com.dominhquan.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import com.dominhquan.model.Account;

public class AccountServiceImpl implements AccountService{
	
	private static final Logger logger = LoggerFactory.getLogger(ItemServiceImpl.class);
	
	@Autowired
	private MongoTemplate mongoTemplate;
	private Query query;
	
	public AccountServiceImpl (MongoTemplate mongoTemplate){
		this.mongoTemplate=mongoTemplate;
	}
	@Override
	public void add(Account account) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Account getAccount(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Account account) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Account account) {
		// TODO Auto-generated method stub
		
	}

}
