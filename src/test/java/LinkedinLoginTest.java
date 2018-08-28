import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LinkedinLoginTest {

    private WebDriver browser;
    private LinkedinLoginPage linkedinLoginPage;

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

    @DataProvider
    public Object[][] validFieldsCombinationProvider() {
        return new Object[][]{
                {"hellienathornton@gmail.com"},
                {" hellienathornton@gmail.com"},
                {"HELLIENATHORNTON@GMAIL.COM"}
        };
    }


    @Test(dataProvider = "validFieldsCombinationProvider")
    public void successfulLoginTest(String userEmail) {
        LinkedinHomePage linkedinHomePage =  linkedinLoginPage.logInToHomePage(userEmail, "massaraksh1");
        Assert.assertTrue(linkedinHomePage.isLoaded(), "Home page is not loaded.");
    }


    @DataProvider
    public Object[][] invalidFieldsCombinationProvider() {
        return new Object[][]{
                {"hellienathornton@gmail.com", "123",
                        "",
                        "The password you provided must have at least 6 characters."},
                {"hellienathornton@gmail.com", "123456",
                        "",
                        "Hmm, that's not the right password. Please try again or request a new one."},
                {"a@b.c", "123",
                        "Please enter a valid email address.",
                        "The password you provided must have at least 6 characters."},
                {"a@b.c", "123456",
                        "Please enter a valid email address.",
                        ""},
                {"ыыы@иии.ccc", "123",
                        "Please enter a valid email address.",
                        "The password you provided must have at least 6 characters."},
                {"ыыы@иии.ccc", "123456",
                        "Please enter a valid email address.",
                        ""},
                {"aaa", "123",
                        "Please enter a valid email address.",
                        "The password you provided must have at least 6 characters."},
                {"a", "123456",
                        "The text you provided is too short (the minimum length is 3 characters, your text contains 1 character).",
                        ""},
                {"ыыы", "123",
                        "",
                        "The password you provided must have at least 6 characters."},
                {"ыыы", "123456",
                        "Be sure to include \"+\" and your country code.",
                        ""},
                {"123", "123",
                        "",
                        "The password you provided must have at least 6 characters."},
                {"123", "123456",
                        "Be sure to include \"+\" and your country code.",
                        "The password you provided must have at least 6 characters."},
                {"asdfghjklzasdfghjklzasdfghjklzasdfghjklzasdfghjklzasdfghjklzasdfghjklzasdfghjklzasdfghjklzasdfghjklzasdfghjklzasdfghjklzasdfghjklz",
                        "asdfghjklzasdfghjklzasdfghjklzasdfghjklzasdfghjklzasdfghjklzasdfghjklz",
                        "The text you provided is too long (the maximum length is 128 characters, your text contains 130 characters).",
                        ""},
                {"asdfghjklzas@bbb.ccc", "asdfghjklzasdfghjklzasdfghjklzasdfghjklzasdfghjklzasdfghjklzasdfghjklz",
                        "Hmm, we don't recognize that email. Please try again.",
                        ""}
        };
    }

    @Test(dataProvider = "invalidFieldsCombinationProvider")
    public void negativeLoginTest(String userEmail, String userPass, String emailValidationText, String passwordValidationText) {
        LinkedinLoginSubmitPage linkedinLoginSubmitPage = linkedinLoginPage.logInToLoginSubmitPage(userEmail, userPass);
        Assert.assertTrue(linkedinLoginSubmitPage.isLoaded(), "User is not on LoginSubmit page");
        Assert.assertEquals(linkedinLoginSubmitPage.getAlertBoxText(),
                "There were one or more errors in your submission. Please correct the marked fields below.",
                "Incorrect message in alert box");
        Assert.assertEquals(linkedinLoginSubmitPage.getUserEmailValidationText(),
                emailValidationText,
                "Incorrect message for wrong password");
        Assert.assertEquals(linkedinLoginSubmitPage.getUserPassValidationText(),
                passwordValidationText,
                "Incorrect message for wrong password");
    }

    @DataProvider
    public Object[][] EmptyFieldCombinationsProvider() {
        return new Object[][]{
                {"", ""},
                {"", "P@ssword123"},
                {"someone@domain.com", ""}
        };
    }

    @Test(dataProvider = "EmptyFieldCombinationsProvider")
    public void validateEmptyUserEmailAndUserPass(String userEmail, String userPass) {
        linkedinLoginPage.logInToLoginPage(userEmail, userPass);
        Assert.assertTrue(linkedinLoginPage.isLoaded(), "User is not on login page");
    }

    //Написать тест на поиск эйчаров

}
