import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LinkedinLoginTest {

    @Test
    public void successfulLoginTest(){

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
