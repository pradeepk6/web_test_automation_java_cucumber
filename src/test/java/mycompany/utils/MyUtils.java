package mycompany.utils;

import org.openqa.selenium.WebDriver;

public class MyUtils {

    public static void checkForpopupAndKill(WebDriver driver) {
        int numWindows = driver.getWindowHandles().size();
        if(numWindows > 1) {
            System.out.println("numWindows is : " + numWindows);
            driver.switchTo().alert().dismiss();
        }

    }
}
