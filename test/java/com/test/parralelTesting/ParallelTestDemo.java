package com.test.parralelTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ParallelTestDemo {

	public WebDriver driver;
	
    @Test
    public void ChromeTest() throws InterruptedException
	{ 
  //Initializing chrome driver
  driver = new ChromeDriver();
  driver.get("https://letcode.in/"); 
  Thread.sleep(5000);
  driver.findElement(By.xpath("//a[normalize-space()='Log in']")).click();
  Thread.sleep(5000);
  //driver.quit();
	}
    
    @Test
    public void ChromeTest1() throws InterruptedException
	{ 
  //Initializing chrome driver
  driver = new ChromeDriver();
  driver.get("https://letcode.in/"); 
  Thread.sleep(5000);
  driver.findElement(By.xpath("//a[normalize-space()='Log in']")).click();
  Thread.sleep(5000);
  //driver.quit();
	}
/*    public void FirefoxTest() throws InterruptedException {	 
        //Initializing firefox driver (Gecko)
    	
    	//FirefoxOptions options = new FirefoxOptions();
    	//options.setBinary("C:\\Users\\MX\\.m2\\repository\\org\\seleniumhq\\selenium\\selenium-firefox-driver\\4.9.0\\selenium-firefox-driver-4.9.0.exe");
    	driver = new FirefoxDriver();
    		  
    driver.get("https://letcode.in/"); 
    Thread.sleep(10000);
    driver.findElement(By.xpath("//a[normalize-space()='Log in']")).click();
    Thread.sleep(10000);
   // driver.quit();
     }*/

}
