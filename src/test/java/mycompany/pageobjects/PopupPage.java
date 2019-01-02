package mycompany.pageobjects;


import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebDriver;

public class PopupPage extends PageObject {
    public PopupPage(WebDriver driver) {
        super(driver);
    }

    public void checkForPopupAndKill() {
        int numWindows = super.getDriver().getWindowHandles().size();
        if(numWindows > 1) {
            System.out.println("numWindows : " + numWindows);
            super.getDriver().switchTo().alert().dismiss();
        }
    }
}
