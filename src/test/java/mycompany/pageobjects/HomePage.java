package mycompany.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebDriver;
@DefaultUrl("http://uk.rs-online.com")
public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }
    public boolean isOnPage() {
            return containsText("RS Advantages");
    }
}
