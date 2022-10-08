package com.vyasa.automation.maventesting;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestNGAnnotations {
  @Test
  public void testMethod() 
  {
		System.out.println("TestMethod");
  }
  @BeforeSuite
  public void beforeSuite() 
  {
		System.out.println("BeforeSuitMethod");
  }

  @AfterSuite
  public void afterSuite()
  {
	  System.out.println("AfterSuitMethod");
  }
  @BeforeTest
  public void beforeTest() 
  {
		System.out.println("BeforeTestMethod");
  }

  @AfterTest
  public void afterTest()
  {
	  System.out.println("AfterTestMethod");
  }

 
  @BeforeMethod
  public void beforeMethod()
  {
	  System.out.println("BeforeMethod1");
  }

  @AfterMethod
  public void afterMethod() 
  {
	  System.out.println("AfterMethod1");
  }

  @BeforeClass
  public void beforeClass() 
  {
	  System.out.println("BeforeClassMethod");
  }

  @AfterClass
  public void afterClass()
  {
	  System.out.println("AfterClassMethod");
  }
  
  @BeforeGroups
  public void beforeGroups()
  {
	  System.out.println("BeforeGropusMethod");  
  }
  @AfterGroups
  public void afterGroups()
  {
	  System.out.println("AfterGropusMethod");
  }
  
  
  

}
