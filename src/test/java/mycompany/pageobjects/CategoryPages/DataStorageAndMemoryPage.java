package mycompany.pageobjects.CategoryPages;

import mycompany.pageobjects.BasePage;
import mycompany.utils.MyUtils;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

//@DefaultUrl("https://uk.rs-online.com/web/c/computing-peripherals/data-storage-memory")
public class DataStorageAndMemoryPage extends BasePage {

    @FindBy(css = "a[href*=usb-sticks]")
    public WebElement usbSticks;

    public DataStorageAndMemoryPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnPage() {
        return containsText("Data Storage & Memory");
    }

    public void clickUsbSticks(){
        //usbSticks.click();
//        Actions action = new Actions(super.getDriver());
//        action.moveToElement(usbSticks).click().build().perform();
        JavascriptExecutor jse = (JavascriptExecutor)super.getDriver();
        jse.executeScript("arguments[0].scrollIntoView()", usbSticks);
        MyUtils.checkForpopupAndKill(super.getDriver());
        jse.executeScript("arguments[0].click();", usbSticks);
    }
}
