package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.GMailService;

import static java.lang.Thread.sleep;

public class LinkedinRequestPasswordResetPage extends BasePage {

    @FindBy(xpath = "//input[@id='username']")
    private WebElement userEmailField;

    @FindBy(xpath = "//button[@id='reset-password-submit-button']")
    private WebElement findAccountButton;

    public LinkedinRequestPasswordResetPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser, this);
    }

    public LinkedinPasswordResetSubmitPage findAccount(String userEmail) {
        gMailService = new GMailService(userEmail, "massaraksh");
        gMailService.connect();

        userEmailField.sendKeys(userEmail);
        findAccountButton.click();
        String messageSubject = "here's the link to reset your password";
        String messageTo = "hellienathornton@gmail.com";
        String messageFrom = "security-noreply@linkedin.com";

        String message = gMailService.waitMessage(messageSubject, messageTo, messageFrom, 180);
        System.out.println("Content: " + message);
        return new LinkedinPasswordResetSubmitPage(browser);
    }


    @Override
    public boolean isLoaded() {
        return findAccountButton.isDisplayed()
                && getCurrentPageTitle().equals("Reset Password | LinkedIn")
                && getCurrentPageUrl().contains("/uas/request-password-reset");
    }
}
