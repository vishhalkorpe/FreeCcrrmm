package com.crm.qa.testcases;

import static org.testng.Assert.assertFalse;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.Guru99TakeScreenshot;

public class LoginPageTest extends TestBase {
	LoginPage loginpage; //defined at class level here because we can use it throughout class here.
	HomePage homepage;
	
	public LoginPageTest(){
		
		super();    //1. before calling initialization we need to call testbase constructor also as it reads file for initialization.
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();	//2.calling initialization from testbase class.
		loginpage = new LoginPage();  // so that we can access all methods of login page.
		
				
	}
	
	
   	@Test(priority = 1)
	public void loginPageTitleTest() throws Exception{
		String title = loginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");
		Thread.sleep(5000);
		//Call take screenshot function
        Guru99TakeScreenshot.takeSnapShot(driver, "E:\\WorkSpace\\CRMProject\\test1.png") ;
	}
	
	@Test(priority = 2)
	public void crmlogoImageTest(){
		
		boolean flag =loginpage.validateCRMImage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority = 3)
	public void loginTest() throws InterruptedException{
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
		}
	
	
	
	
	
	
	
	
	
}
