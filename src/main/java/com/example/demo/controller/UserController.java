package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.UserEntity;
import com.example.demo.entity.UserLoginEntity;
import com.example.demo.service.UserLoginService;
import com.example.demo.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserLoginService userLoginService;
	
	@Autowired
	private UserEntity userEntity;
	
	@Autowired
	private UserLoginEntity userLoginEntity;
	
	@RequestMapping(value ="/save-user" ,method = RequestMethod.POST)
	public @ResponseBody String saveUser(@RequestBody UserEntity user) {
		
		/*
		    * Encrypting password
		    *
		*/
		String password = user.getUserPassword();	
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encryptedPassword = passwordEncoder.encode(password);
	   
		
	   
	   
	   /*
	    * user login details save
	    * */
	   
	   userLoginEntity.setUsername(user.getUserName());
	   userLoginEntity.setPassword(encryptedPassword);
	   userLoginEntity.setRole("ROLE_USER");
	   userLoginEntity.setEnabled(true);
	   
	   
	   
	   user.setUserPassword(encryptedPassword);
	   boolean res=	userService.saveUser(user);
	   boolean res1 = userLoginService.saveUserLoginDetials(userLoginEntity);
	   
	   if(res==true&&res1==true) {
		return "user saved successfully";
	   }else {
		   return "not saved";
	   }
	}

}
