package com.OperationalExecutiveModule.serviceI;

import java.util.List;

import com.OperationalExecutiveModule.model.Enquiry;

public interface OEServiceI {



	public List<Enquiry> getByStatus(String enquiryStatus);

}
