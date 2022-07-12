package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserLoginEntity;
import com.example.demo.repository.UserLoginRepo;

@Service
public class UserLoginService {
	

	@Autowired
	private UserLoginRepo userLoginRepo;
	
	@Autowired
	private UserLoginEntity user;
	
	
	public boolean saveUserLoginDetials(UserLoginEntity user) {
	    user=userLoginRepo.save(user);
	    if(user!=null) {
		return true;
	    }else {
	    	return false;
	    }
	}


}
