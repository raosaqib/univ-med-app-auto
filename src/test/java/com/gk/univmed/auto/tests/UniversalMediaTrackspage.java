package com.gk.univmed.auto.tests;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class UniversalMediaTrackspage {

		static AppiumDriver driver;//we can use AndroidDriver as well but AppiumDriver will work for both-ios/Android
		 public static void main(String[] args) throws Exception {
			 swagApp();
		}
		
		public static void swagApp() throws Exception {
			// TODO Auto-generated method stub
			DesiredCapabilities dc= new DesiredCapabilities();
			dc.setCapability("deviceName","Appium"); //for Android device name can be given any,but for IOS it must be correct
			dc.setCapability("udid", "7e5241e"); 
			//dc.setCapability("udid","192.168.100.70:5555");//
			
			//dc.setCapability("bundleId", "7e5241e"); it will be used for .app(IOS)	
			
			 dc.setCapability("platformName","Android");  //dc.setCapability("platformName","IOS");
			
			 dc.setCapability("platformVersion", "10");
			//dc.setCapability("app","C:/appium/Android.SauceLabs.Mobile.Sample.app.2.3.0.apk");
			dc.setCapability("automationName","UIAutomator2");// Appium server will identify//for IOS("automationName","XCUITest");
			
			dc.setCapability("appPackage", "com.swaglabsmobileapp");//unique id for every andriod application
			//dc.setCapability("avd","NameOfTheVirtualdevice");// it's for virtual device,if we want appium to lauch the virtual device automatically
			dc.setCapability("appActivity","com.swaglabsmobileapp.SplashActivity");//the activity which ran first time during application installation
			
			URL url= new URL("http://localhost:4723/wd/hub");
			driver= new AndroidDriver(url,dc); 
			//driver=new IOSDriver(url, dc);
			//driver=new AppiumDriver<MobileElement>(url,dc);
			String sessionid=driver.getSessionId().toString();
			System.out.println(sessionid);
			Thread.sleep(10000);
			MobileElement userNametxfiels=(MobileElement) driver.findElementByAccessibilityId("test-Username");
			Thread.sleep(10000);
			MobileElement userPwdtxfiels=(MobileElement) driver.findElementByAccessibilityId("test-Password");
			Thread.sleep(10000);
			MobileElement clickonlogin=(MobileElement) driver.findElementByAccessibilityId("test-LOGIN");
			
			MobileElement errmessage=(MobileElement) driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]/android.widget.TextView");
			Thread.sleep(10000);
			userNametxfiels.sendKeys("standard_user");
			userPwdtxfiels.sendKeys("secret_sauce");
			clickonlogin.click();
			

}
}