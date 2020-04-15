package com.guru.qa.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.guru.qa.utilities.BrowserFactory;
import com.guru.qa.utilities.ConfigDataProvider;
import com.guru.qa.utilities.ExcelDataProvider;
import com.guru.qa.utilities.Helper;



public class BaseClass 
{
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	
	
	@BeforeSuite
	public void Exceldatasetup()
	{
		Reporter.log("Setting up reports and Test started", true);
		
		excel=new ExcelDataProvider();
		config=new ConfigDataProvider();
		
		ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/BP_Travel"+Helper.getCurrentDateTime()+".html"));
		report=new ExtentReports();
		report.attachReporter(extent);
		
		Reporter.log("Setting done Test can be started", true);
	}
	
	@BeforeClass
	public void setup()
	{
		Reporter.log("Trying to start Browser", true);
		
		driver=BrowserFactory.selectbrowser(driver,config.getBrowser(), config.getStagingUrl());
		
		Reporter.log("Browser and Apllication is up and running..", true);
	}
	

	@AfterClass
	public void teardown()
	{
		
		BrowserFactory.closebrowser(driver);
	}
	
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException
	{
		Reporter.log("Test about to end and reports are getting generated", true);
		
		if(result.getStatus()==ITestResult.FAILURE)
		{		
			logger.fail("Test Failed ", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass("Test Passed ", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		report.flush();
		
		Reporter.log("Test Completed and Reports are generated>>>>>", true);
	}

}







