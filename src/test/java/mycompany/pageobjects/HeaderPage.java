package mycompany.pageobjects;

import mycompany.utils.MyUtils;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderPage extends PageObject {

    @FindBy(css = "a[href*=basketsummary]")
    public WebElementFacade cart_link;

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    public void gotoMyBasket(){
        MyUtils.checkForpopupAndKill(super.getDriver());
        cart_link.click();
    }
}
