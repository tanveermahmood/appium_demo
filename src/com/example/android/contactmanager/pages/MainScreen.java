package com.example.android.contactmanager.pages;

import com.qmetry.qaf.automation.core.QAFTestBase;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class MainScreen extends WebDriverBaseTestPage<WebDriverTestPage> {
	@FindBy(locator = "add.contact.button")
	private QAFWebElement btnAddContact;

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	@Override
	public void waitForPageToLoad() {
		super.waitForPageToLoad();
		QAFTestBase.pause(3000);
	}

	public QAFWebElement getBtnAddContact() {
		return btnAddContact;
	}

}
