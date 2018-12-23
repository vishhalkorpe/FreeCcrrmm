package com.crm.qa.testcases;

import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	TestUtil testUtil;
	
	public HomePageTest(){
		
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException{
		
		initialization();
		loginPage = new LoginPage();
		contactsPage = new ContactsPage();
		testUtil = new TestUtil();
		
		homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO");
	}
	
	
	@Test(priority=2)
	public void verifyUserNameTest(){
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyCorrectUserName());
		
	}
	
	@Test(priority=3)
	public void clickOnContactsLinkTest(){
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
	}

}
