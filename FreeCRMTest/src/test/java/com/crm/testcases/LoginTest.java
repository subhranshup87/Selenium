package com.crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.base.TestBase;
import com.crm.pages.HomePage;
import com.crm.pages.Loginpage;

public class LoginTest extends TestBase{
	Loginpage loginpage;
	HomePage homepage;
	
	public LoginTest() {
		super();
	}
	@BeforeMethod
	public void SetUp() {
		Initilization();
		loginpage = new Loginpage();
	}
	
	@Test(priority = 1)
	public void ValidateTitle() {
		String title = loginpage.ValidateLoginPagetitle();
		Assert.assertEquals(title, "#1 Free CRM software in the Cloud FreeCRM");
	}
	
	@Test(priority = 2)
	public void validatelogin(){
	    homepage = loginpage.ValidateLogin(prop.getProperty("UserID"), prop.getProperty("Password"));	
	}
	
	@AfterMethod
	public void quit() {
		driver.quit();
	}

}
