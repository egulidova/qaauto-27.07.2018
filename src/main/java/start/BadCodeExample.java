package start;

import com.sun.tools.javac.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

import static java.lang.Thread.sleep;

public class BadCodeExample {
    public static void main(String args[]) throws InterruptedException {
        System.out.println("Hello world!!!");
        WebDriver browser = new FirefoxDriver();
        browser.get("https://www.google.com");
        WebElement search = browser.findElement(By.name("q"));
        search.sendKeys("Selenium");
        search.sendKeys(Keys.ENTER);

        sleep(3000);
//       Verify that results list contains elements
        List<WebElement> searchResults = browser.findElements(By.xpath("//div[@class='srg']/div[@class='g']"));
        System.out.println("Results count: " + searchResults.size());

//        Verify, that each result contains searchTerm
        for (WebElement searchResult: searchResults){
            String searchResultText = searchResult.getText();
            System.out.println(searchResultText);
        }
//        searchResults.size();

        browser.close();
    }
}