package com.ats.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ats.kronos.exceptions.KronosException;
import com.ats.kronos.service.KronosService;
import com.ats.model.AtsRequest;
import com.ats.model.AtsResponse;

@RestController
public class KronosController {
	@Autowired
	KronosService kronosService;

	@PostMapping(value = "/kronosRP")
	public AtsResponse kronosRequestProcessing(@Valid @RequestBody AtsRequest atsRequest) {

		return kronosService.companyValidationService(atsRequest);

	}

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return errors;
	}

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)

	@ExceptionHandler(KronosException.class)
	public List<com.ats.model.Error> handleValidationExceptions(KronosException ex) {
		
		return 		ex.getKronosError();
	}

}
