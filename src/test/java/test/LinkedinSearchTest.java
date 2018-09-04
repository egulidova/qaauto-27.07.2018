package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.LinkedinHomePage;
import page.LinkedinLoginPage;
import page.LinkedinSearchPage;
import test.baseTest.BaseTest;

import java.util.List;

public class LinkedinSearchTest  extends BaseTest {

    private LinkedinHomePage linkedinHomePage;
    private LinkedinSearchPage linkedinSearchPage;

    @Test
    public void searchResultsOnSearchPage() {
        String searchTerm = "HR";
        Assert.assertTrue(linkedinHomePage.isLoaded(), "Home page is not loaded.");
        linkedinSearchPage =  linkedinHomePage.search(searchTerm);
        Assert.assertTrue(linkedinSearchPage.isLoaded(), "Search page is not loaded.");

        Assert.assertEquals(linkedinSearchPage.getSearchResultsCount(), 10, "Not enough search results on search page");

        List<String> searchResults = linkedinSearchPage.getSearchResultsList();
        for (String searchResult: searchResults){
            Assert.assertTrue(searchResult.toLowerCase().contains(searchTerm.toLowerCase()), "search term: "+searchTerm+" not found in: \n"+searchResult);
        }
    }
}
