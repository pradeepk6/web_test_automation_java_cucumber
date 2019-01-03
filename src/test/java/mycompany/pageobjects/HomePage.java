package mycompany.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("http://uk.rs-online.com")
public class HomePage extends BasePage {

    @FindBy(css = ".home_heroBanner")
    public WebElementFacade banner_div;

    public HomePage(WebDriver driver) {
        super(driver);
    }
    public boolean isOnPage() {
        return containsText("RS Advantages");
    }
}
