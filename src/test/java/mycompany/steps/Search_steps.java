package mycompany.steps;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import mycompany.pageobjects.CategoryPages.UsbStickPage;
import mycompany.pageobjects.HeaderPage;
import mycompany.pageobjects.HomePage;
import mycompany.pageobjects.SearchResultsPage;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import static junit.framework.Assert.assertTrue;

public class Search_steps {

    @Managed
    WebDriver driver;

    HomePage homePage;
    HeaderPage headerPage;
    UsbStickPage usbStickPage;
    SearchResultsPage searchResultsPage;

    String searchString;

    @Before
    public void setupTestData() {
    }

    @Given("^user navigates to home page$")
    public void user_navigates_to_home_page() throws Exception {
       homePage = new HomePage(driver);
       homePage.open();
    }

    @When("^user searches for product category (.*)$")
    public void user_searches_for_product_category(String searchStr) throws Exception {
        headerPage = new HeaderPage(driver);
        headerPage.search(searchStr);
    }

    @Then("^user should land in that category page$")
    public void user_should_land_in_that_category_page() throws Exception {
        usbStickPage = new UsbStickPage(driver);
    }

    @When("^user searches with typo error (.*)$")
    public void user_searches_with_typo_error(String searchStr) throws Exception {
        headerPage = new HeaderPage(driver);
        headerPage.search(searchStr);
    }

    @Then("^user should see results page with corrected suggestion (.*)$")
    public void user_should_see_results_page_with_corrected_suggestion(String suggestion) throws Exception {
        searchResultsPage = new SearchResultsPage(driver);
        assertTrue(searchResultsPage.containsAllText(suggestion,"Corrected from"));
    }

    @When("^user searches for nonexistent product (.*)$")
    public void user_searches_for(String searchStr) throws Exception {
        searchString = searchStr;
        headerPage = new HeaderPage(driver);
        headerPage.search(searchStr);
    }

    @Then("^user should see no results page$")
    public void user_should_see_no_results_page() throws Exception {
        searchResultsPage = new SearchResultsPage(driver);
        String noResultsStr = "We couldn't find any results for '" + searchString + "'";
        assertTrue(searchResultsPage.containsText(noResultsStr ) );
    }

}
