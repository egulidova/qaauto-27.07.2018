import org.openqa.selenium.By;
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

    @BeforeMethod
    public void beforeMethod(){
        browser = new FirefoxDriver();
        browser.get("https://www.linkedin.com/");
    }

    @AfterMethod
    public void afterMethod(){
        browser.close();
    }

    @Test
    public void successfulLoginTest() throws InterruptedException {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(browser);
        linkedinLoginPage.logIn("hellienathornton@gmail.com", "massaraksh");
        sleep(3000);

        String pageUrl = browser.getCurrentUrl();
        String pageTitle = browser.getTitle();
        WebElement profileDropdown = browser.findElement(By.xpath("//*[@id='profile-nav-item']"));

        Assert.assertTrue(profileDropdown.isDisplayed(), "No profile dropdown on home page");
        Assert.assertEquals(pageUrl, "https://www.linkedin.com/feed/", "Home page url incorrect");
        Assert.assertEquals(pageTitle, "LinkedIn", "Home page title incorrect");

    }

    @Test
    public void negativeLoginTest() throws InterruptedException {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(browser);
        linkedinLoginPage.logIn("a@b.c", "123");
        sleep(3000);

        WebElement allertBox = browser.findElement(By.xpath("//*[@role='alert']"));

        Assert.assertEquals(allertBox.getText(), "There were one or more errors in your submission. Please correct the marked fields below.", "Incorrect message in alert box");
    }


}
