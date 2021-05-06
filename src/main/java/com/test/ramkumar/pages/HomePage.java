package com.test.ramkumar.pages;

import com.test.ramkumar.testcontext.TestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends BaseStep {

    public HomePage(TestContext testContext) {
        super(testContext);
    }

    public WebElement externalSite(){
        return waitForElementPresent(By.xpath("//*[@data-test-id='redirection-button']"));
    }

    public WebElement tshirtTab() {
        return waitForElementPresent(By.xpath("(//a[@title='T-shirts'])[2]"));
    }

    public WebElement addToCart() {
        return waitForElementPresent(By.xpath("//*[text()='Add to cart']"));
    }

    public WebElement proceedToCheckout() {
        return waitForElementPresent(By.xpath("(//*[contains(text(),'Proceed to checkout')])[last()]"));
    }

    public WebElement agreeTermsAndCondition() {
        return waitForElementPresent(By.id("cgv"));
    }

    public WebElement payByCheck() {
        return waitForElementPresent(By.xpath("//a[@title='Pay by check.']"));
    }

    public WebElement confirmOrder() {
        return waitForElementPresent(By.xpath("//*[text()='I confirm my order']"));
    }

    public WebElement backToOrder() {
        return waitForElementPresent(By.xpath("//a[@title='Back to orders']"));
    }

    public List<WebElement> orders() {
        return findElements(By.xpath("//*[@class='color-myaccount']"));
    }

}
