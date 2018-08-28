import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LinkedinPasswordResetTest {

    private WebDriver browser;
    private LinkedinLoginPage linkedinLoginPage;
    private LinkedinForgotPasswordPage linkedinForgotPasswordPage;
    private LinkedinResetPasswordPage linkedinResetPasswordPage;

    @BeforeMethod
    public void beforeMethod() {
        browser = new FirefoxDriver();
        browser.get("https://www.linkedin.com/");
        linkedinLoginPage = new LinkedinLoginPage(browser);
    }

    @AfterMethod
    public void afterMethod() {
        browser.close();
    }

    @Test
    public void passwordResetTest() {
        linkedinForgotPasswordPage = linkedinLoginPage.useForgotPasswordLink();
        Assert.assertTrue(linkedinForgotPasswordPage.isLoaded(), "Forgot password page is not loaded.");
        linkedinResetPasswordPage =  linkedinForgotPasswordPage.getResetPasswordLinkFromUserEmail();
        Assert.assertTrue(linkedinResetPasswordPage.isLoaded(), "Reset password page is not loaded.");
    }

    // тест на забыл пароль
    // на месте чтения почты в тесте поставить слип на 2 минуты, скопровать ссылку из почты и вставить в адресную строку
}
