package BrokenLinks;

import java.io.IOException;
import java.net.HttpURLConnection;       //Import below package in addition to default packages:
										//Using the methods in this package, we can send HTTP requests and capture HTTP response codes from the response.
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBrokenLinks {
    
    private static WebDriver driver = null;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
    	
    	String homePage = "http://www.zlti.com";  
        String url = "";
        HttpURLConnection huc = null;
        int respCode = 200;
        
        System.setProperty("webdriver.chrome.driver", "D://softwares//browsers//chromedriver_win32//chromedriver.exe");
		driver = new ChromeDriver();
        
        driver.manage().window().maximize();
        
        driver.get(homePage);
        
        List<WebElement> links = driver.findElements(By.tagName("a"));     //Identify all links in a webpage and store them in List.
        
        Iterator<WebElement> it = links.iterator();						//Obtain Iterator to traverse through the List.
        
        while(it.hasNext()){
            
            url = it.next().getAttribute("href");		//Get href of anchor tag and store it in url variable.
            
            System.out.println(url);
            											//Check if URL is null or Empty and skip the remaining steps if the condition is satisfied.
            if(url == null || url.isEmpty()){
            	System.out.println("URL is either not configured for anchor tag or it is empty");
                continue;
            }
            								//Check whether URL belongs to a main domain or third party. Skip the remaining steps if it belongs to third party domain.
            if(!url.startsWith(homePage)){
                System.out.println("URL belongs to another domain, skipping it.");
                continue;
            }
            
            try {
                huc = (HttpURLConnection)(new URL(url).openConnection()); //HttpURLConnection class has methods to send HTTP request and capture HTTP response code. 
                														//So, output of openConnection() method (URLConnection) is type casted to HttpURLConnection.
                
                huc.setRequestMethod("HEAD"); //We can set Request type as "HEAD" instead of "GET". So that only headers are returned and not document body.
                
                huc.connect();		//On invoking connect() method, actual connection to url is established and the request is sent.
                
                respCode = huc.getResponseCode(); //VALIDATING LINKS Using getResponseCode() method we can get response code for the request
                
                if(respCode >= 400){			//Based on response code we will try to check link status.
                    System.out.println(url+" is a broken link");
                }
                else{
                    System.out.println(url+" is a valid link");
                }
                    
            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
        driver.quit();   //Thus, we can obtain all links from web page and print whether links are valid or broken.

    }
}