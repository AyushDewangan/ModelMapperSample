package com.example.demo.ApiResponse;

public class CustomResponse {

	private final Object data;

	public CustomResponse() {
		this(null);
	}

	public CustomResponse(Object data) {
		this.data = data;
	}

	public Object getData() {
		return data;
	}

	@Override
	public String toString() {
		return "CustomResponse [data=" + data + "]";
	}
}