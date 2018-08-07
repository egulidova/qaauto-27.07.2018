import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LinkedinLoginTest {

    @Test
    public void successfulLoginTest(){
        WebDriver browser = new FirefoxDriver();
        browser.get("https://www.linkedin.com/");
        WebElement userEmailField = browser.findElement(By.xpath("//input[@id='login-email']'"));
        WebElement userPasswordField = browser.findElement(By.xpath("//input[@id='login-password']"));
        WebElement signInButton = browser.findElement(By.xpath("//input[@id='login-submit']"));

        userEmailField.sendKeys("gulidova.elena@gmail.com");
        userPasswordField.sendKeys("");
        signInButton.click();

        WebElement profileDropdown = browser.findElement(By.xpath("//*[@id='nav-settings__dropdown-trigger']"));
        String pageUrl = browser.getCurrentUrl();
        String pageTitle = browser.getTitle();

        browser.close();
        Assert.assertTrue(profileDropdown.isDisplayed(), "No profile dropdown on logged in page");
        Assert.assertTrue(pageUrl.contains("/feed"), "Incorrect page url");
        Assert.assertTrue(pageTitle.contains("LinkedIn"), "Incorrect page title");

    }

    @Test
    public void negativeLoginTest(){
        WebDriver browser = new FirefoxDriver();
        browser.get("https://www.linkedin.com/");
        WebElement userEmailField = browser.findElement(By.xpath("//input[@id=\"login-email\"]"));
        WebElement userPasswordField = browser.findElement(By.xpath("//input[@id=\"login-password\"]"));
        WebElement signInButton = browser.findElement(By.xpath("//input[@id=\"login-submit\"]"));

        userEmailField.sendKeys("a@b.c");
        userPasswordField.sendKeys("123");
        signInButton.click();

        WebElement allertBox = browser.findElement(By.xpath("//*[@role='alert']"));

        Assert.assertEquals(allertBox.getText(), "There were one or more errors in your submission. Please correct the marked fields below.", "Incorrect message in alert box");
        browser.close();
    }


}
