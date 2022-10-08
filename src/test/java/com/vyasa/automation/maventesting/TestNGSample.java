package com.vyasa.automation.maventesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGSample {
	
	WebDriver driver;
	 
	  @Test
	  public void openBrowser() {
		  
			System.setProperty("webdriver.chrome.driver", "G:\\javaautomation\\maventesting\\drivers\\chromedriver.exe");
		    driver=new ChromeDriver();
			driver.get("https://www.amazon.in/");
			driver.manage().window().maximize();
		  
		 
	  }
	  @Test
	  public void verifyHomePageLoaded() {
		  //1 locate element
		  //2 Perform action on element
		  //3 validation ===> pass/fail
		  
		  String exceptedURL="https://www.amazon.in/";
		  String actualURL=driver.getCurrentUrl();
		  System.out.println(actualURL);
		  Assert.assertEquals(actualURL, exceptedURL);
	  }
	  @Test
	  public void verifyCartDisplay() {
		  
		  WebElement cartEle=driver.findElement(By.xpath("//*[@id=\"nav-cart-count\"]"));
		 boolean actualValue= cartEle.isDisplayed();
		 System.out.println(actualValue);
		 Assert.assertEquals(actualValue, true); 
		 driver.close();
		 }
	  
	  
	  
	  
	  
}
