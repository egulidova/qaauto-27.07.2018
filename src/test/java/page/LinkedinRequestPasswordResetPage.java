package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LinkedinRequestPasswordResetPage extends BasePage {

    @FindBy(xpath = "//input[@id='username']")
    private WebElement userEmailField;

    @FindBy(xpath = "//button[@id='reset-password-submit-button']")
    private WebElement findAccountButton;

    public LinkedinRequestPasswordResetPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser, this);
        waitUntilElementIsVisible(findAccountButton, 10);
    }

    /**
     * Class to check if required element on page is displayed.
     * @return true/false when reqiered element on page is/is not displayed.
     */
    @Override
    public boolean isLoaded() {
        return findAccountButton.isDisplayed()
                && getCurrentPageTitle().equals("Reset Password | LinkedIn")
                && getCurrentPageUrl().contains("/uas/request-password-reset");
    }

    public LinkedinPasswordResetSubmitPage findAccount(String userEmail) {
        gMailService.connect();
        userEmailField.sendKeys(userEmail);
        findAccountButton.click();
        return new LinkedinPasswordResetSubmitPage(browser);
    }

}
