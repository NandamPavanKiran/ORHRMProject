package UtilPackage;

import java.io.FileInputStream;
import java.util.Properties;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class CommonUtils {

	
	public static Properties config;
	public static FileInputStream fis;
	public static Playwright playwright;
	public static Page page;
	public static Browser browser;
	
	
	
	
	public static void readPropertiesFile()
	{
		try 
		{
			//Access the config.properties file into working environment
			FileInputStream fis =new FileInputStream("C:\\Users\\LENOVO\\eclipse-workspace\\com.HR.HrProject\\src\\test\\resourcess\\config.properties");
			
			//Create a memory space for the config.properties file
			config = new Properties();
			
			//Store config.properties file in an memory Space
			config.load(fis);
		}catch(Exception e) {

			TestNGUtils.assertFail(e.getMessage());
		}
	}
	
	
	
	//--------------------BROWSER------------------------------------
	
	
	public static void startBrowser() throws InterruptedException 
	{
		String browserName = config.getProperty("browser");//firefox
		
		switch(browserName.toUpperCase())
		
		{
		case "CHROME":
			playwright = Playwright.create();
			browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;
			

		case "FIREFOX":
			playwright = Playwright.create();
			browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;
			

		case "EDGE":
			playwright = Playwright.create();
			browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;
			
			default: 
				TestNGUtils.assertFail("Invalid Browser Name");
		}
		
		page = browser.newPage();
		
		page.navigate(config.getProperty("url"));
		//page.navigate("http://127.0.0.1/orangehrm-2.5.0.2/login.php");
	}
	
	
	
	//-----------------------------Basic Actions ----------------------------
	
	public static Locator findElement(String selector) 
	{
		Locator element = null;
		try {
			element = page.locator(selector);
		}catch(Exception e) {
			TestNGUtils.assertFail(e.getMessage());
		}
		return element; 
	}
	
	
	public static void enterValue(String selector, String value) 
	{
		try 
		{
			findElement(selector).clear();
			findElement(selector).fill(value);
		}catch(Exception e) 
		{
			TestNGUtils.assertFail(e.getMessage());
		}
	}
	
	
	public static void clickElement( String selector) 
	{
		try {
			findElement(selector).click();;
		}catch(Exception e) {
			TestNGUtils.assertFail(e.getMessage());
		}
	} 
	
	
	public static String getElementText(String selector)
	{
		String text = null;
		try 
		{
			text = findElement(selector).textContent();
		}catch(Exception e)
		{
			TestNGUtils.assertFail(e.getMessage());
		}
		return text;
	}
}
