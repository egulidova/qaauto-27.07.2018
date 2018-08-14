import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class LinkedinLoginTest {

    WebDriver browser;
    LinkedinLoginPage linkedinLoginPage;

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

    @DataProvider
    public Object[][] validFieldsCombinationProvider() {
        return new Object[][]{
                {"hellienathornton@gmail.com"},
                {" hellienathornton@gmail.com"},
                {"HELLIENATHORNTON@GMAIL.COM"}
        };
    }


    @Test(dataProvider = "validFieldsCombinationProvider")
    public void successfulLoginTest(String userEmail) {
        linkedinLoginPage.logIn(userEmail, "massaraksh");

        LinkedinHomePage linkedinHomePage = new LinkedinHomePage(browser);

        Assert.assertTrue(linkedinHomePage.isLoaded(), "Home page is not loaded.");
    }

    @Test
    public void negativeLoginTest() {
        linkedinLoginPage.logIn("a@b.c", "123");
        LinkedinLoginSubmitPage linkedinLoginSubmitPage = new LinkedinLoginSubmitPage(browser);
        Assert.assertEquals(linkedinLoginSubmitPage.getAlertBoxText(),
                "There were one or more errors in your submission. Please correct the marked fields below.",
                "Incorrect message in alert box");
    }

    @DataProvider
    public Object[][] EmptyFieldCombinationsProvider() {
        return new Object[][]{
                {"",""},
                {"","P@ssword123"},
                {"someone@domain.com",""}
        };
    }

    @Test (dataProvider = "EmptyFieldCombinationsProvider")
    public void validateEmptyUserEmailAndUserPass(String userEmail, String userPass) {
        linkedinLoginPage.logIn(userEmail, userPass);
        Assert.assertTrue(linkedinLoginPage.isLoaded(), "User is not on login page");
    }

    @Test
    public void validateShortUserEmailAndUserPass() {
        linkedinLoginPage.logIn("a", "a");
        LinkedinLoginSubmitPage linkedinLoginSubmitPage = new LinkedinLoginSubmitPage(browser);

        Assert.assertTrue(linkedinLoginSubmitPage.isLoaded(), "User is not on login-submit page");

        Assert.assertEquals(linkedinLoginSubmitPage.getAlertBoxText(),
                "There were one or more errors in your submission. Please correct the marked fields below.",
                "Incorrect message in alert box");

        Assert.assertEquals(linkedinLoginSubmitPage.getUserEmailValidationText(),
                "The text you provided is too short (the minimum length is 3 characters, your text contains 1 character).",
                "Incorrect message for wrong password");

        Assert.assertEquals(linkedinLoginSubmitPage.getUserPassValidationText(),
                "The password you provided must have at least 6 characters.",
                "Incorrect message for wrong password");
    }

    @Test
    public void wrongPasswordSubmitTest() {
        linkedinLoginPage.logIn("hellienathornton@gmail.com", "123");
        LinkedinLoginSubmitPage linkedinLoginSubmitPage = new LinkedinLoginSubmitPage(browser);
        Assert.assertEquals(linkedinLoginSubmitPage.getUserPassValidationText(),
                "The password you provided must have at least 6 characters.",
                "Incorrect message for wrong password");
    }

    @Test
    public void wrongLoginSubmitTest() {
        linkedinLoginPage.logIn("a@b.c", "massaraksh");
        LinkedinLoginSubmitPage linkedinLoginSubmitPage = new LinkedinLoginSubmitPage(browser);
        Assert.assertEquals(linkedinLoginSubmitPage.getUserEmailValidationText(),
                "Please enter a valid email address.",
                "Incorrect message for wrong password");
    }

}
