package com.assign.test.service;

import java.util.Collection;
import java.util.Set;

import com.assign.test.model.User;
import com.assign.test.response.BaseResponse;

public interface UserService {

	
	public BaseResponse saveUserDetails(User user);
	
	public BaseResponse updateUser(User userRequest);
	
	public Collection<User> getUserDetails();

	public BaseResponse deleteUser(String id);
	
	
}
