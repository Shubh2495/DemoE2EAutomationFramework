package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.requests.LogInRequest;
import com.api.responses.LogInResponse;
import io.restassured.response.Response;

public class LogInAPI {
	
	@Test(description= "Verify if logIn API working correctly")
	public void logInTest() {
		LogInRequest loginRequest = new LogInRequest("shubh2495", "shubh2495");
		
		AuthService authService= new AuthService();
		Response response = authService.logIn(loginRequest);
		LogInResponse res = response.as(LogInResponse.class);
		System.out.println(response.asPrettyString());
		System.out.println("Email is: "+res.getEmail());
		System.out.println("user naame is: "+res.getUsername());
		Assert.assertEquals(res.getId(),423);
	}
		
}
  
