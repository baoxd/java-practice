package com.test.maven.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.maven.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	public UserService userService;
	
	@RequestMapping("/goRegister")
	public String goRegister(){
		return "user/register";
	}
}
