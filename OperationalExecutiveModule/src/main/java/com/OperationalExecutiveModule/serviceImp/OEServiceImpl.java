package com.OperationalExecutiveModule.serviceImp;

import java.util.Date;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.OperationalExecutiveModule.model.Enquiry;
import com.OperationalExecutiveModule.repository.OERepository;
import com.OperationalExecutiveModule.serviceI.OEServiceI;

@Service
public class OEServiceImpl implements OEServiceI {

	@Autowired
	OERepository or;
	
	@Autowired
	private JavaMailSender sender; 

	@Override
	public Optional<Enquiry> checkCibilScore(int eid) {

		    Optional<Enquiry> op=or.getByEnquiryIdAndEnquiryStatus(eid,"f2oe");
		    
		    if(op.isPresent())
		    {
				Enquiry eq=op.get();
				
				if(eq.getCibil().getCibilScore()==0)
				{
		            SimpleMailMessage message=new SimpleMailMessage();
					message.setTo(eq.getEmail());
					message.setSubject("Finvaege CibilScore Status");
					
					Random rand= new Random();
					int min=300,max=900;
					int cibil=0;
		
					cibil=rand.nextInt((max+1)-min)+min;
					
					eq.getCibil().setCibilScore(cibil);
					eq.getCibil().setCibilDate(new Date());
					if(cibil>650)
					{
						eq.getCibil().setCibilStatus("Good");
						eq.setLoanStatus("Approved");
						
						message.setText("Hello,"+eq.getFirstName()+" "+eq.getLastName()+",\nYour Cibil Score is calculated by Finverge Finance is "
						   +eq.getCibil().getCibilScore()+", so your Cibil Status is "+eq.getCibil().getCibilStatus()+ " And your Loan Status is "+eq.getLoanStatus()
						   +"."+"\n\n Required Documents for HomeLoan:"+"\n1.Previous Loan documents \n"
						   		+ "2.Property Details \n"
						   		+ "3.Loan Details\n"
						   		+ "4.Personal Details"
							+".\n\n\n Thanks & Regards,\n Finverge Team");
					}
					else
					{
						eq.getCibil().setCibilStatus("Bad");
						eq.setLoanStatus("Not Approved");
						
						message.setText("Hello,"+eq.getFirstName()+" "+eq.getLastName()+",\nYour Cibil Score is calculated by Finverge Finance is "
						   +eq.getCibil().getCibilScore()+", so your Cibil Status is "+eq.getCibil().getCibilStatus()+", And your Loan Status is "+eq.getLoanStatus()
						   +"."+" You are not applicable for Home Loan"
							+".\n\n\n Thanks & Regards,\n Finverge Team");
					}
					sender.send(message); 
					or.save(eq);	
					return op;
			    }
				else
				{
					op.get().getCibil().setCibilScore(0);
					return op;
				}	
		   }
		    else
		    	return op;
	}
}
