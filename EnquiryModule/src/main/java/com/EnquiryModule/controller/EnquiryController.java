package com.EnquiryModule.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnquiryController {

	@GetMapping("/")
	public String preLogin()
	{
		return "This is enquiry module";
	}
	
}
