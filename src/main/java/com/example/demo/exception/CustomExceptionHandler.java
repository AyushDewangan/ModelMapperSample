package com.example.demo.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

	@ResponseStatus(HttpStatus.FOUND)
	@ExceptionHandler(StudentNotExist.class)
	public Map<String, String> handelStudentNotExist(StudentNotExist ex) {
		Map<String, String> errors = new HashMap<>();
		errors.put("error", getMessage(ex.getMessage()));
		errors.put("code",getCode(ex.getMessage()));
		return errors;
	}
	
	public String getCode(String message) {
		String errorCode = null;
		String[] value = message.split(":");
		errorCode = value[value.length-1];
		return errorCode;
	}
	
	public String getMessage(String message) {
		String errorCode = null;
		String[] value = message.split(":");
		errorCode = value[0];
		return errorCode;
	}
}