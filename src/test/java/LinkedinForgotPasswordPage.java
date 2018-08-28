import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class LinkedinForgotPasswordPage extends BasePage {

    @FindBy(xpath = "//header[@class='content__header']")
    private WebElement contentHeader;

    @FindBy(xpath = "//input[@id='username']")
    private WebElement usernameInputField;

    @FindBy(xpath = "//button[@id='reset-password-submit-button']")
    private WebElement resetPasswordSubmitButton;

    public LinkedinForgotPasswordPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser, this);
    }

    public LinkedinResetPasswordPage getResetPasswordLinkFromUserEmail(){
        usernameInputField.sendKeys("hellienathornton@gmail.com");
        resetPasswordSubmitButton.click();
        try {
            sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new LinkedinResetPasswordPage(browser);
    }


    @Override
    public boolean isLoaded() {
        return contentHeader.isDisplayed()
                && getCurrentPageTitle().contains("Reset Password | LinkedIn")
                && getCurrentPageUrl().contains("/request-password-reset");
    }
}
