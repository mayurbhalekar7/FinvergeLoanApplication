package com.EnquiryModule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.EnquiryModule.model.Enquiry;
import com.EnquiryModule.serviceI.EnquiryServiceI;

@RestController
public class EnquiryController {
 
	@Autowired
	EnquiryServiceI enqs;
	
	@GetMapping("/")
	public String preLogin()
	{
		return "This is enquiry module";
	}
	
	@PostMapping("/addEnquiry")
	public ResponseEntity<String> addEnquiry(@RequestBody Enquiry eq)
	{ 
		ResponseEntity<String> rs=new ResponseEntity<String>("Send your Enquiry successfully...",HttpStatus.CREATED);
		
		enqs.addEnquiry(eq);
		return rs;
	}
	
}
