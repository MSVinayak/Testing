package com.vyasa.automation.maventesting;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class HomepageAutomation {
  
  WebDriver driver;
  @BeforeClass
  public void browserSetup() 
  {
	  System.setProperty("webdriver.chrome.driver", "G:\\javaautomation\\maventesting\\drivers\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("https://practice.automationtesting.in/");
	  driver.manage().window().maximize();
  }
  
  @Test(description="verify Homepage is lodead",priority=1)
  public void verifyHomepageLodead() 
  {
	  String actualTitle=driver.getTitle();
	  Assert.assertEquals(actualTitle, "Automation Practice Site");
  }
  @Test(description="verify New arriva is IsDispled",priority=2)
  public void verifyNewarrivalsIsDispled() 
  {
	 boolean actualValue=driver.findElement(By.tagName("h2")).isDisplayed();
	 System.out.println(actualValue);
	 Assert.assertTrue(actualValue);
  }
  @Test(description="verify Homepage With Three Slider",priority=3)
  public void homepageWithThreeSlider() 
  {
	int sliderCount=driver.findElements(By.xpath("//img[@class=\"n2-ss-slide-background-image n2-ss-slide-fill n2-ow\"]")).size();
	 System.out.println(sliderCount);
	 Assert.assertEquals(sliderCount, 3);
  }
  @Test(description="verify Homepage With Three Arrivals",priority=4)
  public void homepageWithThreeArrivals() 
  {
	int arrivalsCount=driver.findElements(By.tagName("h3")).size();
	 System.out.println(arrivalsCount);
	 Assert.assertEquals(arrivalsCount, 3);
  }
  @Test(description="verify Homepage With Three Arrivals is Nevigation",priority=4)
  public void homepageWithThreeArrivalsNevigation() 
  {
	List<WebElement> listimgBook=driver.findElements(By.xpath("//img[@loading=\"lazy\"]"));
	
	for (WebElement imgEle : listimgBook) {
		if(imgEle.getAttribute("title").equalsIgnoreCase("Selenium Ruby"))
		{
			imgEle.click();
			String actualBookTitle=driver.findElement(By.tagName("h3")).getText();
			Assert.assertEquals(actualBookTitle, "Selenium Ruby");
		}else if(imgEle.getAttribute("title").equalsIgnoreCase("Thinking in HTML"))
		{
			imgEle.click();
			String actualBookTitle=driver.findElement(By.tagName("h3")).getText();
			Assert.assertEquals(actualBookTitle, "Thinking in HTML");
		}else
		{
			imgEle.click();
			String actualBookTitle=driver.findElement(By.tagName("h3")).getText();
			Assert.assertEquals(actualBookTitle, "Mastering JavaScript");
		}
		driver.navigate().to("https://practice.automationtesting.in/");
	}
  }
  
  

  @AfterClass
  public void browserClose()
  {
	  driver.close();
  }

}
