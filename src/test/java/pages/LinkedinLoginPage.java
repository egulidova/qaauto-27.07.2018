package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class LinkedinLoginPage extends BasePage{

    @FindBy(xpath = "//input[@id='login-email']")
    private WebElement userEmailField;

    @FindBy(xpath = "//input[@id='login-password']")
    private WebElement userPasswordField;

    @FindBy(xpath = "//input[@id='login-submit']")
    private WebElement signInButton;

    @FindBy(xpath = "//a[@class='link-forgot-password']")
    private WebElement forgotPasswordLink;

    public LinkedinLoginPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser,this);
    }

    public LinkedinLoginPage logInToLoginPage(String userEmail, String userPass){
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPass);
        signInButton.click();
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new LinkedinLoginPage(browser);
    }

    public LinkedinLoginSubmitPage logInToLoginSubmitPage(String userEmail, String userPass){
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPass);
        signInButton.click();
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new LinkedinLoginSubmitPage(browser);
    }

    public LinkedinHomePage logInToHomePage(String userEmail, String userPass){
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPass);
        signInButton.click();
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new LinkedinHomePage(browser);
    }

    public boolean isLoaded() {
        return userEmailField.isDisplayed()
                && getCurrentPageTitle().equals("LinkedIn: Log In or Sign Up");
    }

    public LinkedinRequestPasswordResetPage clickOnForgotPasswordLink(){
        forgotPasswordLink.click();
        return new LinkedinRequestPasswordResetPage(browser);
    }
}
