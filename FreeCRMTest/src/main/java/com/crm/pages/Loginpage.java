package com.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.base.TestBase;

public class Loginpage extends TestBase{
	
	//PageFactory - OR
	@FindBy(xpath = "/html/body/div[1]/header/div/nav/div[2]/div/div[3]/ul/a")
	WebElement Loginlink;
	
	@FindBy(name = "email")
	WebElement UserName;
	
	@FindBy(name = "password")
	WebElement Password;
	
	@FindBy(xpath = "//*[@id=\"ui\"]/div/div/form/div/div[3]")
	WebElement LoginButton;
	
	//Initialize Page WebElements
	public Loginpage() {
		PageFactory.initElements(driver, this);
	}
	
	public String ValidateLoginPagetitle() {
		return driver.getTitle();
	}
	
	public HomePage ValidateLogin(String UN,String PWD) {
		Loginlink.click();
		UserName.sendKeys(UN);
		Password.sendKeys(PWD);
		LoginButton.click();
		return new HomePage();
	}

}
