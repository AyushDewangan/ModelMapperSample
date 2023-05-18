package com.example.demo.exception;

public class StudentNotExist extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public StudentNotExist(String message, String code) {
		super(message + code);
	}

}