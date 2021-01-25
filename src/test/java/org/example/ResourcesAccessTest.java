package org.example;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ResourcesAccessTest {
    public static HomePage homePage;
    public static ResultsPage resultsPage;
    public static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.firefox.driver", ConfProperties.getProperty("geckodriver"));

        homePage = new HomePage(driver);
        resultsPage = new ResultsPage(driver);
        driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("homePage"));
    }

    @Test
    public void ResourcesAccessTest() {

    }
    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}