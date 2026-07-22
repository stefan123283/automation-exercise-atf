package com.stefan.automation.pageobjects;

import com.stefan.automation.managers.AssertManager;
import com.stefan.automation.managers.ExplicitWaitManager;
import com.stefan.automation.managers.ExtentReportManager;
import com.stefan.automation.managers.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends Page {

    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "name")
    WebElement nameTextBox;

    @FindBy(name = "email")
    WebElement emailTextBox;

    @FindBy(name = "subject")
    WebElement subjectTextBox;

    @FindBy(name = "message")
    WebElement messageTextBox;

    @FindBy(name = "submit")
    WebElement submitButton;

    @FindBy(xpath = "//div[text()='Success! Your details have been submitted successfully.']")
    WebElement successMessage;

    @FindBy(xpath = "//span[contains(text(), 'Home')]")
    WebElement homeButton;

    public void userCompletesContactUsForm(String name, String email, String subject, String message) {
        Log.info("Completing contact us form");
        ExtentReportManager.addTestStep("User completes contact us form");
        sendKeysToElement(nameTextBox, "Name text box", name);
        sendKeysToElement(emailTextBox, "Email text box", email);
        sendKeysToElement(subjectTextBox, "Subject text box", subject);
        sendKeysToElement(messageTextBox, "Message text box", message);
        clickElement(submitButton, "[Submit] button");
        acceptAlert();
    }

    public void contactUsFormIsSubmittedSuccessfully() {
        AssertManager.assertTrue(ExplicitWaitManager.checkIfElementIsVisible(successMessage, "Contact us success message"), "Contact us form was submitted successfully");
    }

    public void userNavigatesToHomePage() {
        Log.info("Navigating to Home page");
        ExtentReportManager.addTestStep("User navigates to Home page");
        clickElement(homeButton, "[<< Home] button");
        closePopUpAddIfPresent();
    }
}
