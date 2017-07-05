package com.test.maven.service;

import java.util.List;

import com.test.maven.model.User;

public interface UserService {
	
	// 添加用户
	public int insertUser(User user);
	
	// 查询用户
	public User findUserByNameAndPassword(String name, String password);
	
	// 查询用户
	public List<User> findAll();
}
