package com.crm.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.base.TestBase;
import com.crm.pages.HomePage;
import com.crm.pages.Loginpage;
import com.crm.pages.Signuppage;

public class HomePageTest extends TestBase {
	   Loginpage loginpage;
       HomePage homepage;
       Signuppage signuppage;
       
       public HomePageTest() {
    	   super();
       }
       
       @BeforeMethod
   		public void SetUp() {
   		Initilization();
   		loginpage = new Loginpage();
   		homepage = loginpage.ValidateLogin(prop.getProperty("UserID"), prop.getProperty("Password"));
       }
   		@Test
   		public void ValidateCRMHomepage(){
   			signuppage = homepage.ValidateHomePage();
   		}
   		
   		@AfterMethod
   		public void quit() {
   			driver.quit();
   		}
  }
       

