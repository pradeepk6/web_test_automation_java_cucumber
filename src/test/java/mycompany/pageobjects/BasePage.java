package mycompany.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebDriver;

public class BasePage extends PageObject {

    public HeaderPage headerPage;
    public TopMenuPage topMenuPage;
    public FooterPage footerPage;

    public BasePage(WebDriver driver) {
        super(driver);
        headerPage = new HeaderPage(driver);
        topMenuPage = new TopMenuPage(driver);
        footerPage = new FooterPage(driver);
    }
    /*
    public void checkForPopupAndKill() {
        int numWindows = super.getDriver().getWindowHandles().size();
        if(numWindows > 1) {
            System.out.println("numWindows : " + numWindows);
            super.getDriver().switchTo().alert().dismiss();
        }
    }
    */
}
