package com.gk.univmed.auto.pages;

import com.gk.univmed.auto.base.AppiumBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;

public class UniversalMediaPlayerLandingpage extends AppiumBase {
	boolean status;
	@AndroidFindBy(accessibility = "Open the main menu")
	private MobileElement landPage;
	@Step("user should navigate to home page")
	public boolean userTapsOnHomePage() {
		status = super.click(landPage, "press login button");
		return status;
	}
	@Step("validate landing page text")
	public String getlandingPageText() {
		MobileElement landingPageText = (MobileElement) driver.findElementById("com.instantappsample.uamp:id/toolbar");
		String txt = landingPageText.getText();
		return txt;
	}
}
