package BasePackage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

import com.microsoft.playwright.Page;

import UtilPackage.CommonUtils;

public class BaseClass {

	public Page page;
	
	@BeforeTest
	public void setup() throws InterruptedException
	{
		CommonUtils.readPropertiesFile();
		CommonUtils.startBrowser();
	}
	@AfterMethod
    public void teardown() {
       // page.close();
    }
}
