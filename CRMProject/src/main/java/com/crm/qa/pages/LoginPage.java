package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactoryFinder;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	//Page factory or Object Repository 
	
	@FindBy(xpath=".//input[@name='username']")
	WebElement username;
	
	@FindBy(xpath=".//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath=".//form[@id='loginForm']//input[@value='Login']")
	WebElement loginBtn;
	
	/*@FindBy(xpath="//div[@id='navbar-collapse']/ul[@class='nav navbar-nav navbar-right']//font[.='Sign Up']")
	WebElement singnUpBtn;*/
	
	@FindBy(linkText="https://www.freecrm.com/register/")
	WebElement singnUpBtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	
	//Initializing the Page Object
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateLoginPageTitle(){
		
		return driver.getTitle();
	}
	
	public boolean validateCRMImage(){
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd) throws InterruptedException{
		username.sendKeys(un);
		password.sendKeys(pwd);
		Thread.sleep(5000);
		loginBtn.click();
		
		return new HomePage();   //this is returing home page
	}
	
}
