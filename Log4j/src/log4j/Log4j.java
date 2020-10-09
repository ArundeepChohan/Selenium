package log4j;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Log4j {

	Logger logger;
	@Test
	public void Test4j() {
		logger = Logger.getLogger("devpinoyLogger");
		logger.debug("Starting of Selenium Tests");
		System.setProperty("webdriver.chrome.driver", "C:\\BrowserDrivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		logger.debug("Opens Chromedriver");
		driver.get("http:\\google.com");
		logger.debug("Navigates to page");
	}

}
