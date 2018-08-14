import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static java.lang.Thread.sleep;

public class LinkedinLoginPage {

    private WebDriver browser;

    private WebElement userEmailField;
    private WebElement userPasswordField;
    private WebElement signInButton;

    public LinkedinLoginPage(WebDriver browser) {
        this.browser = browser;
        initElements();
    }

    private void initElements(){
       userEmailField = browser.findElement(By.xpath("//input[@id='login-email']"));
       userPasswordField = browser.findElement(By.xpath("//input[@id='login-password']"));
       signInButton = browser.findElement(By.xpath("//input[@id='login-submit']"));
    }

    public void logIn(String userEmail, String userPass){
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPass);
        signInButton.click();
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getCurrentPageUrl(){
        return browser.getCurrentUrl();
    }

    public String getCurrentPageTitle(){
        return browser.getTitle();
    }

    public boolean isLoaded() {
        return userEmailField.isDisplayed()
                && getCurrentPageTitle().equals("LinkedIn: Log In or Sign Up");
    }

}
