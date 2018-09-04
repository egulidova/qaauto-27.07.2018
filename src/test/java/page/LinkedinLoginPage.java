package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page object class for LinkedinLoginPage.
 */
public class LinkedinLoginPage extends BasePage{

    @FindBy(xpath = "//input[@id='login-email']")
    private WebElement userEmailField;

    @FindBy(xpath = "//input[@id='login-password']")
    private WebElement userPasswordField;

    @FindBy(xpath = "//input[@id='login-submit']")
    private WebElement signInButton;

    @FindBy(xpath = "//a[@class='link-forgot-password']")
    private WebElement forgotPasswordLink;

    /**
     * Constructor of LinkedinLoginPage class.
     * @param browser - WebDriver instance from test.
     */
    public LinkedinLoginPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser,this);
        waitUntilElementIsVisible(userEmailField, 10);
    }

    /**
     * Class to check if required element on page is displayed.
     * @return true/false when reqiered element on page is/is not displayed.
     */
    @Override
    public boolean isLoaded() {
        return userEmailField.isDisplayed()
                && getCurrentPageTitle().equals("LinkedIn: Log In or Sign Up");
    }

    /**
     * Method that enters user email/user password and click Sign In button.
     * @param userEmail String with user email.
     * @param userPass String with user password.
     * @param <T> Generic type to return corresponding pageObject.
     * @return either LinkedinHomePage, or LinkedinLoginSubmitPage, or LinkedinLoginPage.
     */
    public <T> T logIn(String userEmail, String userPass){ /**<T> T - generic type*/
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPass);
        signInButton.click();

        if (getCurrentPageUrl().contains("/feed")){
            return (T) new LinkedinHomePage(browser); /**(Type) another type - приведение типов*/
        }
        if (getCurrentPageUrl().contains("/uas/login-submit")){
            return (T) new LinkedinLoginSubmitPage(browser);
        } else{
            return (T) this;
        }
    }

    /**
     * Method for click on Forgot Password link.
     * @return LinkedinRequestPasswordResetPage.
     */
    public LinkedinRequestPasswordResetPage clickOnForgotPasswordLink(){
        forgotPasswordLink.click();
        return new LinkedinRequestPasswordResetPage(browser);
    }
}
