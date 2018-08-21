import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LinkedinSearchTest {

    private WebDriver browser;
    private LinkedinLoginPage linkedinLoginPage;
    private LinkedinHomePage linkedinHomePage;
    private LinkedinSearchPage linkedinSearchPage;

    @BeforeMethod
    public void beforeMethod() {
        browser = new FirefoxDriver();
        browser.get("https://www.linkedin.com/");
        linkedinLoginPage = new LinkedinLoginPage(browser);
        linkedinHomePage = linkedinLoginPage.logInToHomePage("hellienathornton@gmail.com","massaraksh");
    }

    @AfterMethod
    public void afterMethod() {
        browser.close();
    }

    @Test
    public void searchResultsOnSearchPage() {
        linkedinSearchPage =  linkedinHomePage.linkedinSearchPage("HR");
        Assert.assertTrue(linkedinSearchPage.isLoaded(), "Search page is not loaded.");
        Assert.assertEquals(linkedinSearchPage.getLinkedinSearchResultsText().size(), 10, "Not enough search results on search page");
        Assert.assertTrue(linkedinSearchPage.searchResultsTextContainsPattern("hr"));
    }
}
