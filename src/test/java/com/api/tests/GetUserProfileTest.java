package com.api.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.requests.LogInRequest;
import com.api.responses.LogInResponse;
import com.api.responses.UserProfileResponse;

import io.restassured.response.Response;
@Listeners(com.api.listeners.TestListeners.class)
public class GetUserProfileTest {
	@Test(description= "Verify if get user profile API is working correctly")
	public void getProfileInfoTest() {
		LogInRequest loginRequest = new LogInRequest("shubh2495", "shubh2495");
		
		AuthService authService= new AuthService();
		Response response = authService.logIn(loginRequest);
		LogInResponse res = response.as(LogInResponse.class);
		String tokenforUser = res.getToken();
		System.out.println(tokenforUser);
		UserProfileManagementService ums= new UserProfileManagementService();
		Response profileResposne= ums.getUserProfile(tokenforUser);
		UserProfileResponse deserializedResonse = profileResposne.as(UserProfileResponse.class);//deserialization
		System.out.println(profileResposne.asPrettyString());
		System.out.println("First Name is: "+deserializedResonse.getFirstName());
		System.out.println("Last Name is: "+deserializedResonse.getMobileNumber());
	}

}
