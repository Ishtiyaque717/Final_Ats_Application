package com.ats.kronos.exceptions;

import java.util.List;

import com.ats.model.Error;

import lombok.Data;

@Data
public class KronosException extends RuntimeException {

	List<Error> kronosError;
	
	public KronosException(String arg) {
		super(arg);
	}

}
