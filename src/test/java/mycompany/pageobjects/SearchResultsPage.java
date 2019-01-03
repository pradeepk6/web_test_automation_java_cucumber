package mycompany.pageobjects;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends BasePage {

    @FindBy(id = "#mainContent")
    public WebElementFacade mainContent_div;

    public SearchResultsPage (WebDriver driver) {
        super(driver);
    }
}
