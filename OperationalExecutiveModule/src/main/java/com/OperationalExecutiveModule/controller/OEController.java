package com.OperationalExecutiveModule.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.OperationalExecutiveModule.exception.EnquiryNotFoundException;
import com.OperationalExecutiveModule.model.Enquiry;
import com.OperationalExecutiveModule.serviceI.OEServiceI;

@RestController
public class OEController {

	@Autowired
	OEServiceI oei;
	
	
	@GetMapping("/")
	public String OEModule()
	{
		return "This is OE Module..";
	}
	
	
	@PostMapping("/checkCibilScoreAndSendMail/{enquiryId}")
	public ResponseEntity<String> checkCibilScoreAndSendMail(@PathVariable("enquiryId") int eid)
	{
	   Optional<Enquiry> op=oei.checkCibilScore(eid);
	   if(op.isPresent())
	   {
		   if(op.get().getCibil().getCibilScore()>0)
		   {
			   ResponseEntity<String> re=new ResponseEntity<String>("Sending mail successfully with CibilScore...",HttpStatus.ACCEPTED);
			   return re;
		   }
		   else
		   {
			   ResponseEntity<String> re=new ResponseEntity<String>("CibilScore Already Caluclated...",HttpStatus.ALREADY_REPORTED);
			   return re;
		   }
	   }
	   else
		   throw new EnquiryNotFoundException("Enquiry not present");
	}
}
