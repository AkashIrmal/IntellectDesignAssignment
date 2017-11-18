package com.assign.test.response;

import java.util.List;

import com.assign.test.utils.Constants.ResponseMesssage;

public class BaseResponse {

	private ResponseMesssage responseMsg;
	private String userId;
	private List<ErrorMessage> valErrors;

	public ResponseMesssage getResponseMsg() {
		return responseMsg;
	}

	public void setResponseMsg(ResponseMesssage responseMsg) {
		this.responseMsg = responseMsg;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<ErrorMessage> getValErrors() {
		return valErrors;
	}

	public void setValErrors(List<ErrorMessage> valErrors) {
		this.valErrors = valErrors;
	}

}
