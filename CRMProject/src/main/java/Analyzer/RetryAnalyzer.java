package Analyzer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.crm.qa.base.TestBase;



public class RetryAnalyzer extends TestBase implements IRetryAnalyzer {

	int counter = 0;
	int retryLimit = 3;

	public boolean retry(ITestResult arg0) {
		
		if(counter<retryLimit){
			counter++;
			return true;
		}

		return false;
	}

}
