package com.spatome.demo.core.exception;

public class SException extends RuntimeException {
	private static final long serialVersionUID = 7576132341064220344L;

	private String code;
	
	public SException() {
	}

	public SException(String code, String message) {
		super(message);
		this.setCode(code);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}