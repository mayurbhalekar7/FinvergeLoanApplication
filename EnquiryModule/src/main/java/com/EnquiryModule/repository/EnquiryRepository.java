package com.EnquiryModule.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.EnquiryModule.model.Enquiry;

@Repository
public interface EnquiryRepository extends JpaRepository<Enquiry, Integer> {

	Optional<List<Enquiry>> findAllByLoanStatus(String loanStatus);

	Optional<Enquiry> findByPancard(String pancard);

}
	