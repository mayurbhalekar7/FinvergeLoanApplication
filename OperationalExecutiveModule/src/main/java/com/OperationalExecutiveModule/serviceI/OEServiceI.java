package com.OperationalExecutiveModule.serviceI;

import java.util.Optional;

import com.OperationalExecutiveModule.model.Enquiry;

public interface OEServiceI {

	Optional<Enquiry> checkCibilScore(int eid);

}
