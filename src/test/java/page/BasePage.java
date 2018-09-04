package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.GMailService;

/**
 * Base class for all pages for test.
 */
public abstract class BasePage {

    protected WebDriver browser;
    protected static  GMailService gMailService = new GMailService();

    /**
     * Base class for return WebElement.
     * @param webElement - element on page, test is waiting for.
     * @param timeOutInSeconds - maximum time to wait for webElement is displayed.
     * @return element on page, method is waiting for.
     */
    public WebElement waitUntilElementIsVisible (WebElement webElement, int timeOutInSeconds){
        WebDriverWait wait = new WebDriverWait(browser, timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(webElement));
        return webElement;
    }

    /**
     * Base method to get current page title.
     * @return Title for current page.
     */
    public String getCurrentPageTitle(){
        return browser.getTitle();
    }

    /**
     * Base method to get current page Url.
     * @return Url for current page.
     */
    public String getCurrentPageUrl(){
        return browser.getCurrentUrl();
    }

    /**
     * Abstract class to implement in each class extends BasePage.
     * @return false.
     */
    public abstract boolean isLoaded();


}
