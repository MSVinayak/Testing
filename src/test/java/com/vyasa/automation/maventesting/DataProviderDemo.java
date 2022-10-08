package com.vyasa.automation.maventesting;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.IFactoryAnnotation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class DataProviderDemo {
	WebDriver driver;
  @BeforeClass
  public void OpenBrowser() {
	  System.setProperty("webdriver.chrome.driver", "G:\\javaautomation\\maventesting\\drivers\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("https://practice.automationtesting.in/my-account/");
	  driver.manage().window().maximize();
  }
  @Test(dataProvider="LoginData")
  public void verifyUserLogon(String tcName,String username,String password) {
	 WebElement userEle= driver.findElement(By.xpath("//input[@id=\"username\"]"));
	 userEle.clear();
	 userEle.sendKeys(username);
	 WebElement passwordEle=driver.findElement(By.xpath("//input[@id=\"password\"]"));
	 passwordEle.clear();
	 passwordEle.sendKeys(password);
	 driver.findElement(By.xpath("//input[@name=\"login\"]")).click();
  }
  //validations
  
 
  @DataProvider 
  public Object[][] LoginData(){
	return new Object[][] {{"succlogin","vyasainstitute2022@gmail.com","Vyasa@12345"}};
	  
  }

  @AfterClass
  public void closeBrowser() {
	  
	  driver.quit();
  }

}
