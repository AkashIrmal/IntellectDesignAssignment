package com.assign.test.response;

import com.assign.test.utils.Constants.ErrorCode;
import com.assign.test.utils.Constants.Message;

public class ErrorMessage {

	private ErrorCode code;
	private Message message;
	private String field;

	public ErrorCode getCode() {
		return code;
	}

	public void setCode(ErrorCode code) {
		this.code = code;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

}
