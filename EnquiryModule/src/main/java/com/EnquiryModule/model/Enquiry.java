package com.EnquiryModule.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Enquiry {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int enquiryId;
	
	@NotEmpty(message = "FirstName not be Empty")
	private String firstName;
	
	@NotEmpty(message = "LastName not be Empty")
	private String lastName;
	
	@Size(min=18,max=60)
    private int age;
	
	@Email(message = "Email is not correct")
	private String email;
	
	@NotEmpty(message = "Mobile no not be Empty")
	private long mobileNo;
	
	@NotEmpty(message = "Adharcard not be Empty")
	private String adharcard;
	 
	@NotEmpty(message = "Pancard not be Empty")
	private String pancard;
	
	private String gender;
	
	private String enquiryStatus;
	 
	@OneToOne(cascade = CascadeType.ALL)
	private Cibil cibil;

}
