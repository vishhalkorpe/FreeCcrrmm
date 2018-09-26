package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.testNGListener.CustomListener;

//@Listeners(CustomListener.class)   //calling listener to get screenshot.

public class MyRetryTest extends TestBase {
	
	public MyRetryTest(){
		
		super(); //calling testbase constructor
	}
	
	@BeforeMethod
	public void setUp(){
		
		initialization();
	}
	
	@AfterMethod
	public void tearDown(){
		
		driver.quit();
	}
	
	//@Test(retryAnalyzer= Analyzer.RetryAnalyzer.class)   NOT A GOOD APPROACH Because we need to add thid to every test case.
	
	@Test
	public void test1(){
		System.out.println("Test1 failed");
		Assert.assertEquals(false, true);
	}
	
	@Test
	public void test2(){
		System.out.println("Test2 failed");
		Assert.assertEquals(false, true);
	}
	
	

}
