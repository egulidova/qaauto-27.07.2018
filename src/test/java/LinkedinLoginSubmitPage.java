import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkedinLoginSubmitPage {

    private WebDriver browser;
    private WebElement alertBox;
    private WebElement userEmailValidationText;
    private WebElement userPassValidationText;

    public LinkedinLoginSubmitPage(WebDriver browser) {
        this.browser = browser;
        initElements();
    }

    private void initElements(){
        alertBox = browser.findElement(By.xpath("//*[@role='alert']"));
        try {
            userEmailValidationText = browser.findElement(By.xpath("//*[@id='session_key-login-error']"));
        }
        catch (NoSuchElementException e){}
        try {
            userPassValidationText = browser.findElement(By.xpath("//*[@id='session_password-login-error']"));
        }
        catch (NoSuchElementException e){}
    }

    public String getAlertBoxText (){
        return alertBox.getText();
    }

    public String getCurrentPageUrl(){
        return browser.getCurrentUrl();
    }

    public String getCurrentPageTitle(){
        return browser.getTitle();
    }

    public String getUserEmailValidationText(){
        return userEmailValidationText.getText();
    }
    public String getUserPassValidationText(){
        return userPassValidationText.getText();
    }
    public boolean isLoaded() {
        return alertBox.isDisplayed()
                && getCurrentPageTitle().equals("Sign In to LinkedIn")
                && getCurrentPageUrl().contains("/uas/login-submit");
    }

}
