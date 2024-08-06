package com.OperationalExecutiveModule.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OperationalExecutiveModule.model.Enquiry;
import com.OperationalExecutiveModule.repository.OERepository;
import com.OperationalExecutiveModule.serviceI.OEServiceI;

@Service
public class OEServiceImpl implements OEServiceI {

	@Autowired
	OERepository or;

	@Override
	public List<Enquiry> getByStatus(String enquiryStatus) {
	
		List<Enquiry> elist=or.findByEnquiryStatus(enquiryStatus);
		return elist;
	}

	

	
}
