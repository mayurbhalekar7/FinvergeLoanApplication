package com.EnquiryModule.serviceImp;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.EnquiryModule.model.Enquiry;
import com.EnquiryModule.repository.EnquiryRepository;
import com.EnquiryModule.serviceI.EnquiryServiceI;

@Service
public class EnquiryServiceImpl implements EnquiryServiceI {

	@Autowired
	EnquiryRepository er;
	
	@Autowired
	private JavaMailSender sender; 
	
	int cibilScore=ThreadLocalRandom.current().nextInt(300, 900);
	
	@Override
	public void addEnquiry(Enquiry eq) {
    SimpleMailMessage message=new SimpleMailMessage();
		
		message.setTo(eq.getEmail());
		
		message.setSubject("Finvaege Enquiry Status");
		
		message.setText("hello  "+eq.getFirstName()+" "+eq.getLastName()+"\n  Your Enquiry recived to Finverge Finance we will update you for your  EnquiryStatus ");
		
		sender.send(message);
		
		er.save(eq);
		
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

//	@Override
//	public void chechCibilScoreByIdAndSendEmail(int enquiryId) {
//		 Enquiry enquery=er.findById(enquiryId).get();
//		 
//		 enquery.getCibil().setCibilScore(cibilScore);
//		 
//		 SimpleMailMessage message=new SimpleMailMessage();
//			
//			message.setTo(enquery.getEmail());
//			
//			message.setSubject("Finvaege Enquiry Status");
//			 if(cibilScore<650)
//			 {  
//			message.setText("hello  "+enquery.getFirstName()+" "+enquery.getLastName()+"\n your Cibil is "+cibilScore+" is not upto ta mark so We can't forword your Loan Application ");
//			enquery.getCibil().setCibilStatus("Bad");
//			  er.save(enquery);
//			 }
//			 else {
//				 message.setText("hello  "+enquery.getFirstName()+" "+enquery.getLastName()+"\n your Cibil is "+cibilScore+" is  good so We c forword your Loan Application ");
//				 enquery.getCibil().setCibilStatus("Good");
//				 er.save(enquery);
//			 }
//			sender.send(message);
//		  
//		
//		
//	}

}
