package com.OperationalExecutiveModule.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.OperationalExecutiveModule.model.Enquiry;

@Repository
public interface OERepository extends JpaRepository<Enquiry, Integer> {

	Optional<Enquiry> getByEnquiryIdAndEnquiryStatus(int enquiryId,String enquiryStatus);
}
