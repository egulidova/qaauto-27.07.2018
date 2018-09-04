package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LinkedinSearchPage extends BasePage{

    @FindBy(xpath = "//li[contains(@class, 'search-result__occluded-item')]")
    private List<WebElement> searchResults;

    @FindBy(xpath = "//h3[contains(@class, 'search-results__total')]")
    private WebElement searchResultsTotal;

    public LinkedinSearchPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser, this);
        waitUntilElementIsVisible(searchResultsTotal, 10);
    }

    /**
     * Class to check if required element on page is displayed.
     * @return true/false when reqiered element on page is/is not displayed.
     */
    @Override
    public boolean isLoaded() {
        return searchResultsTotal.isDisplayed()
                && getCurrentPageTitle().contains("| Search | LinkedIn")
                && getCurrentPageUrl().contains("/search/results/");
    }

    public List<String> getSearchResultsList(){
       List<String> searchResultsList = new ArrayList<>();
       for (WebElement searchResult: searchResults){
           ((JavascriptExecutor) browser).executeScript("arguments[0].scrollIntoView();", searchResult);
           searchResultsList.add(searchResult.getText());
       }
        return searchResultsList;
    }

    public int getSearchResultsCount() {
        return searchResults.size();
    }
}
