package mycompany.pageobjects.CategoryPages;

import mycompany.pageobjects.BasePage;
import mycompany.utils.MyUtils;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static net.thucydides.core.pages.components.HtmlTable.rowsFrom;

import java.util.List;
import java.util.Map;

//@DefaultUrl("https://uk.rs-online.com/web/c/computing-peripherals/data-storage-memory/usb-sticks")
public class UsbStickPage extends BasePage {

    @FindBy(id = "results-table")
    public WebElement resultsTable;


    public UsbStickPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnPage() {
        return containsText("USB Sticks");
    }

    public void getProductDetails() {
        List<Map<Object, String>> productList = getSearchResults();
        productList.forEach(item ->
                item.forEach((k, v) -> System.out.println(k.toString() + ": " + v)
                ));
    }

    private List<Map<Object, String>> getSearchResults() {
        return rowsFrom(resultsTable);
    }

    public void clickFirstProduct() {
        List<WebElement> tableRows = resultsTable.findElements(By.tagName("tr"));
        List<WebElement> tableCells = tableRows.get(0).findElements(By.tagName("td"));

        WebElement wef = tableCells.get(0);
       // WebElementFacade wef = (WebElementFacade)tableCells.get(0);


        JavascriptExecutor jse = (JavascriptExecutor)super.getDriver();
        jse.executeScript("arguments[0].scrollIntoView()", wef);
        MyUtils.checkForpopupAndKill(super.getDriver());
        wef.click();
        //jse.executeScript("arguments[0].click();", wef);

    }


}
