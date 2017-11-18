package com.assign.test.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.assign.test.model.User;
import com.assign.test.response.BaseResponse;
import com.assign.test.service.UserService;

@RestController

public class UserController {

	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/saveUser", method = RequestMethod.POST)
	public ResponseEntity<BaseResponse>  saveUserDetails(@RequestBody User userRequest){
		
		return new ResponseEntity<BaseResponse>(userService.saveUserDetails(userRequest),HttpStatus.OK);
	}
	
	
	@RequestMapping(value={"/getUserDetails","/"}, method = RequestMethod.GET)
	private Collection<User> getUserDetails(){
		return userService.getUserDetails();
	} 
	
	@RequestMapping(value="/updateUser", method = RequestMethod.POST)
	public ResponseEntity<BaseResponse> updateUser(@RequestBody User userRequest){
		return new ResponseEntity<BaseResponse>(userService.updateUser(userRequest),HttpStatus.OK);
	}
	
	@RequestMapping(value="/deleteUser/{id}", method = RequestMethod.POST)
	public ResponseEntity<BaseResponse> deleteUser(@PathVariable("id") String id){
		return new ResponseEntity<BaseResponse>(userService.deleteUser(id),HttpStatus.OK);
	}
}
