package org.example;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ResourcesAccessTest {
    public static HomePage homePage;
    public static ResultsPage resultsPage;
    public static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.gecko.driver", ConfProperties.getProperty("geckodriver"));

        homePage = new HomePage(driver);
        resultsPage = new ResultsPage(driver);
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("homePage"));
    }

    @Test
    public void resourcesAccessTest() {
        homePage.inputSearchString(ConfProperties.getProperty("searchString"));
        homePage.clickSearchButton();
        resultsPage.clickFirstResult();
        Assert.assertTrue(driver.findElements(By.id("relatedresouces_articleview_docs")).size() > 0);
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}