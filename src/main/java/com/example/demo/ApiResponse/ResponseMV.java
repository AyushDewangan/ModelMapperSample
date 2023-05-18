package com.example.demo.ApiResponse;

public class ResponseMV {

	private Boolean status;
	private String message;

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ResponseMV [status=" + status + ", message=" + message + "]";
	}
}
