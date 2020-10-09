package com.gk.univmed.auto.base;

import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AppiumBase {
	protected static AppiumDriver driver;
	protected static Properties props;
	InputStream inputStream;
	boolean status;
	public static final long WAIT = 50;

	public AppiumBase() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	@Parameters({ "platformName", "platformVersion", "deviceName","udid" })
	@BeforeTest()
	public void beforeTest(@Optional("Appium") String deviceName, @Optional("Android") String platformName,
			@Optional("10") String platformVersion,@Optional("7e5241e")String udid) {

		{
			try {
				props = new Properties();
				String propFilename = "config.properties";
				inputStream = getClass().getClassLoader().getResourceAsStream(propFilename);
				props.load(inputStream);
				DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
				desiredCapabilities.setCapability("platformName", platformName);
				desiredCapabilities.setCapability("platformVersion", platformVersion);
				desiredCapabilities.setCapability("deviceName", deviceName);
				desiredCapabilities.setCapability("udid", udid);
				desiredCapabilities.setCapability("automationName", props.getProperty("androidAutomationName"));
				desiredCapabilities.setCapability("appPackage", props.getProperty("androidAppPackage"));
				desiredCapabilities.setCapability("appActivity", props.getProperty("androidAppActivity"));
				URL appurl = getClass().getClassLoader().getResource(props.getProperty("androidAppLocation"));

				// Install direct from git.
				desiredCapabilities.setCapability("app", props.getProperty("appInstallationfromGitRepo"));
				URL url = new URL(props.getProperty("appiumURL"));
				driver = new AndroidDriver(url, desiredCapabilities);
				String sessionid = driver.getSessionId().toString();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void waitForVisibility(MobileElement e) {
		WebDriverWait wait = new WebDriverWait(driver, WAIT);
		wait.until(ExpectedConditions.visibilityOf(e));
	}

	public boolean click(MobileElement e, String msg) {
		try {
			waitForVisibility(e);
			e.click();
			return true;
		} catch (Throwable t) {
			t.getStackTrace();
			return false;
		}
	}
	public void click(MobileElement e) {
		waitForVisibility(e);
		e.click();
	}

	public String getAttribute(MobileElement e, String attribute) {
		waitForVisibility(e);
		return e.getAttribute(attribute);
	}

	@AfterTest()
	public void afterTest()

	{
		driver.quit();

	}
}
