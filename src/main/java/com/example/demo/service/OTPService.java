package com.example.demo.service;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

@Service
public class OTPService {
	
	
	 private static final Integer EXPIRE_MINS = 4;
	    private LoadingCache<String, String> otpCache;
	    public OTPService(){
	      super();
	      otpCache = CacheBuilder.newBuilder().
	      expireAfterWrite(EXPIRE_MINS, TimeUnit.MINUTES)
	      .build(new CacheLoader<String, String>() {
	      public String load(String key) {
	             return "";
	       }
	   });
	 }

	public int generateOTP(String key){
	Random random = new Random();
	Integer otp = 100000 + random.nextInt(900000);
	Integer attempts =0;
	otpCache.put(key, otp.toString());
	otpCache.put("email", key);
	otpCache.put("attempts", attempts.toString());
	otpCache.put(key, otp.toString());
	return otp;
	 }
	  
	 public int getOtp() throws ExecutionException{ 
		 
		 Integer attempts =  Integer.parseInt(otpCache.get("attempts"));
		 String email=otpCache.get("email");
    try{
    	if(attempts<5) {
    		Integer otp =  Integer.parseInt(otpCache.get(email));
    		attempts= attempts+1;
    		otpCache.put("attempts",attempts.toString());
    		return otp;	
    	}   	
	 return 0; 
	}catch (Exception e){
	 return 0; 
	}
	 }

	public void clearOTP() throws ExecutionException{ 
     String email=otpCache.get("email");	
	 otpCache.invalidate(email);
	 }

}
