package com.api.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListeners implements ITestListener{
	private static final Logger logger = LogManager.getLogger(TestListeners.class);
	
	public void onStart(ITestResult result) {
	    logger.info("Test suit started!");
	  }
	public void onFinish(ITestContext context) {
		logger.info("Test suit completed!");
	  }
	public void onTestStart(ITestResult result) {
		logger.info("Test execution started!");
		logger.info("Test name: "+result.getTestName()+ " ,Test method: "+result.getMethod());
	  }

	public void onTestSuccess(ITestResult result) {
		logger.info("Test passed!");
		logger.info("Test name: "+result.getTestName()+ " ,Test method: "+result.getMethod());
	  }

	public void onTestFailure(ITestResult result) {
		logger.info("Test failed!");
		logger.info("Test name: "+result.getTestName()+ " ,Test method: "+result.getMethod());
	  }
	 public void onTestSkipped(ITestResult result) {
		 logger.info("Test skipped!");
			logger.info("Test name: "+result.getTestName()+ " ,Test method: "+result.getMethod());
		  }
}
