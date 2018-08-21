import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.security.Key;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Thread.sleep;

public class LinkedinSearchPage extends BasePage{

    @FindBy(xpath = "//*[@class='search-entity search-result search-result--person search-result--occlusion-enabled ember-view']")
    private List<WebElement> searchResults;

    public LinkedinSearchPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser, this);
    }

    public List<String> getLinkedinSearchResultsText(){
        List<String> searchResultsText = searchResults.stream().map((el) -> el.getText().toLowerCase()).collect(Collectors.toList());
        return searchResultsText;
    }

    public boolean searchResultsTextContainsPattern(String pattern){
        return getLinkedinSearchResultsText().stream().allMatch((el) -> el.contains(pattern));
    }

    public boolean isLoaded() {
        return searchResults.size() != 0
                && getCurrentPageTitle().contains("Search")
                && getCurrentPageUrl().contains("/search/results/");
    }
}
