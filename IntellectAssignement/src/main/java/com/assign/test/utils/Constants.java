package com.assign.test.utils;

import com.fasterxml.jackson.annotation.JsonValue;

public class Constants {

	
	public enum Message{
		INVALIDDATA("Field contain invalid data."),
		DUPLICATE("User details already exist. ");
		
  
		private String message;
		
		private Message(String message){
			
			this.message = message;
		};
		
		@JsonValue
		public String getErrorMessage(){
			return this.message;
			
		}
	   
	}
	
	public enum ResponseMesssage {
		
		ResponseMesssage("Field contain invalid data."),
		DUPLICATE("User details already exist. "),
		SUCCESS("Succefully user details saved."),
		SERVICEEXCEPTION("Service exception please try again."),
		RECORDNOTFOUND("User record not found using id."),
		BIRTHDATEFUTURE("Birth date is future date.");
     
		private String message;
		
		private ResponseMesssage(String message){
			
			this.message = message;
		};
		
		@JsonValue
		public String getErrorMessage(){
			return this.message;
			
		}
		
	}
	public enum ErrorCode {
		DUPLICATE(101),
		INVALIDDATA(102),
		VALIDATIOINERROR(103),
		BIRTHDATEFUTURE(104);
		
		private int errorCode;
		
		private ErrorCode(int errorCode){
			this.errorCode = errorCode;
		}
		
		@JsonValue
		public int getErrorCode(){
			return this.errorCode;
		}
	}
}
