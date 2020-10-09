package saucelabs;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
/*
 * Get a new sauce lab account prior to testing.
 */
public class saucelabs {

  private WebDriver driver;

  @Test
  public void shouldOpenSauceLab() throws MalformedURLException {
	ChromeOptions options = new ChromeOptions();
	options.setCapability(CapabilityType.PLATFORM_NAME, Platform.WIN8_1);
    driver = new RemoteWebDriver(new URL("https://ArundeepC:791b4aa3-d2b3-4546-9cfc-60bc312cf3f9@ondemand.saucelabs.com:443/wd/hub"), options);
    driver.navigate().to("https://www.saucedemo.com");
    Assert.assertTrue(true);
  }
}

