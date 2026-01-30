package TestPackage;

import org.testng.annotations.Test;

import BasePackage.BaseClass;
import PagesPackage.LoginPage;
import PagesPackage.PimPage;
import UtilPackage.CommonUtils;
import UtilPackage.TestNGUtils;

public class TestPIMPage extends BaseClass 
{
	//This is reference from another class
	LoginPage loginpage = new LoginPage();
	PimPage pimpage = new PimPage();
	
	@Test
	public void addEmpThenVerify()
	{
		//initialize here
		
		// CommunUtils.loginWithMultipleRecordsUsingExcel("MultipleLoginFunctionality");
		
		//Login 
		loginpage.login();
		
		//CommonUtils.hardWait(3);
		
		//Validate Welcome Page
		
		TestNGUtils.assertTrue(CommonUtils.getElementText(loginpage.getWelcomepage()), "Welcome Admin");
	}
}