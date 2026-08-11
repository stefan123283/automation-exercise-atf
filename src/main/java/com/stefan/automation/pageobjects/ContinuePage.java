package com.stefan.automation.pageobjects;

import com.stefan.automation.managers.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContinuePage extends Page {

    public ContinuePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[.='Account Created!']")
    WebElement accountCreatedHeading;

    @FindBy(xpath = "//h2[.='Account Deleted!']")
    WebElement accountDeletedHeading;

    @FindBy(xpath = "//p[text()='Congratulations! Your order has been confirmed!']")
    WebElement orderPlacedSuccessfullyMessage;

    @FindBy(xpath = "//a[text()='Download Invoice']")
    WebElement downloadInvoiceButton;

    public void accountIsCreatedSuccessfully() {
        AssertManager.assertTrue(ExplicitWaitManager.checkIfElementIsVisible(accountCreatedHeading, "Account Created heading"), "Account created successfully");
        clickElement(continueButton, "[Continue] button");
        closePopUpAddIfPresent();
    }

    public void accountIsDeletedSuccessfully() {
        AssertManager.assertTrue(ExplicitWaitManager.checkIfElementIsVisible(accountDeletedHeading, "Account Deleted heading"), "Account deleted successfully");
    }

    public void orderPlacedSuccessfully() {
        AssertManager.assertTrue(ExplicitWaitManager.checkIfElementIsVisible(orderPlacedSuccessfullyMessage, "Order placed successfully message"), "Order is placed successfully");
    }

    public void userDownloadsTheInvoice() {
        Log.info("Downloading the invoice");
        ExtentReportManager.addTestStep("User downloads the invoice");
        clickElement(downloadInvoiceButton, "[Download Invoice] button");
        clickElement(continueButton, "[Continue] button");
        KeyboardManager.pressEnterOnOS();
    }

    public void invoiceIsDownloadedSuccessfully(String fileName) {
        AssertManager.assertTrue(FileManager.checkIfFileExists(fileName), "Invoice is downloaded successfully");
        FileManager.deleteFile(fileName);
    }

}
