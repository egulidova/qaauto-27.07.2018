import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinResetPasswordPage extends BasePage {

    @FindBy(xpath = "//input[@id='newPassword']")
    private WebElement newPasswordInput;

    @FindBy(xpath = "//input[@id='confirmPassword']")
    private WebElement confirmPasswordInput;

    @FindBy(xpath = "//button[@id='reset-password-submit-button']")
    private WebElement resetPasswordSubmitButton;

    public LinkedinResetPasswordPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser, this);
    }

    public LinkedinResetSubmitPasswordPage inputNewPassword() {
        newPasswordInput.sendKeys("massaraksh1");
        confirmPasswordInput.sendKeys("massaraksh1");
        resetPasswordSubmitButton.click();
        return new LinkedinResetSubmitPasswordPage(browser);
    }

    @Override
    public boolean isLoaded() {
        return newPasswordInput.isDisplayed()
                && getCurrentPageTitle().contains("Reset Your Password | LinkedIn")
                && getCurrentPageUrl().contains("/checkpoint/rp/password-reset");
    }
}
