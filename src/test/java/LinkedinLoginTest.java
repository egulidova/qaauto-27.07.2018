import org.openqa.selenium.WebDriver;
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
    public void beforeMethod(){
        browser = new FirefoxDriver();
        browser.get("https://www.linkedin.com/");
        linkedinLoginPage = new LinkedinLoginPage(browser);
    }

    @AfterMethod
    public void afterMethod(){
        browser.close();
    }

    @Test
    public void successfulLoginTest() {
        linkedinLoginPage.logIn("hellienathornton@gmail.com", "massaraksh");

        LinkedinHomePage linkedinHomePage = new LinkedinHomePage(browser);

        Assert.assertTrue(linkedinHomePage.isLoaded(), "Home page is not loaded.");
    }

    @Test
    public void negativeLoginTest(){
        linkedinLoginPage.logIn("a@b.c", "123");
        LinkedinLoginSubmitPage linkedinLoginSubmitPage = new LinkedinLoginSubmitPage(browser);
        Assert.assertEquals(linkedinLoginSubmitPage.getAlertBoxText(),
                "There were one or more errors in your submission. Please correct the marked fields below.",
                "Incorrect message in alert box");
    }

// make negative login tests
//    equivalent classes
}
