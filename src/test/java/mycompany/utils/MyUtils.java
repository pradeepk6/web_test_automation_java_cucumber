package mycompany.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyUtils {

    public static void checkForPopupAndKill(WebDriver driver) {
        try {
            driver.findElement(By.linkText("No, thanks")).click();
        } catch(Exception e) {
        }
        /*
        int numWindows = driver.getWindowHandles().size();
        if(numWindows > 1) {
            System.out.println("numWindows is : " + numWindows);
            driver.switchTo().alert().dismiss();
        }
        */

    }

    public static void waitForPageLoadComplete(WebDriver driver, int specifiedTimeout) {
        Wait<WebDriver> wait = new WebDriverWait(driver, specifiedTimeout);
        wait.until(driver1 -> String
                .valueOf(((JavascriptExecutor) driver1).executeScript("return document.readyState"))
                .equals("complete"));
    }
}
