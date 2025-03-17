package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.requests.LogInRequest;
import com.api.requests.ProfileUpdateRequest;
import com.api.responses.LogInResponse;
import com.api.responses.UserProfileResponse;

import io.restassured.response.Response;

public class ProfileUpatePutTest {
	@Test(description= "Verify if get update user profile put API is working correctly")
	public void profileUpdateTest() {
		LogInRequest loginRequest = new LogInRequest("shubh2495", "shubh2495");
		
		AuthService authService= new AuthService();
		Response response = authService.logIn(loginRequest);
		LogInResponse res = response.as(LogInResponse.class);
		String tokenforUser = res.getToken();
		System.out.println(tokenforUser);
		System.out.println("-----------------------------------------");
		UserProfileManagementService ums= new UserProfileManagementService();
		Response profileResposne= ums.getUserProfile(tokenforUser);
		UserProfileResponse deserializedResonse = profileResposne.as(UserProfileResponse.class);//deserialization
		System.out.println(deserializedResonse.getEmail());
		System.out.println(profileResposne.asPrettyString());
		System.out.println("-----------------------------------------");
		ProfileUpdateRequest profileUpdateRequest = new ProfileUpdateRequest.Builder().firstName("SHUBH")
				.lastName("GUPTA")
				.email("abc123343@gmail.com").mobileNumber("2222222222").build();
												
		response = ums.updateProfilePut(tokenforUser, profileUpdateRequest);
		System.out.println(response.asPrettyString());
			
	}

}
