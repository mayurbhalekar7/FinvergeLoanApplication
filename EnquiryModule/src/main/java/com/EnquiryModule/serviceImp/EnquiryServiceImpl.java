package com.EnquiryModule.serviceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.EnquiryModule.exception.PancardAlreadyExistException;
import com.EnquiryModule.model.Enquiry;
import com.EnquiryModule.repository.EnquiryRepository;
import com.EnquiryModule.serviceI.EnquiryServiceI;

@Service
public class EnquiryServiceImpl implements EnquiryServiceI {

	@Autowired
	EnquiryRepository er;
	
	@Override
	public void addEnquiry(Enquiry eq) {
		
		// List<Enquiry> elist=er.findAll();
		  Optional<Enquiry> eo=er.findByPancard(eq.getPancard());
		  
			if(eo.isPresent())
			{
				throw new PancardAlreadyExistException("Pancard already exist..."); 
			}
			else
			{
				er.save(eq);
			}
				
		 }

	@Override
	public List<Enquiry> getAllEnquiries() {

		return er.findAll();
	}

	@Override
	public Optional<Enquiry> getEnquriryById(int enquiryId) {
		 Optional<Enquiry> enq=er.findById( enquiryId);
			
		return enq;
	}

	@Override
	public void updateEnquiry(int eid, Enquiry eq) {

		er.save(eq);
	}

	@Override
	public void deleteEnquiry(int eid) {
		
		er.deleteById(eid);
	}

}
