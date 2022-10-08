package com.vyasa.automation.maventesting;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class CrossBrowserTesting {
	
	public WebDriver driver;
  @Parameters("browser")
  @BeforeClass
  public void browserlaunch(String browser) {
	  if(browser.equalsIgnoreCase("chrome")) {
		  System.setProperty("webdriver.chrome.driver", "G:\\javaautomation\\maventesting\\drivers\\chromedriver.exe");
		  driver=new ChromeDriver();
		  System.out.println("chrome opened succesfully");
	  }else if(browser.equalsIgnoreCase("firefox")) {
		  System.setProperty("webdriver.gecko.driver", "G:\\javaautomation\\maventesting\\drivers\\geckodriver.exe");
		  driver=new FirefoxDriver();
		  System.out.println("firefox opened succesfully");
	  }else if (browser.equalsIgnoreCase("edge")){
		  System.setProperty("webdriver.edge.driver", "G:\\javaautomation\\maventesting\\drivers\\msedgedriver.exe");
		  driver=new EdgeDriver();
		  System.out.println("Edge opened succesfully");
	  }
	   
	  driver.get("https://practice.automationtesting.in/my-account/");
	  driver.manage().window().maximize();
  }
  @Parameters({"username","password"})
  @Test
  public void verifyUserLogin(String username,String password) {
	  driver.findElement(By.xpath("//input[@id=\"username\"]")).sendKeys(username);
	  driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys(password);
	  driver.findElement(By.xpath("//input[@name=\"login\"]")).click();
	 boolean actualvalue= driver.findElement(By.xpath("//*[contains(text(),'Hello')]")).isDisplayed();
      Assert.assertTrue(actualvalue);
  }
 

  @AfterClass
  public void closeBrowser() {
	  driver.quit();
  }

}
