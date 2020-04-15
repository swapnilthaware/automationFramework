package com.guru.qa.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory 
{
	
	public static WebDriver selectbrowser(WebDriver driver,String browser,String URL)
	{
		if(browser.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(browser.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver", "./Drivers/IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		else
		{
			System.out.println("We do not support this browser");
		}
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(URL);
		
		return driver;
	}
	
	
	public static void closebrowser(WebDriver driver)
	{
		driver.quit();
	}

}
