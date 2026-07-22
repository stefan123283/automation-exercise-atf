package com.stefan.automation.pageobjects;

import com.stefan.automation.managers.AssertManager;
import com.stefan.automation.managers.ExplicitWaitManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TestCasesPage extends Page {

    public TestCasesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Below is the list of test Cases for you to practice the Automation. Click on the scenario for detailed Test Steps:']")
    WebElement descriptionParagraph;

    public void testCasesPageIsVisible(){
        AssertManager.assertTrue(ExplicitWaitManager.checkIfElementIsVisible(descriptionParagraph, "Description paragraph"), "Test Cases page is visible");
    }

}
