import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkedinHomePage {

    WebElement webElement;
    String xPath;

    public LinkedinHomePage(WebDriver browser, String xPath){
        this.xPath = xPath;
        this.webElement = getPageElement(browser);
    }


    public WebElement getPageElement(WebDriver browser){
        return browser.findElement(By.xpath(xPath));
    }

    public boolean isElementDisplayed(){
        return webElement.isDisplayed();
    }
}
