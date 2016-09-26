package ru.consult;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Lenovo on 24.09.2016.
 */
public class WebDriverUtils {
    private static WebDriver driver;

    public static void startBrowser(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(1800, 2000));
    }

    public static void finishBrowser (){
            driver.quit();
    }
    public static WebDriver getDriver(){
        return driver;
    }

    public static void openPage (String url){
        driver.get(url);
    }

    public static Integer getWindowsQuantity(){
        return getDriver().getWindowHandles().size();
    }
}
