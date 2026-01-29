package UtilPackage;

import org.testng.Assert;

public class TestNGUtils {

	//This method checks if the actual string contains the expected string 
		public static void assertTrue(String actual, String expected) 
		{
			if(actual.contains(expected)) 
			{
				Assert.assertTrue(actual.contains(expected));
			}
			else {
				Assert.fail(expected + "not present in" + actual);
			}
		}
		
		//Explicitly fail a test with a message
		
		public static void assertFail(String logMessage) {
			Assert.fail(logMessage);
		}
		
		//This method checks if expected and actual integers are equal
		
		public static void assertEquals(int expected , int actual)
		{
			if(actual == expected) 
			{
				Assert.assertEquals(actual, expected);
			}else
			{
				Assert.fail(expected + "is not matched with" + expected);
			}
		}
	
}
