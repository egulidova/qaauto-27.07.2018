package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.*;

public class LinkedinResetPasswordTest {
    WebDriver browser;
    LinkedinLoginPage linkedinLoginPage;
    LinkedinRequestPasswordResetPage linkedinRequestPasswordResetPage;
    LinkedinPasswordResetSubmitPage linkedinPasswordResetSubmitPage;
    LinkedinSetNewPasswordPage linkedinSetNewPasswordPage;
    LinkedinConfirmNewPasswordPage linkedinConfirmNewPasswordPage;
    LinkedinHomePage linkedinHomePage;

    @BeforeMethod
    public void beforeMethod() {
        browser = new FirefoxDriver();
        browser.get("https://www.linkedin.com/");
        linkedinLoginPage = new LinkedinLoginPage(browser);
    }

    @AfterMethod
    public void afterMethod() {
        browser.close();
    }

    @Test
    public void successfulResetPasswordTest() {
        Assert.assertTrue(linkedinLoginPage.isLoaded(),
                "LoginPage is not loaded.");

        linkedinRequestPasswordResetPage =
                linkedinLoginPage.clickOnForgotPasswordLink();
        Assert.assertTrue(linkedinRequestPasswordResetPage.isLoaded(),
                "RequestPasswordResetPage is not loaded.");

         linkedinPasswordResetSubmitPage =
                linkedinRequestPasswordResetPage.findAccount("hellienathornton@gmail.com");
        Assert.assertTrue(linkedinPasswordResetSubmitPage.isLoaded(),
                "PasswordResetSubmitPage is not loaded.");

        linkedinSetNewPasswordPage =
                linkedinPasswordResetSubmitPage.navigateToLinkFromEmail();
        Assert.assertTrue(linkedinSetNewPasswordPage.isLoaded(),
                "SetNewPasswordPage is not loaded.");

        linkedinConfirmNewPasswordPage = linkedinSetNewPasswordPage.submitPasswordReset();
        Assert.assertTrue(linkedinConfirmNewPasswordPage.isLoaded(), "ConfirmNewPasswordPage is not loaded.");

        linkedinHomePage = linkedinConfirmNewPasswordPage.clickSubmitPasswordResetButton();
        Assert.assertTrue(linkedinHomePage.isLoaded(), "HomePage is not loaded.");
    }

}
