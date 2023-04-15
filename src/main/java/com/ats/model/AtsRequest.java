package com.ats.model;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Validated
public class AtsRequest {

	@Valid
	@NotNull(message = "backgroundRequestor is Null")
	BackgroundRequestor backgroundRequestor;

	@Valid
	@NotNull(message = "Candidate is Null")
	Candidate candidate;

	List<Education> educations;

	@Valid
	@NotNull(message = "employements is Null")
	@Size(min = 1, message = "atleast 1 employement is mandatory")
	List<Employement> employements;

}
