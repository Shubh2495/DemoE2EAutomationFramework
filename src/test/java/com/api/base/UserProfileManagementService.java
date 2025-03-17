package com.api.base;

import com.api.requests.ProfileUpdateRequest;

import io.restassured.response.Response;

public class UserProfileManagementService extends BaseService {
	private static final String basePath="/api/users/";
	
	public Response getUserProfile(String token) {
		setAuthToken(token);
		return getRequest(basePath+"profile");
		
	}
	public Response updateProfilePut(String token, ProfileUpdateRequest payload) {
		setAuthToken(token);
		return putRequest(payload, basePath+"profile");
		
	}

}
