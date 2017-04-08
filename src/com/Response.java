package com;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="response")
public class Response {
	private int stateCode;
	private String errorMessage;
	private int successMessage;
	
	
	public int getStateCode() {
		return stateCode;
	}
	public void setStateCode(int stateCode) {
		this.stateCode = stateCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public int getSuccessMessage() {
		return successMessage;
	}
	public void setSuccessMessage(int id) {
		this.successMessage = id;
	}

}
