package PagesPackage;

import UtilPackage.CommonUtils;
import UtilPackage.TestNGUtils;

public class LoginPage {

private String by_username = "input[name=txtUserName]";
	
	
	
	
	private String by_passwrod ="input[name=txtPassword]";
	
	
	
	private String by_login = "input[name=Submit]";
	
	
	
	
	private String by_welcomepage = "xpath=/html/body/div[3]/ul/li[1]";

	
	
	public void login() 
	{
		try 
		{
			CommonUtils.enterValue(getUsername(), "Admin");
			CommonUtils.enterValue(getPassword(), "Admin");
			CommonUtils.clickElement(getLogin());
			CommonUtils.getElementText(getWelcomepage());
		}catch(Exception e) 
		{
			TestNGUtils.assertFail(e.getMessage());
		}
	}
	
	
	
	public String getUsername() 
	{
		return by_username;
	}
	
	public String getPassword() 
	{
		return by_passwrod;
	}
	
	public String getLogin() 
	{
		return by_login;
	}
	
	public String getWelcomepage() 
	{
		return by_welcomepage;
	}
	
}
