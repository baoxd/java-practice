package com.test.maven.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.maven.dao.UserMapper;
import com.test.maven.model.User;
import com.test.maven.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	public UserMapper mapper;
 
	
	public int insertUser(User user) {
		int result = mapper.insert(user);
		return result;
	}

	public User findUserByNameAndPassword(String name, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
