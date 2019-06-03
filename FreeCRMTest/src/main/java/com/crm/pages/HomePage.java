package com.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.base.TestBase;

public class HomePage extends TestBase{
    
	//PageFactory - OR
		@FindBy(xpath = "//*[@id=\"main-nav\"]/a[1]/span")
		WebElement HomeLink;
		
		@FindBy(xpath = "//*[@id=\"top-header-menu\"]/div[2]/div[2]/div/div[2]/a[4]/span")
		WebElement Logout;
		
		//Initialize Page WebElements
		public HomePage() {
			PageFactory.initElements(driver, this);
		}
		
		public Signuppage ValidateHomePage() {
			String title = HomeLink.getText();
			if(title.equals("Home")) {
				System.out.println("HomePage is displayed");
			}
			return new Signuppage();
		}
}
