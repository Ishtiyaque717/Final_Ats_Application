package com.ats.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter @Getter @AllArgsConstructor @NoArgsConstructor
public class Candidate {
	
	@NotNull(message = "firstName is Null")
	@NotBlank(message = "firstName is Blank")
	private String firstName;
	
	@NotNull(message = "lastName is Null")
	@NotBlank(message = "lastName is Blank")
	private String lastName;
	
	@NotNull(message = "email is null")
	@Email(message = "email format is wrong")
	private String email;
	
	@NotEmpty(message = "validation fails in dateOfBirth")
	private String dateOfBirth;
	
	@NotEmpty(message = "validation fails in mobile")
	private String mobile;


	
}
