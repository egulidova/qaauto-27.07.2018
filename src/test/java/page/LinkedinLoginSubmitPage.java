package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinLoginSubmitPage extends BasePage{

    @FindBy(xpath = "//*[@role='alert']")
    private WebElement alertBox;

    @FindBy(xpath = "//*[@id='session_key-login-error']")
    private WebElement userEmailValidationText;

    @FindBy(xpath = "//*[@id='session_password-login-error']")
    private WebElement userPassValidationText;

    public LinkedinLoginSubmitPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser, this);
        waitUntilElementIsVisible(alertBox,3);
    }

    public String getAlertBoxText (){
        return alertBox.getText();
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
