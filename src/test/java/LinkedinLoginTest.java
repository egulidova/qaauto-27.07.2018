import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
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

    @Test
    public void successfulLoginTest() {
        linkedinLoginPage.logIn("hellienathornton@gmail.com", "massaraksh");

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

    @Test
    public void emptyPasswordOnLoginPageTest() {
        linkedinLoginPage.logIn("hellienathornton@gmail.com", "");
        String url = browser.getCurrentUrl();

        Assert.assertEquals(url, "https://www.linkedin.com/", "Redirect to " + url + "with empty password field.");
    }

    @Test
    public void wrongPasswordSubmitTest() {
        linkedinLoginPage.logIn("hellienathornton@gmail.com","123");
        LinkedinLoginSubmitPage linkedinLoginSubmitPage = new LinkedinLoginSubmitPage(browser);
        Assert.assertEquals(linkedinLoginSubmitPage.getPasswordLoginErrorText(),
                "The password you provided must have at least 6 characters.",
                "Incorrect message for wrong password");
    }

    @Test
    public void wrongLoginSubmitTest() {
        linkedinLoginPage.logIn("a@b.c","massaraksh");
        LinkedinLoginSubmitPage linkedinLoginSubmitPage = new LinkedinLoginSubmitPage(browser);
        Assert.assertEquals(linkedinLoginSubmitPage.getKeyLoginErrorText(),
                "Please enter a valid email address.",
                "Incorrect message for wrong password");
    }

}
