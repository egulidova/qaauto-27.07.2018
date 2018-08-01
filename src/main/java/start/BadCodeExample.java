package start;

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
        if ( searchResults.size() == 10){
            System.out.println("Results count: 10. Test Passed");
        }
        else System.out.println("Expected results count: 10. Actual results count: " + searchResults.size() + ". Test Failed");

//        Verify, that each result contains searchTerm
        boolean containsTerm = true;
        for (ebElement searchResult: searchResults){
            String searchResultText = searchResult.getText();
            if (!searchResultText.contains("Selenium")){
                System.out.println("Result should contain term \"Selenium\". Actual Result:" + searchResultText + "Test Failed");
                containsTerm = false;
            }
        }
        if (containsTerm) {
            System.out.println("Each result contains term \"Selenium\". Test Passed");
        }

        browser.close();
    }
}