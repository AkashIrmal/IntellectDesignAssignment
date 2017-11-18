package com.assign.test.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.assign.test.model.User;
import com.assign.test.response.BaseResponse;
import com.assign.test.response.ErrorMessage;
import com.assign.test.utils.Constants.ErrorCode;
import com.assign.test.utils.Constants.Message;
import com.assign.test.utils.Constants.ResponseMesssage;

@Service
public class UserServiceImpl implements UserService {

	private Map<String, User> userList = new HashMap<String, User>();

	@Override
	public BaseResponse saveUserDetails(User userRequest) {
		BaseResponse response = new BaseResponse();
		try {
			
				User user = getUserByEmailId(userRequest.getEmail());
				if (user != null) {
					if (user.isActive()) {
						List<ErrorMessage> errorList = new ArrayList<ErrorMessage>();
						ErrorMessage errorMessage = new ErrorMessage();
						errorMessage.setCode(ErrorCode.DUPLICATE);
						errorMessage.setMessage(Message.DUPLICATE);
						response.setResponseMsg(ResponseMesssage.DUPLICATE);
						errorList.add(errorMessage);
						response.setValErrors(errorList);
						return response;
					}
				}
			
            if(validateBirthDate(userRequest.getDateOfBirth())){
				response.setResponseMsg(ResponseMesssage.BIRTHDATEFUTURE);
				return response;
            }
			String uniqueIdentifier = UUID.randomUUID().toString();
			userRequest.setId(uniqueIdentifier);
			userRequest.setActive(true);
			userList.put(uniqueIdentifier, userRequest);
			response.setUserId(uniqueIdentifier);
			response.setResponseMsg(ResponseMesssage.SUCCESS);
			return response;
		} catch (Exception e) {
            response.setResponseMsg(ResponseMesssage.ResponseMesssage.SERVICEEXCEPTION);
            e.printStackTrace();
            return response;
		}
	}

	private boolean validateBirthDate(Date dateOfBirth) {
		return new Date().before(dateOfBirth);
		
	}

	@Override
	public Collection<User> getUserDetails() {
		return userList.values();
	}

	private User getUserByEmailId(String email) {
		Collection<User> users = userList.values();
		User user = users.stream().filter(x -> x.getEmail().equals(email)).findFirst().orElse(null);
		return user;
	}

	@Override
	public BaseResponse updateUser(User userRequest) {
		BaseResponse response = new BaseResponse();
		
		try{
			  if(userList.containsKey(userRequest.getId())){
				  if(validateBirthDate(userRequest.getDateOfBirth())){
						response.setResponseMsg(ResponseMesssage.BIRTHDATEFUTURE);
						return response;
		            }
				  User user = userList.get(userRequest.getId());
				  user.setPinCode(userRequest.getPinCode());
				  user.setDateOfBirth(userRequest.getDateOfBirth());
				  userList.put(user.getId(),user);
				  response.setResponseMsg(ResponseMesssage.SUCCESS);
			  }else{
				  response.setResponseMsg(ResponseMesssage.RECORDNOTFOUND);
			  }
			return response;  
		}catch(Exception e){
			response.setResponseMsg(ResponseMesssage.ResponseMesssage.SERVICEEXCEPTION);
			e.printStackTrace();
			return response;
		}
	}

	@Override
	public BaseResponse deleteUser(String id) {
		BaseResponse response = new BaseResponse();
		
		try{
			  if(userList.containsKey(id)){
				  userList.remove(id);
				  response.setResponseMsg(ResponseMesssage.SUCCESS);
			  }else{
				  response.setResponseMsg(ResponseMesssage.RECORDNOTFOUND);
			  }
			return response;  
		}catch(Exception e){
			response.setResponseMsg(ResponseMesssage.ResponseMesssage.SERVICEEXCEPTION);
			e.printStackTrace();
			return response;
		}	}

}
