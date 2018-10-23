package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.testNGListener.CustomListener;

@Listeners(CustomListener.class) // calling listener class so that on every failed test case it will take the screenshot.
public class ScreenShotTest extends TestBase {

	public ScreenShotTest() {

		super(); // 1. before calling initialization we need to call testbase
					// constructor also as it reads file for initialization.
	}

	@BeforeMethod
	public void setUp() {
		initialization(); // 2.calling initialization from testbase class.

	}

	@Test
	public void takeScreenShotTest1() {

		Assert.assertEquals(true, false);

	}
	
	@Test
	public void takeScreenShotTest2() {

		Assert.assertEquals(true, false);

	}
	
	@Test
	public void takeScreenShotTest3() {

		Assert.assertEquals(true, false);

	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}
}
