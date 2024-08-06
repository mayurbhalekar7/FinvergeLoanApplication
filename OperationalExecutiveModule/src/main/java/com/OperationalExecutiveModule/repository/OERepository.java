package com.OperationalExecutiveModule.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.OperationalExecutiveModule.model.Enquiry;

@Repository
public interface OERepository extends JpaRepository<Enquiry, Integer> 
	
	
	{

	List<Enquiry> findByEnquiryStatus(String enquiryStatus);
		
	}

