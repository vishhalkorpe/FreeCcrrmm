package GoogleSearch;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GoogleSearch {
	
	public static void main(String[] args) throws InterruptedException {

		
		System.out.println("WebDriver Demo");
				
		System.setProperty("webdriver.gecko.driver", "E:\\SoftEdge\\setup\\Browser\\geckodriver-v0.19.1-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.google.com/");
		
		driver.findElement(By.id("lst-ib")).sendKeys("Java");
		
		Thread.sleep(3000);
				
		List <WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//li[@class='sbsb_c gsfs']"));
		// /descendant::div[@class='sbpqs_d sbse']
		System.out.println("Total number of suggestion for Java" + list.size());
		
		//Print all list
		
		for(int i=0;i<list.size();i++){
			
			System.out.println(list.get(i).getText());
			
			//If Java Tutorial is found click on it
			
			if(list.get(i).getText().contains("java tutorial")){
				
				list.get(i).click();
				
				break;
			}
		}
	
	
	
	
}


}
