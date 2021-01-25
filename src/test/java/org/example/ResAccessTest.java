package org.example;

import org.junit.jupiter.api.BeforeClass;
import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ResAccessTest {
    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.firefox.driver", ConfProperties.getProperty("geckodriver"));
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximaze();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("homePage"));
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}