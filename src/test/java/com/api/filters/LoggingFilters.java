package com.api.filters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class LoggingFilters implements Filter {
	private static final Logger logger= LogManager.getLogger(LoggingFilters.class);

	public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec,
			FilterContext ctx) {
		logRequest(requestSpec);
		Response response= ctx.next(requestSpec, responseSpec); //request will continue to execute
		logResposne(response);
		
		return response;// test for assertion
	}
    
	public void logRequest(FilterableRequestSpecification requestSpec) {
		logger.info("BASE URL: "+requestSpec.getBaseUri());
		logger.info("Request Body :"+requestSpec.getBody());
		logger.info("Headers :"+requestSpec.getHeaders());
	}
public void logResposne(Response res) {
	logger.info("Status code: "+res.getStatusCode());
	logger.info("Resposne body :"+res.getBody().asPrettyString());
	logger.info("Response Header :"+res.headers());
		
	}
}
