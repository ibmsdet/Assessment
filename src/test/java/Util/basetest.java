package Util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class basetest 

{

		public static WebDriver driver;
		@Before
		public void webBroswer()
		{
		//System.setProperty("webdriver.chrome.driver","C://Users//padmasriS//Documents//SDET//chromedriver.exe");
	     driver= new ChromeDriver();
	      System.out.println("Broswer is opened");
		 }
		//@After
	    public void webBroswerclose()
		{
	    	   driver.quit();
	    	   System.out.println("Broswer is Closed");
	    }
}
	
