package Analyzer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.IAnnotation;
import org.testng.annotations.ITestAnnotation;

import com.crm.qa.base.TestBase;

public class MyTransformer extends TestBase implements IAnnotationTransformer {

	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
	
		annotation.setRetryAnalyzer(RetryAnalyzer.class);
		
	}
	
	

}
