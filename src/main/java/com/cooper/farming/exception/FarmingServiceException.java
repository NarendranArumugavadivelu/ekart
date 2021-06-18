package com.cooper.farming.exception;

import java.io.Serializable;

import com.cooper.farming.vo.ErrorVO;

public class FarmingServiceException extends Exception implements Serializable {
	
	private static final long serialVersionUID = 1055400178965046307L;
	
	private final ErrorVO errorVO;
	
	public FarmingServiceException(String message, ErrorVO errorVO) {
		super(message);
		this.errorVO = errorVO;
	}

	public ErrorVO getErrorVO() {
		return errorVO;
	}
}
