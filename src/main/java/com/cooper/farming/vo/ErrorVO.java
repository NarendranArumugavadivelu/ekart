package com.cooper.farming.vo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class ErrorVO implements Serializable {

	private static final long serialVersionUID = 17232398232302930L;

	@JsonProperty("code")
	private String errorCode;
	
	@JsonProperty("message")
	private String errorMessage;

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return "ErrorVO [errorCode=" + errorCode + ", errorMessage=" + errorMessage + "]";
	}
	
	
	
}
