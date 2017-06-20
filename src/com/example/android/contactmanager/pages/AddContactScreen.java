package com.example.android.contactmanager.pages;

import com.example.android.contactmanager.beans.ContactBean;
import com.qmetry.qaf.automation.core.QAFTestBase;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class AddContactScreen extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "first name text box")
	private QAFWebElement editTextFname;
	@FindBy(locator = "email-address text box")
	private QAFWebElement editTextEmail;
	@FindBy(locator = "save button")
	private QAFWebElement btnSave;
	@FindBy(locator = "phone number text box")
	private QAFWebElement editTextPhone;

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}
	@Override
	public void waitForPageToLoad() {
		QAFTestBase.pause(4000);
	}
	public QAFWebElement getEditTextFname() {
		return editTextFname;
	}

	public QAFWebElement getEditTextEmail() {
		return editTextEmail;
	}

	public QAFWebElement getEditTextPhone() {
		return editTextPhone;
	}
	public QAFWebElement getBtnSave() {
		return btnSave;
	}

	@QAFTestStep(stepName = "openAddContactScreen", description = "open add contact screen")
	public void launchPage() {
		MainScreen mainScreen = new MainScreen();
		mainScreen.waitForPageToLoad();
		mainScreen.getBtnAddContact().waitForPresent();
		mainScreen.getBtnAddContact().click();
		AddContactScreen addContactScreen = new AddContactScreen();
		addContactScreen.waitForPageToLoad();
	}

	@QAFTestStep(stepName = "fillContactDetailsForm", description = "fill contact details form with {0}")
	public void fillContactDetailsForm(ContactBean bean) {
		waitForPageToLoad();
		getEditTextFname().sendKeys(bean.getName());
		getEditTextPhone().sendKeys(bean.getPhone());
		getEditTextEmail().sendKeys(bean.getEmail());
	}

}
