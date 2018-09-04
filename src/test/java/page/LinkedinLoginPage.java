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
     * Method for login try from LoginPage.
     * @param userEmail User email
     * @param userPass User password
     * @return LinkedinLoginPage
     */
    public LinkedinLoginPage logInToLoginPage(String userEmail, String userPass){
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPass);
        signInButton.click();
        return new LinkedinLoginPage(browser);
    }

    /**
     * Method for login try from LoginPage.
     * @param userEmail User email
     * @param userPass User password
     * @return LinkedinLoginSubmitPage
     */
    public LinkedinLoginSubmitPage logInToLoginSubmitPage(String userEmail, String userPass){
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPass);
        signInButton.click();
        return new LinkedinLoginSubmitPage(browser);
    }

    /**
     * Method for login try from LoginPage.
     * @param userEmail User email
     * @param userPass User password
     * @return LinkedinHomePage.
     */
    public LinkedinHomePage logInToHomePage(String userEmail, String userPass){
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPass);
        signInButton.click();
        return new LinkedinHomePage(browser);
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
