package mycompany.pageobjects;

import mycompany.utils.MyUtils;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HeaderPage extends PageObject {

    @FindBy(css = "a[href*=basketsummary]")
    public WebElementFacade cart_link;

    //@FindBy(id = "#searchTerm")
    //*[@id="searchTerm"]
    @FindBy(xpath = "//*[@id='searchTerm']")
    public WebElementFacade search_input;


    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    public void gotoMyBasket(){
        MyUtils.checkForPopupAndKill(super.getDriver());
        cart_link.click();
    }

    public void search(String str){
        search_input.clear();
        search_input.sendKeys(str);
        search_input.submit();
    }


}
