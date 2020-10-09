package com.gk.univmed.auto.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.gk.univmed.auto.base.AppiumBase;
import com.gk.univmed.auto.pages.UniversalMediaPlayerLandingpage;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class UniversalMediaLandingPageTest extends AppiumBase {
	UniversalMediaPlayerLandingpage umtp;
	boolean actualResult;

	@BeforeMethod()
	public void beforeMethod() {
		umtp = new UniversalMediaPlayerLandingpage();
	}

	@Test(description = "Validate user is able to click on the Menu")
	@Severity(SeverityLevel.CRITICAL)
	public void clickOnHomeMenu() {
		umtp = new UniversalMediaPlayerLandingpage();
		actualResult = umtp.userTapsOnHomePage();
		Assert.assertEquals(actualResult, true);

	}

	@Test(description = "validate text of the landing page negative test to fail & record in report")
	@Severity(SeverityLevel.NORMAL)
	public void validateUserisAbleTolandedOnTheCorectApp() {
		String actualtext = umtp.getlandingPageText();
		Assert.assertEquals(actualtext, "Universal Music Player");
	}
}
