package com.example.android.contactmanager.steps;

import io.appium.java_client.AppiumDriver;

import org.hamcrest.Matchers;
import org.openqa.selenium.By;

import com.example.android.contactmanager.beans.ContactBean;
import com.example.android.contactmanager.pages.MainScreen;
import com.qmetry.qaf.automation.core.QAFTestBase;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.util.Validator;

public class StepsLibrary extends WebDriverTestCase {

	@QAFTestStep(stepName = "launchApplication", description = "user opens contact manager")
	public void launchApplication() {
	}

	@QAFTestStep(stepName = "generateRandomContactData", description = "generate random contact data")
	public ContactBean generateRandomContactData() {
		ContactBean bean = new ContactBean();
		bean.fillRandomData();
		return bean;
	}

	@QAFTestStep(stepName = "verifyContactFromBean", description = "verify contact {0} is displayed in list")
	public void verifyContactFromBean(ContactBean bean) {
		verifyContact(bean.getName());
	}

	@QAFTestStep(stepName = "verifyContact", description = "verify contact with name {0} is displayed in list")
	public void verifyContact(String name) {
		Validator.verifyThat("Contact with name : " + name
				+ " should be displayed", isContactPresent(name),
				Matchers.equalTo(true));
	}

	public boolean isContactPresent(String name) {
		MainScreen mainScreen = new MainScreen();
		mainScreen.waitForPageToLoad();

		AppiumDriver appiumDriver = (AppiumDriver) getDriver()
				.getUnderLayingDriver();
		// appiumDriver.scrollTo(name);
		int numberContactsDisplayed = getDriver()
				.findElements(
						By.xpath("//android.widget.ListView//android.widget.LinearLayout"))
				.size();
		System.out.println("Total Contacts : " + numberContactsDisplayed);
		int total_scrolls_required = numberContactsDisplayed / 10 + 15;// 50
		numberContactsDisplayed = numberContactsDisplayed > 10 ? 10
				: numberContactsDisplayed;

		QAFExtendedWebElement startEle = getDriver()
				.findElement(
						By.xpath(String
								.format("//android.widget.LinearLayout[%d]/android.widget.TextView[1]",
										numberContactsDisplayed)));
		QAFExtendedWebElement endEle = getDriver()
				.findElement(
						By.xpath("//android.widget.LinearLayout[1]/android.widget.TextView[1]"));
		boolean contactFound = false;
		for (int i = 0; i < total_scrolls_required && !contactFound; i++) {
			QAFTestBase.pause(300);
			if (!new QAFExtendedWebElement(
					"xpath=//android.widget.TextView[contains(@text,'" + name
							+ "')]").isPresent()) {
				// getDriver().getTouchScreen().flick(startEle.getCoordinates(),
				// startEle.getCoordinates().onPage().getX(), -400, 35);

				appiumDriver.swipe(startEle.getCoordinates().onPage().getX(),
						startEle.getCoordinates().onPage().getY(), endEle
								.getCoordinates().onPage().getX(), endEle
								.getCoordinates().onPage().getY(), 700);
			} else {
				contactFound = true;
				break;
			}
		}
		return contactFound;
	}
}
