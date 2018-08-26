package com.chinna.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import cucumber.api.java.After;

public class TestBase {

	public static WebDriver driver = null;

	public void openBrowser(String browser) throws Exception {

		if (browser.equalsIgnoreCase("FF")) {
			System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("IE")) {
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			System.setProperty("webdriver.ie.driver", "drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver(capabilities);
		} else if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
			DesiredCapabilities capability = DesiredCapabilities.chrome();
			capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			driver = new ChromeDriver(capability);
		} else if (browser.equalsIgnoreCase("Safari")) {
			DesiredCapabilities desiredCapabilities = DesiredCapabilities.safari();
			SafariOptions safariOptions = new SafariOptions();
			safariOptions.setUseCleanSession(true);
			desiredCapabilities.setCapability(SafariOptions.CAPABILITY, safariOptions);
			driver = new SafariDriver(desiredCapabilities);
		}
		driver.get("https://cca.golo02.dominos.com/order-entry/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	public void waitForPageLoad(WebDriver driver) {
		try {
			for (int i = 0; i < 90; i++) {

				JavascriptExecutor js = (JavascriptExecutor) driver;
				// check for the pending request count and break if count is
				// zero.
				if (js.executeScript("return document.readyState").equals("complete")) {

					break;
				}
				Thread.sleep(1000);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		// waitForAjax(driver);
	}
	
	// Closing the browser
	public  void closeBrowser() {
		if (driver != null) {
			driver.quit();
		}
	}
	
	

}
