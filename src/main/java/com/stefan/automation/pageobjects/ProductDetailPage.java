package com.stefan.automation.pageobjects;

import com.stefan.automation.managers.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailPage extends Page {

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='product-information']")
    WebElement productInformationSection;

    @FindBy(id = "quantity")
    WebElement productQuantityTextBox;

    @FindBy(xpath = "//button[contains(.,'Add to cart')]")
    WebElement addToCartButton;

    @FindBy(id = "name")
    WebElement nameTextBox;

    @FindBy(id = "email")
    WebElement emailTextBox;

    @FindBy(id = "review")
    WebElement reviewTextBox;

    @FindBy(id = "button-review")
    WebElement submitReviewButton;

    @FindBy(xpath = "//span[text()='Thank you for your review.']")
    WebElement submitSuccessMessage;

    public void productDetailPageIsVisible() {
        AssertManager.assertTrue(ExplicitWaitManager.checkIfElementIsVisible(productInformationSection, "Product information section"), "Product detail page is visible");
    }

    public void userIncreasesProductQuantityToFour() {
        Log.info("User increases product quantity to four");
        ExtentReportManager.addTestStep("User increases product quantity to four");
        KeyboardManager.enterValueIntoElement(productQuantityTextBox, "Product quantity text box", "4");
    }

    public void userClicksAddToCartButton() {
        Log.info("User clicks [Add to cart] button");
        ExtentReportManager.addTestStep("User clicks [Add to cart] button");
        clickElement(addToCartButton, "[Add to cart] button");
    }

    public void userSubmitsProductReview(String name, String email, String review) {
        Log.info("Submitting product review");
        ExtentReportManager.addTestStep("User submits product review");
        KeyboardManager.enterValueIntoElement(nameTextBox, "Name text box", name);
        KeyboardManager.enterValueIntoElement(emailTextBox, "Email text box", email);
        KeyboardManager.enterValueIntoElement(reviewTextBox, "Review text box", review);
        clickElement(submitReviewButton, "[Submit] button");
    }

    public void reviewIsSubmittedSuccessfully() {
        AssertManager.assertTrue(ExplicitWaitManager.checkIfElementIsVisible(submitSuccessMessage, "Submit review success message"), "The review is submitted successfully");
    }
}
