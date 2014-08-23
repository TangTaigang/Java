package com.shopmongo.service;

import java.math.BigInteger;

import com.shopmongo.model.User;

public interface UserService {
	void createUser(User user);
	void updateUser(User user);
	void removeUser(BigInteger id);
}
