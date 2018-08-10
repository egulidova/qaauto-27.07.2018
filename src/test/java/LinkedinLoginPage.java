import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkedinLoginPage {

    WebDriver browser;

    WebElement userEmailField;
    WebElement userPasswordField;
    WebElement signInButton;

    public LinkedinLoginPage(WebDriver browser) {
        this.browser = browser;
        initElements();
    }

    private void initElements(){
       userEmailField = browser.findElement(By.xpath("//input[@id='login-email']"));
       userPasswordField = browser.findElement(By.xpath("//input[@id='login-password']"));
       signInButton = browser.findElement(By.xpath("//input[@id='login-submit']"));
    }

    public void logIn(String userEmail, String userPass) {
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPass);
        signInButton.click();
    }

}
