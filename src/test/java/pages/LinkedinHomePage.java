package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class LinkedinHomePage extends BasePage{

    @FindBy(xpath = "//*[@id='profile-nav-item']")
    private WebElement profileNavigationItem;

    @FindBy(xpath = "//input[@placeholder='Search' and @role]")
    private WebElement searchField;

    public LinkedinHomePage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser, this);
    }

    public LinkedinSearchPage search(String searchTerm){
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.ENTER);
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new LinkedinSearchPage(browser);
    }

    public boolean isLoaded() {
        return profileNavigationItem.isDisplayed()
                && getCurrentPageTitle().contains("LinkedIn")
                && getCurrentPageUrl().contains("/feed/");
    }
}
