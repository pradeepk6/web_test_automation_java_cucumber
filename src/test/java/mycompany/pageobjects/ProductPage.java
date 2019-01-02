package mycompany.pageobjects;

import mycompany.utils.MyUtils;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {


    @FindBy(css = "h1.col-xs-12")
    public WebElementFacade name;


    @FindBy(css = ".form-control")
    public WebElement units;


    @FindBy(css = ".btn-primary-red")
    public WebElementFacade addToBasket_bt;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName(){
        return name.waitUntilVisible().getText();
    }

    public void addUnits(String numUnits) {
        units.sendKeys(numUnits);
    }

    public void addToBasket() {
        JavascriptExecutor jse = (JavascriptExecutor)super.getDriver();
        jse.executeScript("arguments[0].scrollIntoView()", addToBasket_bt);
        MyUtils.checkForpopupAndKill(super.getDriver());
        jse.executeScript("arguments[0].click();", addToBasket_bt);
    }
}
