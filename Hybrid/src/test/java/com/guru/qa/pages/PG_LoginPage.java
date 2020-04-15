package com.guru.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PG_LoginPage 
{
WebDriver driver;
	
	public PG_LoginPage(WebDriver ldriver)
	{
		this.driver=ldriver;
		
	}
	
	@FindBy(id="username") WebElement txtusername;
	@FindBy(id="password") WebElement txtpassword;
	@FindBy(xpath="//span[@class='button']") WebElement LoginButton;
	
	
	public void loginBP_Travel(String uname,String pwd)
	{
		txtusername.sendKeys(uname);
	    txtpassword.sendKeys(pwd);
		LoginButton.click();
	}


}
