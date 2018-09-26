package com.crm.qa.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestChk {

	public static void main(String[] args) throws InterruptedException {

		
			System.out.println("WebDriver Demo");
					
			System.setProperty("webdriver.gecko.driver", "E:\\SoftEdge\\setup\\Browser\\geckodriver-v0.19.1-win64\\geckodriver.exe");
			WebDriver driver = new FirefoxDriver();
			
			driver.get("https://www.freecrm.com/");
			System.out.println(driver.getTitle());
			
			driver.findElement(By.xpath(".//input[@name='username']")).sendKeys("vishhal");
			driver.findElement(By.xpath(".//input[@name='password']")).sendKeys("vishhal123");
			Thread.sleep(5000);
			driver.findElement(By.xpath(".//form[@id='loginForm']//input[@value='Login']")).click();
		
		
		
		
	}

}
