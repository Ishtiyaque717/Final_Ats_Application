package com.ats.model;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Education {
	@NotEmpty(message = "validation fails in institute")
	private String institute;

	@NotEmpty(message = "validation fails in degreeType")
	private String degreeType;

	@NotEmpty(message = "validation fails in startDate")
	private String startDate;

	@NotEmpty(message = "validation fails in endDate")
	private String endDate;

	private Double percentageOfMarks;

}