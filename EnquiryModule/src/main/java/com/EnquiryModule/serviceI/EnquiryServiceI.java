package com.EnquiryModule.serviceI;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.EnquiryModule.model.Enquiry;

public interface EnquiryServiceI {

	void addEnquiry(Enquiry eq);

	 List<Enquiry> getAllEnquiries();

	Optional<Enquiry> getEnquriryById(int enquiryId);

}
