package seleniumgrid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
/*
 * Run hub prior to testing.
 */
public class SeleniumGrid{
	@Test
	public void SeleniumGridTesting()
	{
		 String baseURL = "http://demo.guru99.com/test/guru99home/";
         String nodeURL = "http://localhost:4444/wd/hub";
         ChromeOptions options = new ChromeOptions();
         options.setCapability("browserName", "chrome");
         options.setCapability("platform", Platform.WINDOWS);
         try {
        	 RemoteWebDriver driver = new RemoteWebDriver(new URL(nodeURL), options);
        	 driver.get(baseURL);
		 } 
         catch (MalformedURLException e) {
        	 e.printStackTrace();
         }
	}
}