 package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.requests.SignUpRequest;

import io.restassured.response.Response;

public class AccountCreationTest {
	
	@Test(description= "Verify if SignUp API working correctly")
	public void signUpTest() {
		
		SignUpRequest signUpRequest= new SignUpRequest.Builder().username("shubh2495")
		.firstName("shubham")
		.lastName("guptaa")
		.email("abc122@gmail.com")
		.mobileNumber("9876943212")
		.password("shubh2495")
		.build();
		
		AuthService authService= new AuthService();
		Response response=authService.signUp(signUpRequest);
		Assert.assertEquals(response.statusCode(), 200);
		
		
	}

}
