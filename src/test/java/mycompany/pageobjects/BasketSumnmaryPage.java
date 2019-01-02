package mycompany.pageobjects;

import model.LineItem;
import model.Product;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BasketSumnmaryPage  extends BasePage {

    @FindBy(css = ".cartTable")
    public WebElement cartTable;

    public BasketSumnmaryPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnPage() {
        return containsText("My basket");
    }

    public LineItem getFirstLineItem() {
        Product product = new Product();

        List<WebElement> tableRows = cartTable.findElements(By.cssSelector(".dataRow"));
        List<WebElement> tableCells = tableRows.get(0).findElements(By.tagName("td"));
        String name = tableCells.get(1).findElement(By.tagName("a")).getText();
        product.setName(name);
        String quantity =  tableCells.get(2).findElement(By.cssSelector("input.costColumn")).getAttribute("value");
        System.out.println("LineItem name and units : " + name + " ; " + quantity);
        LineItem lineItem = new LineItem(product, Integer.parseInt(quantity));

        return lineItem;
    }
}
