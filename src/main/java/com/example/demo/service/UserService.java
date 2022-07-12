package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepo;


@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private UserEntity user;
	
	
	public boolean saveUser(UserEntity user) {
	    user=userRepo.save(user);
	    if(user!=null) {
		return true;
	    }else {
	    	return false;
	    }
	}

}
