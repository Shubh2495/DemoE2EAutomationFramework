package com.api.tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.api.base.AuthService;
import com.api.responses.ForgotPasswaordResponse;

import io.restassured.response.Response;

public class ForgotPasswordAPITest {
	
	@Test(description= "Verify if forgot passwaord API working correctly")
	public void forgotPasswordTest() {
		AuthService authService= new AuthService();
		Response response=authService.forgotPassword("a23bcee@yahoo.com");
		Assert.assertEquals(response.statusCode(), 200);
	     System.out.println(response.asPrettyString());	
	     ForgotPasswaordResponse res= response.as(ForgotPasswaordResponse.class);
	     System.out.println(res.getMessage());
	     Assert.assertEquals(res.getMessage(), "If your email exists in our system, you will receive reset instructions.");
	}

}
