package org.example;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ResourcesAccessTest {
    public static HomePage homePage;
    public static ResultsPage resultsPage;
    public static QuickStartsResultsPage quickStartsResultsPage;
    public static FirstResultPage firstResultPage;
    public static WebDriver driver;

    @BeforeClass
    public static void setup() {
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        resultsPage = new ResultsPage(driver);
        quickStartsResultsPage = new QuickStartsResultsPage(driver);
        firstResultPage = new FirstResultPage(driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("homePage"));
    }

    @Test
    public void resourcesAccessTest() throws IOException {
        homePage.inputSearchString(ConfProperties.getProperty("searchString"));
        resultsPage.clickShowMore();
        resultsPage.clickQuickStarts();
        quickStartsResultsPage.clickFirstResult();

        Assert.assertTrue(firstResultPage.isResourcesBlockPresent());
        Assert.assertTrue(firstResultPage.isFirstRelatedResourceLinkOK());
        firstResultPage.clickFirstRelatedResource();
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}