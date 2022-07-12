package com.example.demo.controller;

import java.util.concurrent.ExecutionException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.service.EmailService;
import com.example.demo.service.OTPService;

@Controller
public class OTPController {
	
	@Autowired
	public OTPService otpService;

	@Autowired
	public EmailService emailService;
	
	
	
	@GetMapping("/generateOtp")
	public String generateOTP(@RequestParam String email) throws MessagingException{
		
			String username = email;
			int otp = otpService.generateOTP(username);
			 
			String template = "<!DOCTYPE html>\r\n"
					+ "<html>\r\n"
					+ "<head>\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "	<h1> Hi "+username+"</h1>\r\n"
					+ "	<br/>\r\n"
					+ "	<h2> Your Otp Number is "+ otp +"</h2> \r\n"
					+ "	<br/>\r\n"
					+ "	Thanks,\r\n"
					+ "</body>\r\n"
					+ "</html>";
			emailService.sendOtpMessage(username, "OTP Verification", template);
			
	return "Otp-generated-successfully";
	}

	@RequestMapping(value ="/validateOtp", method = RequestMethod.GET)
	public String validateOtp(@RequestParam("otp") Integer otpnum) throws Exception{
		
			final String SUCCESS = "Entered Otp is valid";
			final String FAIL = "Entered Otp is NOT valid. Please Retry!";
			
		
			if(otpnum >= 0){			
			  int serverOtp = otpService.getOtp();
			    if(serverOtp > 0){
			      if(otpnum == serverOtp){
			          otpService.clearOTP();
			
	                  return (SUCCESS);
	                } 
			        else {
	                    return FAIL;
	                   }
	               }else {
	              return FAIL;
	               }
	             }else {
	                return FAIL;
	         }
	    }
	
	
	
}
