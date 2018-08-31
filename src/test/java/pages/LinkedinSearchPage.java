package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
    }

    public List<String> getLinkedinSearchResultsText(){
        List<String> searchResultsText = searchResults.stream().map((el) -> el.getText().toLowerCase()).collect(Collectors.toList());
        return searchResultsText;
    }

    public boolean isSearchResultsTextContainsSearchTerm(String searchTerm){
        return getLinkedinSearchResultsText().stream().allMatch((el) -> el.contains(searchTerm));
    }

    public int getSearchResultsCount() {
        return searchResults.size();
    }

    public boolean isLoaded() {
        return searchResultsTotal.isDisplayed()
                && getCurrentPageTitle().contains("| Search | LinkedIn")
                && getCurrentPageUrl().contains("/search/results/");
    }
}
