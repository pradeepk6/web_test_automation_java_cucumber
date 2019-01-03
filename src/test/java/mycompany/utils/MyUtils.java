package mycompany.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
}
