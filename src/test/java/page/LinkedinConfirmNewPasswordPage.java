package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinConfirmNewPasswordPage extends BasePage{

    @FindBy(xpath = "//button[@id='reset-password-submit-button']")
    private WebElement resetPasswordSubmitButton;

    public LinkedinConfirmNewPasswordPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser, this);
        waitUntilElementIsVisible(resetPasswordSubmitButton,10);
    }

    /**
     * Class to check if required element on page is displayed.
     * @return true/false when reqiered element on page is/is not displayed.
     */
    @Override
    public boolean isLoaded() {
        return resetPasswordSubmitButton.isDisplayed()
                && getCurrentPageTitle().contains("You've successfully reset your password. | LinkedIn")
                && getCurrentPageUrl().contains("/checkpoint/rp/password-reset-submit");
    }

    public LinkedinHomePage clickSubmitPasswordResetButton(){
        resetPasswordSubmitButton.click();
        return new LinkedinHomePage(browser);
    }
}
