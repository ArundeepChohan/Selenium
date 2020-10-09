package org.com.learningMavenCommand;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HelloWorldTest {
	@Test
	public void Login() {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", ".\\BrowserDrivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String baseurl = "https://www.google.com/";
	    driver.get(baseurl);
	    driver.manage().window().maximize();
	    System.out.println(driver.getCurrentUrl());
	    driver.quit();

	}

}
