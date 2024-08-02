package com.EnquiryModule.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EnquiryModule.model.Enquiry;
import com.EnquiryModule.repository.EnquiryRepository;
import com.EnquiryModule.serviceI.EnquiryServiceI;

@Service
public class EnquiryServiceImpl implements EnquiryServiceI {

	@Autowired
	EnquiryRepository er;
	
	@Override
	public void addEnquiry(Enquiry eq) {
		
		er.save(eq);
		
	}

	@Override
	public List<Enquiry> getAllEnquiries() {

		return er.findAll();
	}

}
