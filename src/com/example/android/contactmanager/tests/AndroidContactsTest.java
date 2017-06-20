package com.example.android.contactmanager.tests;

import org.testng.annotations.Test;

import com.example.android.contactmanager.pages.AddContactScreen;
import com.example.android.contactmanager.pages.MainScreen;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;

public class AndroidContactsTest extends WebDriverTestCase {

	@Test
	public void addContact() {
		MainScreen mainScreen = new MainScreen();
		mainScreen.waitForPageToLoad();
		mainScreen.getBtnAddContact().waitForPresent();
		mainScreen.getBtnAddContact().click();
		AddContactScreen addContactScreen = new AddContactScreen();
		addContactScreen.waitForPageToLoad();
		addContactScreen.getEditTextFname().waitForPresent();
		addContactScreen.getEditTextFname().sendKeys("Some Name");
		addContactScreen.getEditTextEmail().sendKeys("Some@example.com");
		addContactScreen.getBtnSave().click();
	}

}