package org.example;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ResAccessTest {
    public static void setup() {
        System.setProperty("webdriver.firefox.driver", "F:\\Programs\\WebDriver\\Bin");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximaze();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://help.salesforce.com/home");
    }
}
