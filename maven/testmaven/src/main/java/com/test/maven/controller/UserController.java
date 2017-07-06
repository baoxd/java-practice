package com.test.maven.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.maven.model.ErrorInfo;
import com.test.maven.model.User;
import com.test.maven.service.UserService;
import com.test.maven.util.TestUtils;

@Controller
@RequestMapping("/user")
public class UserController {
	
	public static Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	public UserService userService;
	
	public TestUtils utils = new TestUtils();
	
	@RequestMapping("/goRegister")
	public String goRegister(){
		return "user/register";
	}
	
	@RequestMapping("/goLogin")
	public String goLogin(){
		return "user/login";
	}
	
	/**
	 * 用户注册
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping("/register")
	public String register(@ModelAttribute User user, Model model){
		boolean registerF = true;
		
		if(user!=null && user.getName() !=null && user.getPassword() !=null && user.getRole()!=null){
			user.setId(utils.uuid(10));
			user.setCreatetime(String.valueOf(new Date().getTime()));
			
			log.info("user register, userInfo:");
			log.info(ReflectionToStringBuilder.toString(user));
			int result = userService.insertUser(user);
			
			if(result >=1){
				registerF = true;
			}
			else{
				registerF = false;
			}
		}else{
			registerF = false;
		}
		
		if(registerF){
			return "redirect:goLogin";
		}else{
			ErrorInfo errorInfo = new ErrorInfo("用户信息错误", "user");
			model.addAttribute(errorInfo);
			return "error";
		}
	}
	
	/**
	 * 用户登录
	 * @param user
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/login")
	public String login(@ModelAttribute User user, Model model, HttpSession session){
		String name = user.getName();
		String password = user.getPassword();
		boolean loginF = true;
		
		if(user!=null && name != null && password !=null){
			User userInfo = userService.findUserByNameAndPassword(name, password);
			
			if(userInfo != null){
				session.setAttribute("user", user);
			}else{
				loginF = false;
			}
		}else{
			loginF = false ;
		}
		
		if(loginF){
			return "redirect:userlist";
		}else{
			ErrorInfo errorInfo = new ErrorInfo("用户信息错误", "user");
			model.addAttribute(errorInfo);
			return "error";
		}
	}
	
	/**
	 * 用户列表
	 * @param model
	 * @return
	 */
	@RequestMapping("/userlist")
	public String userList(Model model){
		List<User> userList = userService.findAll();
		System.out.println("用户列表");
		System.out.println(userList);
		
		for(int i = 0 ; i < userList.size(); i++){
			User user = userList.get(i);
			user.setCreatetimeForPage(new Date(Long.parseLong(user.getCreatetime())));
		}
		model.addAttribute(userList);
		SimpleDateFormat format = new SimpleDateFormat("");
		return "user/userlist";
	}
	
	/**
	 * 退出登录
	 * @param session
	 * @return
	 */
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.removeAttribute("user");
		return "redirect:goLogin";
	}
	
	
}
