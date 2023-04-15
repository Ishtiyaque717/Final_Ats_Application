package com.ats.kronos.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.entity.AtsCompany;
import com.ats.entity.AtsPackage;
import com.ats.kronos.exceptions.KronosException;
import com.ats.model.AtsRequest;
import com.ats.model.AtsResponse;
import com.ats.model.Education;
import com.ats.model.Employement;
import com.ats.model.Error;
import com.ats.reposatory.AtsCompanyRepo;

@Service
public class KronosService {
	@Autowired
	AtsCompanyRepo atsCompanyRepo;

	public AtsResponse companyValidationService(AtsRequest atsRequest) {
		AtsResponse atsResponse = new AtsResponse();
		List<Error> errr = new ArrayList<>();
		String success = null;
		KronosException e = null;
		AtsCompany atsCompany = atsCompanyRepo.findByCompanyName(atsRequest.getBackgroundRequestor().getCompanyName());

		if (atsCompany == null) {
			Error obj = new Error(1, "company name is not present in the Db");
			e = new KronosException("validation 1");
			errr.add(obj);
			e.setKronosError(errr);
			throw e;
		}
		if (!atsCompany.getAts().getAtsName().equals("Kronos")) {
			Error obj2 = new Error(2, "AtsCompany is not associated to kronos");
			e = new KronosException("validation 2");
			errr.add(obj2);
			e.setKronosError(errr);
			throw e;
		}
		String s = atsRequest.getBackgroundRequestor().getPackageId();
		Integer i = Integer.parseInt(s);
		List<AtsPackage> packageList = atsCompany.getAtsPackages();

		if (packageList != null) {

			Predicate<AtsPackage> pr = (p) -> {
				if (p.getPackageId() == i) {
					return true;
				} else {
					return false;
				}
			};

			List<AtsPackage> selectedPackageList = packageList.stream().filter(pr).collect(Collectors.toList());
			if (selectedPackageList == null || selectedPackageList.size() == 0) {
				Error obj3 = new Error(3, "package is not present");
				e = new KronosException("validation 3");
				errr.add(obj3);
				e.setKronosError(errr);
				throw e;
			} else {
				AtsPackage selectedPackage = selectedPackageList.get(0);
				// Education Vlidations

				int noOfEducation = selectedPackage.getNoOfEducation();
				if (noOfEducation > 0) {
					educationDetailValidation(atsRequest, noOfEducation, errr);

				}

				// Employement validations
				int noOfEmployement = selectedPackage.getNoOfEmployement();
				if (noOfEmployement > 0) {
					employementDetailValidation(atsRequest, noOfEmployement, errr);

				}

				if (errr.size() > 0) {
					e = new KronosException("final exception");
					e.setKronosError(errr);
					throw e;
				}

			}

		}

		success = "success after validating education and employement varification";
		atsResponse.setSucess(success);

		return atsResponse;

	}

	private void employementDetailValidation(AtsRequest atsRequest, int noOfEmployement, List<Error> errr) {
		List<Employement> employmentList = atsRequest.getEmployements();
		if (employmentList == null || employmentList.size() < noOfEmployement) {
			Error obj = new Error(1,
					"please provide all Employement details minimum " + noOfEmployement + " employements are required");
			errr.add(obj);
		}
		if(employmentList!= null) {
			for(int i=0;i<employmentList.size();i++) {
				Employement e= employmentList.get(i);
				if(StringUtils.isBlank(e.getEmployerName())) {
					Error obj= new Error(1, "employerName can't be empty in employer ["+i+"]");
					errr.add(obj);
				}
//
				if(StringUtils.isBlank(e.getEmployerAddress())) {
					Error obj= new Error(1, "employerAddress can't be empty in employer ["+i+"]");
					errr.add(obj);
				}
				if(StringUtils.isBlank(e.getEmployerContact())) {
					Error obj= new Error(1, "employerContact can't be empty in employer ["+i+"]");
					errr.add(obj);
				}
				if(StringUtils.isBlank(e.getDesignation())) {
					Error obj= new Error(1, "designation can't be empty in employer ["+i+"]");
					errr.add(obj);
				}
				if(StringUtils.isBlank(e.getStartDate())) {
					Error obj= new Error(1, "startDate can't be empty in employer ["+i+"]");
					errr.add(obj);
				}
				if(StringUtils.isBlank(e.getEndDate())) {
					Error obj= new Error(1, "endDate can't be empty in employer ["+i+"]");
					errr.add(obj);
				}if(e.getIsCurrentEmployee() == null) {
					Error obj= new Error(1, "startDate can't be empty in employer ["+i+"]");
					errr.add(obj);
				}
				
			}
		}

	}

	private void educationDetailValidation(AtsRequest atsRequest, int noOfEducation, List<Error> errr) {
		// education null check and minimum required education check
		List<Education> educationList = atsRequest.getEducations();
		if (educationList == null || educationList.size() < noOfEducation) {

			Error obj4 = new Error(4,
					"please provide all education details minimum " + noOfEducation + " educations are required");
			errr.add(obj4);
		}
		if (educationList != null) {
			for (int i = 0; i < educationList.size(); i++) {
				Education x = educationList.get(i);
				if (StringUtils.isBlank(x.getInstitute())) {
					Error obj5 = new Error(5, "institue name can't be empty in education[" + i + "]");
					errr.add(obj5);
				}
				if (StringUtils.isBlank(x.getDegreeType())) {
					Error obj5 = new Error(5, "Degree can't be empty in education[" + i + "]");
					errr.add(obj5);
				}

				if (StringUtils.isBlank(x.getStartDate())) {
					Error obj5 = new Error(5, "startDate can't be empty in education[" + i + "]");
					errr.add(obj5);
				}
				if (StringUtils.isBlank(x.getEndDate())) {
					Error obj5 = new Error(5, "endDate can't be empty in education[" + i + "]");
					errr.add(obj5);
				}

				if (x.getPercentageOfMarks() == null) {
					Error obj5 = new Error(5, "percentageOfMarks can'not be empty in education[" + i + "]");
					errr.add(obj5);
				}

			}
		}

	}

}
