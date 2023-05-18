package com.example.demo.exception;

public enum CustomExceptionCode {
	
	STUDENT_NOT_FOUND("E001","Student not Found:"),
	STUDENT_ALREADY_EXIST("E001","Student already exist.");
	
	private final String errCode;
	private final String errMsg;

	private CustomExceptionCode(final String errCode, final String errMsg) {
		this.errCode = errCode;
		this.errMsg = errMsg;
	}

	public String getErrCode() {
		return errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	@Override
	public String toString() {
		return errCode + " : " + errMsg;
	}

}
