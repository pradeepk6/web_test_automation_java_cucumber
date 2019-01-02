package mycompany.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://www.itv.com/hub/categories")
public class CategoriesPage extends PageObject {

    @FindBy(css = "a[href*=factual]")
    public WebElement factual_link;

    public CategoriesPage(WebDriver driver) {
        super(driver);
    }
    public boolean isOnPage() {
        return containsText("Drama & Soaps");
    }
    public void clickFactualLink() {
        factual_link.click();
    }
}
