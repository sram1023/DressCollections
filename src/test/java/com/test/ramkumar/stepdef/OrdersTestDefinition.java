package com.test.ramkumar.stepdef;

import com.test.ramkumar.pages.HomePage;
import com.test.ramkumar.pages.SignInPage;
import com.test.ramkumar.testcontext.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class OrdersTestDefinition {

    private static final String URL = "http://automationpractice.com/";
    TestContext testContext;
    HomePage homePage;
    SignInPage signInPage;


    public OrdersTestDefinition(TestContext testContext) {
        this.testContext = testContext;
    }

    @Given("I am on homepage")
    public void iAmOnHomepage() {
        testContext.getDriver().get(URL);
        homePage = new HomePage(testContext);
        signInPage = new SignInPage(testContext);
    }

    @When("I order a T-Shirt")
    public void iOrderATshirt() {
        homePage.tshirtTab().click();
        homePage.addToCart().click();
        for(int i = 1; i <= 3;i++){
            homePage.proceedToCheckout().click();
        }
        homePage.agreeTermsAndCondition().click();
        homePage.proceedToCheckout().click();
        homePage.payByCheck().click();
        homePage.confirmOrder().click();
        homePage.backToOrder().click();
    }

    @Then("I should see my order in order history")
    public void iShouldSeeMyOrderInOrderHistory() {
        Assert.assertTrue(homePage.orders().size() > 0);
    }

    @When("I sign in")
    public void iSignIn() {
        signInPage.signInLink().click();
        signInPage.username().sendKeys("testing321@gmail.com");
        signInPage.password().sendKeys("themoon");
        signInPage.signIn().click();
    }

    @And("I update my personal information")
    public void iUpdateMyPersonalInformation() {
        signInPage.personalInfo().click();
        signInPage.personalInfoTab().click();
        signInPage.firstName().clear();
        signInPage.firstName().sendKeys("testuser");
        signInPage.currentPassword().sendKeys("themoon");
        signInPage.newPassword().sendKeys("themoon123");
        signInPage.confirmPassword().sendKeys("themoon123");
        signInPage.save().click();
    }

    @Then("my personal information is saved")
    public void myPersonalInformationIsSaved() throws InterruptedException {
        System.out.println("+=+++++++++++++" + signInPage.personalInfo().getText());
        for (int i = 0; i < 5; i++) {
            if (signInPage.personalInfo().getText().contains("Changed")) {
                Assert.assertTrue(true);
            } else {
                Thread.sleep(1000);
            }
        }
        Assert.assertTrue(signInPage.personalInfo().getText().contains("Changed"));
    }

    @After
    public void closeDriver() {
        testContext.getDriver().quit();
    }
}

