package com.ats.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @NoArgsConstructor @AllArgsConstructor
public class Employement {
	@NotEmpty(message = "validation fails in employerName")
	private String employerName;
	
	@NotEmpty(message = "validation fails in employerAddress")
	private String employerAddress;
	
	@NotEmpty(message = "validation fails in employerContact")
	private String employerContact;
	
	@NotEmpty(message = "validation fails in designation")
	private String designation;
	
	@NotEmpty(message = "validation fails in startDate")
	private String startDate;
	
	@NotEmpty(message = "validation fails in endDate")
	private String endDate;
	
	
	private Boolean isCurrentEmployee;
	
	
	
}