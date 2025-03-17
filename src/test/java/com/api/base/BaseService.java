package com.api.base;

import com.api.filters.LoggingFilters;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {
	//This class is wrapper for restAssured
	//to introduce abstraction
	//Base URI
	//Creating the request 
	//Handling the response
	//Service Object Model works on business logic & services
	//http://64.227.160.186:8080/swagger-ui/index.html
	private static final String baseURI= "http://64.227.160.186:8080";
	private RequestSpecification requestSpecification;
	static{
		LoggingFilters filters = new LoggingFilters();
		RestAssured.filters(filters);
	}
	public BaseService() {
		requestSpecification=  RestAssured.given().baseUri(baseURI);
}
	protected void setAuthToken(String token) {
		requestSpecification.header("Authorization","Bearer "+token);
	}
	protected Response postRequest(Object payload, String endPoint) {
		return requestSpecification.contentType(ContentType.JSON).body(payload).post(endPoint);
	}
	protected Response getRequest(String endPoint) {
		return requestSpecification.get(endPoint);
	}
	
	protected Response putRequest(Object payload, String endPoint) {
		return requestSpecification.contentType(ContentType.JSON).body(payload).put(endPoint);
	}

}
