package com.ats.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BackgroundRequestor {
	@NotBlank(message = "companyName is Blank")
	@NotNull(message = "companyName is Null")
	private String companyName;

	@NotNull(message = "packageId is null")
	@Size(min = 1, max = 5,message = "packageId must be between 3 to 5")
	private String packageId;
	
	@NotEmpty(message = "validation fails in companyContactDetail")
	private String companyContactDetail;

	
	
}
