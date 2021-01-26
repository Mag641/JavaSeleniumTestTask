package org.example;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ResourcesAccessTest {
    public static HomePage homePage;
    public static ResultsPage resultsPage;
    public static FirstResultPage firstResultPage;
    public static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.gecko.driver", ConfProperties.getProperty("geckodriver"));

        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        resultsPage = new ResultsPage(driver);
        firstResultPage = new FirstResultPage(driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("homePage"));
    }

    @Test
    public void resourcesAccessTest() {
        homePage.inputSearchString(ConfProperties.getProperty("searchString"));
        resultsPage.clickFirstResult();
        firstResultPage.clickFirstRelatedResourceLink();

        List<WebElement> resources = driver.findElements(By.id("relatedresources_articleview_docs"));
        Assert.assertTrue(resources.size() > 0);
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}