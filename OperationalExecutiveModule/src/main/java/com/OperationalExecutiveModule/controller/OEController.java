package com.OperationalExecutiveModule.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.OperationalExecutiveModule.model.Enquiry;
import com.OperationalExecutiveModule.serviceI.OEServiceI;

import lombok.extern.java.Log;

@RestController
public class OEController {

	@Autowired
	OEServiceI oei;
	
	@GetMapping("/getEnquiryByIdAndStatus/{enquiryStatus}/")
	public ResponseEntity<List<Enquiry>>getEnquriryById(@PathVariable("enquiryStatus")String enquiryStatus) 
	{
	 List<Enquiry> eqList = oei.getByStatus(enquiryStatus);
			 ResponseEntity<List<Enquiry>> elist= new ResponseEntity<List<Enquiry>>(eqList, HttpStatus.OK);
	  return elist;
	  
   
	
	
	
	}
	}
	

