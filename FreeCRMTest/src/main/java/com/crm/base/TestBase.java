package com.crm.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		prop = new Properties();
		try {
			FileInputStream fp = new FileInputStream("D:\\Selenium\\Selenium_Test\\FreeCRMTest\\src\\main\\java\\com\\crm\\config\\config.properties");
			prop.load(fp);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void Initilization() {
		String browser=prop.getProperty("Browser");
		if(browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32 (1)\\chromedriver.exe");
			driver =new ChromeDriver();
		}else if (browser.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\geckodriver-v0.24.0-win64\\geckodriver.exe");
			driver =new FirefoxDriver();
		} 
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_load_Timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_Timeout, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("URL"));
	}
	
}
