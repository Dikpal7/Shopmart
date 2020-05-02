package com.ShoppingBackEnd.payload;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CommonResponse<T> {

	public CommonResponse(ApiResponse header, T data) {
		super();
		this.header = header;
		this.data = data;
	}

	@JsonProperty("header")
	private ApiResponse header;

	@JsonProperty("data")
	private T data;

	public ApiResponse getHeader() {
		return header;
	}

	public void setHeader(ApiResponse header) {
		this.header = header;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
