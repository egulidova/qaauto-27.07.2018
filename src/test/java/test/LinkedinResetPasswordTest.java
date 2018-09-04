package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.*;
import test.baseTest.BaseTest;

public class LinkedinResetPasswordTest  extends BaseTest {

    LinkedinRequestPasswordResetPage linkedinRequestPasswordResetPage;
    LinkedinPasswordResetSubmitPage linkedinPasswordResetSubmitPage;
    LinkedinSetNewPasswordPage linkedinSetNewPasswordPage;
    LinkedinConfirmNewPasswordPage linkedinConfirmNewPasswordPage;
    LinkedinHomePage linkedinHomePage;


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
