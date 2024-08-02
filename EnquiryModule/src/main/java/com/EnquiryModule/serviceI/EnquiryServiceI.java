package com.EnquiryModule.serviceI;

import java.util.List;

import com.EnquiryModule.model.Enquiry;

public interface EnquiryServiceI {

	void addEnquiry(Enquiry eq);

	List<Enquiry> getAllEnquiries();

}
