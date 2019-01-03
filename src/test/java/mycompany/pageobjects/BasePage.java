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
}
