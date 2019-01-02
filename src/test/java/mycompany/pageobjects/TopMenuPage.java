package mycompany.pageobjects;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class TopMenuPage extends PageObject {

    @FindBy(css = ".product-menu")
    public WebElement product_menu;

    @FindBy(css = "a[href*=computing-peripherals]")
    public WebElement computingAndPeripherals;

    @FindBy(css = "a[href*=data-storage-memory]")
    public WebElement dataStorageAndMemory;

    public TopMenuPage (WebDriver driver) {
        super(driver);
    }

    public void clickProductsMenu(){
        product_menu.click();
    }

    public void goto_dataStorageAndMemory() {
        Actions action = new Actions(super.getDriver());
        action.moveToElement(product_menu).click().moveToElement(computingAndPeripherals)
                .moveToElement(dataStorageAndMemory).click().build().perform();
    }
}
