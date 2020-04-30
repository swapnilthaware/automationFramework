package com.guru.qa.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.guru.qa.pages.BaseClass;
import com.guru.qa.pages.PG_LoginPage;



public class TC_LoginTest extends BaseClass
{

	
	@Test
	public void loginappl()
	{
		logger=report.createTest("Login to BP_Travel");
		
		PG_LoginPage lp=PageFactory.initElements(driver, PG_LoginPage.class);
		logger.info("Starting Application");
		
		//UserName and Password are captured from Excel in TestData folder
		lp.loginBP_Travel(excel.getStringData("Login", 0, 0),excel.getStringData("Login", 0, 1));
		logger.pass("Login done successfully");
	}
	
}
