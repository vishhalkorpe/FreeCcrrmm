package com.crm.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;

	public TestBase(){
		try{
			prop = new Properties();
			FileInputStream ip = new FileInputStream("E:\\WorkSpace\\CRMProject\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(ip);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	
	public static void initialization(){
		String browsername = prop.getProperty("browser");
		
		if(browsername.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "E:\\SoftEdge\\setup\\Browser\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browsername.equals("FF")){
			System.setProperty("webdriver.gecko.driver", "E:\\SoftEdge\\setup\\Browser\\geckodriver-v0.19.1-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
	}
	
	public void failed(String testMethodName){
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			//FileUtils.copyFile(scrFile, new File("E:\\WorkSpace\\CRMProject\\screenshots\\testfailure.jpg")); //will overwrite the jpg with latest failure shots.
			//FileUtils.copyFile(scrFile, new File("E:\\WorkSpace\\CRMProject\\screenshots\\"+"failshot_"+this.getClass().getName()+"_"+".jpg"));
			FileUtils.copyFile(scrFile, new File("E:\\WorkSpace\\CRMProject\\screenshots\\"+testMethodName+"_"+".jpg"));
			} catch (IOException e) {e.printStackTrace();}
	}
	
	public static void clickOn(WebDriver driver,WebElement locator,int timeout){
		
		new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(locator));
		
		//in test-case just call clickOn(driver,driver.findElement(By.id(someid)),20); //will wait for 20 sec to load login button.
		
		//OR syntax:-
		 //WebDriverWait wait = new WebDriverWait(driver, 10);

		// WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id(>someid>)));
	}
	

}