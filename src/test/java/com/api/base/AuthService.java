package com.api.base;

import java.util.HashMap;
import java.util.LinkedHashMap;

import com.api.requests.LogInRequest;
import com.api.requests.SignUpRequest;

import io.restassured.response.Response;

public class AuthService extends BaseService{
	private static final String basePath="/api/auth/";
	
	public Response logIn(LogInRequest payload) {
		
		return postRequest(payload,basePath+"login");
		
	}
public Response signUp(SignUpRequest payload) {
		
		return postRequest(payload,basePath+"signup");
		
	}
public Response forgotPassword(String emailAddress) {
	//here not using pojo class as only one paramter is there in pay load of forgot
	HashMap<String, String> payload= new LinkedHashMap<String, String>();
	payload.put("email", emailAddress);
	return postRequest(payload,basePath+"forgot-password");
	
}
	

}
